package com.kuaishou.springboot.processor;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import com.google.common.collect.Sets;
import com.kuaishou.springboot.annotation.chain.AutowiredEnhance;
import com.kuaishou.springboot.annotation.chain.ComponentEnhance;
import com.kuaishou.springboot.util.CollectionBaseService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-07-29
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 10)
public class AutowiredEnhanceBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware {

    private static final Logger log = LoggerFactory.getLogger(AutowiredEnhanceBeanPostProcessor.class);

    private static final String REPLACE_INFO_FORMAT = "beanClass: [%s], fieldName: [%s] has filtered,"
            + " before value: %s, after filter value: %s, total filter size: [%s]";

    private ListableBeanFactory beanFactory;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), field -> {
            AnnotationAttributes ann = findAutowiredEnhanceAnnotation(field);
            if (ann == null) {
                return;
            }
            if (Modifier.isStatic(field.getModifiers())) {
                return;
            }
            Set<String> excludeNames = Sets.newHashSet(ann.getStringArray("excludeNames"));
            Set<Class<?>> excludeClasses = Sets.newHashSet(ann.getClassArray("excludeClasses"));
            if (CollectionUtils.isEmpty(excludeClasses) && CollectionUtils.isEmpty(excludeNames)) {
                return;
            }
            doResolverBean(new AutowiredEnhanceHandler(bean, field, excludeNames, excludeClasses));
        });

        return bean;
    }

    /**
     * 2022-07-29 暂定只支持 List 和 Set
     */
    private void doResolverBean(AutowiredEnhanceHandler autowiredHandler) throws IllegalAccessException {
        Assert.notNull(autowiredHandler, "autowiredHandler must not be null!");

        Field field = autowiredHandler.getField();
        Class<?> type = field.getType();

        Object bean = autowiredHandler.getBean();
        Object fieldValue = field.get(bean);

        ResolvableType resolvableType = ResolvableType.forField(field);

        if (ClassUtils.isAssignable(Collection.class, type) && type.isInterface()) {
            Class<?> elementType = resolvableType.asCollection().resolveGeneric();
            if (elementType == null) {
                return;
            }
            autowiredHandler.collectionHandler((Collection<?>) fieldValue);
        }
    }

    private AnnotationAttributes findAutowiredEnhanceAnnotation(AccessibleObject ao) {
        if (ao.getAnnotations().length > 0) {
            return AnnotatedElementUtils.getMergedAnnotationAttributes(ao, AutowiredEnhance.class);
        }
        return null;
    }

    private String getBeanNameByBean(Object bean) {
        Assert.notNull(bean, "bean must not be null!");
        ComponentEnhance annotation = AnnotatedElementUtils.findMergedAnnotation(bean.getClass(), ComponentEnhance.class);
        if (annotation == null) {
            return "";
        }
        if (StringUtils.isNotBlank(annotation.handlerName())) {
            return annotation.handlerName();
        }
        // 获取 beanName
        Map<String, ?> beansTypeMap = beanFactory.getBeansOfType(bean.getClass());

        return CollectionUtils.emptyIfNull(beansTypeMap.entrySet())
                .stream()
                .filter(entry -> bean == entry.getValue() || ClassUtils.getUserClass(entry.getValue().getClass()) == bean.getClass())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ListableBeanFactory) beanFactory;
    }

    private class AutowiredEnhanceHandler {

        private final Object bean;

        private final Field field;

        private final Set<String> excludeNames;

        private final Set<Class<?>> excludeClasses;

        AutowiredEnhanceHandler(Object bean, Field field, Set<String> excludeNames, Set<Class<?>> excludeClasses) {

            Assert.notNull(bean, "bean must not be null!");
            Assert.notNull(field, "field must not be null!");

            this.bean = bean;
            this.field = field;
            this.excludeClasses = CollectionBaseService.applySet(excludeClasses, Function.identity());
            this.excludeNames = CollectionBaseService.applySet(excludeNames, Function.identity(), StringUtils::isNotBlank);
        }

        public void collectionHandler(Collection<?> originalColl) {

            Collection<?> finalValueColl = null;
            if (ClassUtils.isAssignable(List.class, field.getType())) {
                finalValueColl = CollectionBaseService.applyList(originalColl, Function.identity(), this::doFilter);
            }
            if (ClassUtils.isAssignable(Set.class, field.getType())) {
                finalValueColl = CollectionBaseService.applySet(originalColl, Function.identity(), this::doFilter);
            }
            if (finalValueColl == null || CollectionUtils.emptyIfNull(originalColl).size() == finalValueColl.size()) {
                return;
            }
            log.info(String.format(REPLACE_INFO_FORMAT, bean.getClass().getName(), field.getName(), originalColl,
                    finalValueColl, originalColl.size() - finalValueColl.size()));
        }

        private boolean doFilter(Object candidate) {
            Assert.notNull(candidate, "candidate must not be null!");
            return !(excludeNames.contains(getBeanNameByBean(candidate))
                    || excludeClasses.contains(candidate.getClass()));
        }

        private void setNewValue(Object newValue) throws IllegalAccessException {
            field.setAccessible(true);
            field.set(bean, newValue);
        }

        public Object getBean() {
            return bean;
        }

        public Field getField() {
            return field;
        }
    }
}
