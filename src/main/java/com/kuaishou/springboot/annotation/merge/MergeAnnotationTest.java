package com.kuaishou.springboot.annotation.merge;

import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.annotation.MergedAnnotations.SearchStrategy;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-10-16
 */
public class MergeAnnotationTest {

    public static void main(String[] args) {

        findAnnotation(MergeOriginal.class, SearchStrategy.DIRECT);
        findAnnotation(MergeImpl.class, SearchStrategy.DIRECT);
        findAnnotation(MergeImpl.class, SearchStrategy.INHERITED_ANNOTATIONS);
        findAnnotation(MergeImpl.class, SearchStrategy.SUPERCLASS);
        findAnnotation(MergeImpl.class, SearchStrategy.TYPE_HIERARCHY_AND_ENCLOSING_CLASSES);



    }

    private static void findAnnotation(Class<?> clazz, SearchStrategy strategy) {
        MergedAnnotations.from(clazz, strategy)
                .stream()
                .forEach(annotation -> System.out.println(annotation.getType().getName()));
        System.out.println("----------------------------");
    }
}
