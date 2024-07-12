package com.kuaishou.springboot.code.utils;

import java.util.Collection;
import java.util.Collections;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-08
 */
public class CollectionUtils {

    @SuppressWarnings("rawtypes")
    public static final Collection EMPTY_COLLECTION = Collections.emptyList();

    private CollectionUtils() {
    }


    @SuppressWarnings("unchecked") // OK, empty collection is compatible with any type
    public static <T> Collection<T> emptyCollection() {
        return EMPTY_COLLECTION;
    }

    public static <T> Collection<T> emptyIfNull(final Collection<T> coll) {
        return coll == null ? emptyCollection() : coll;
    }

}
