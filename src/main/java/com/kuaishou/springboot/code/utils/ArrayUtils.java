package com.kuaishou.springboot.code.utils;

import java.util.Collection;
import java.util.Objects;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-08
 */
public class ArrayUtils {

    private ArrayUtils() {
    }

    public static int[] toIntArray(Collection<Integer> collection) {
        return CollectionUtils.emptyIfNull(collection)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static long[] toLongArray(Collection<Long> collection) {
        return CollectionUtils.emptyIfNull(collection)
                .stream()
                .filter(Objects::nonNull)
                .mapToLong(Long::intValue)
                .toArray();
    }


}
