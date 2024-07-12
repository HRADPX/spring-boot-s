package com.kuaishou.springboot.kbus.advisor;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableSet;
import com.kuaishou.springboot.common.ThrowableSupplier;
import com.kuaishou.springboot.kbus.annotation.KBusHandler;
import com.kuaishou.springboot.kbus.inter.ChangeData;
import com.kuaishou.springboot.kbus.inter.UpdateChangeData;
import com.kuaishou.springboot.util.CollectionBaseService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-17
 */
public class KBusHandlerInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(KBusHandlerInterceptor.class);

    private boolean publicOnly;

    public KBusHandlerInterceptor() {
        this(true);
    }

    public KBusHandlerInterceptor(boolean publicOnly) {
        this.setPublicOnly(publicOnly);
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Method method = invocation.getMethod();
        // 默认只对 public 方法有效
        if (publicOnly && !Modifier.isPublic(method.getModifiers())) {
            return invocation.proceed();
        }

        KBusHandler kBusHandler = AnnotatedElementUtils.findMergedAnnotation(invocation.getMethod(), KBusHandler.class);
        // 理论上不会为空
        Assert.notNull(kBusHandler, "KBusHandler may not be null!");
        if (ArrayUtils.isEmpty(kBusHandler.includeFields())) {
            return invocation.proceed();
        }

        Object[] arguments = invocation.getArguments();
        UpdateChangeData updateChangedEventRow = Arrays.stream(arguments)
                .map(this::findUpdateEvent)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);

        if (updateChangedEventRow == null) {
            return null;
        }

        return executeConsumer(ImmutableSet.copyOf(kBusHandler.includeFields()), updateChangedEventRow)
               ? invocation.proceed() : null;
    }

    private boolean executeConsumer(Set<String> includeFieldList, UpdateChangeData changeEventData) {

        Set<String> changeColumns = changeEventData.getChangeColumns();
        if (CollectionUtils.isEmpty(changeColumns)) {
            return true;
        }

        return CollectionUtils.isSubCollection(includeFieldList, changeColumns)
                || CollectionUtils.isSubCollection(caseFormatLowerCamel(includeFieldList), changeColumns);
    }

    private UpdateChangeData findUpdateEvent(Object arg) {
        if (ClassUtils.isAssignable(ChangeData.class, arg.getClass()) && arg instanceof UpdateChangeData) {
            return (UpdateChangeData) arg;
        }
        if (!ClassUtils.isAssignable(ThrowableSupplier.class, arg.getClass())) {
            return null;
        }
        @SuppressWarnings("rawtypes") ThrowableSupplier ts = (ThrowableSupplier) arg;
        try {
            return (UpdateChangeData) ts.get();
        } catch (Throwable throwable) {
            return null;
        }
    }

    public void setPublicOnly(boolean publicOnly) {
        this.publicOnly = publicOnly;
    }

    private static Set<String> caseFormatLowerCamel(Collection<String> originalFieldList) {
        return CollectionBaseService.applySet(originalFieldList,
                fieldName -> CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName));
    }
}
