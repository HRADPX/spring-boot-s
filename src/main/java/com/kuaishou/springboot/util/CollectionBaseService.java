package com.kuaishou.springboot.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.lang.Nullable;


/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-11-12
 */
public interface CollectionBaseService {

    Function<Integer, Long> INTEGER_LONG_FUNCTION = Integer::longValue;
    Function<String, Long> STRING_LONG_FUNCTION = NumberUtils::toLong;
    Function<Long, Integer> LONG_INTEGER_FUNCTION = Long::intValue;

    static <T, K> Map<K, List<T>> partitionByFunction(Collection<T> collections, Function<T, K> function) {
        return applyStream(collections).collect(Collectors.groupingBy(function));
    }

    static <T> T getFirstObject(Collection<T> list) {
        return getFirstObject(list, null, null);
    }

    static <T> T getFirstObject(Collection<T> list, @Nullable Predicate<T> predicate) {
        return getFirstObject(list, predicate, null);
    }

    static <T> T getFirstObject(Collection<T> list, T defaultValue) {
        return getFirstObject(list, null, defaultValue);
    }

    static <T> T getFirstObject(Collection<T> list, @Nullable Predicate<T> predicate, T defaultValue) {
        return applyStream(list, Function.identity(), predicate).findFirst().orElse(defaultValue);
    }

    static <T> T getAnyObject(Collection<T> list) {
        return applyStream(list).findAny().orElse(null);
    }

    static <T, R> int distinctCount(Collection<T> list, Function<T, R> function) {
        return (int) applyStream(list, function).distinct().count();
    }

    static <T, R> int distinctCount(Collection<T> list, Function<T, R> function, Predicate<T> predicate) {
        return (int) applyStream(list, function, predicate).distinct().count();
    }


    static <T, R> List<R> applyList(Collection<T> list, Function<T, R> function) {
        return applyStream(list, function).collect(Collectors.toList());
    }

    static <T, R> List<R> applyList(Collection<T> list, Function<T, R> function, @Nullable Predicate<T> predicate) {
        return applyStream(list, function, predicate).collect(Collectors.toList());
    }

    static <T, R> Set<R> applySet(Collection<T> list, Function<T, R> function) {
        return applyStream(list, function, null).collect(Collectors.toSet());
    }

    static <T, R> Set<R> applySet(Collection<T> list, Function<T, R> function, @Nullable Predicate<T> predicate) {
        return applyStream(list, function, predicate).collect(Collectors.toSet());
    }

    static <T, K, V> Map<K, V> applyMap(Collection<T> list, Function<T, K> mapperKey, Function<T, V> mapperValue) {
        return applyStream(list).collect(Collectors.toMap(mapperKey, mapperValue, (k1, k2) -> k1));
    }

    static <T> Stream<T> applyStream(Collection<T> list) {
        return CollectionUtils.emptyIfNull(list).stream()
                .filter(Objects::nonNull);
    }

    static <T, R> Stream<R> applyStream(Collection<T> list, Function<T, R> function) {
        return applyStream(list, function, null);
    }

    static <T, R> Stream<R> applyStream(Collection<T> list, Function<T, R> function, @Nullable Predicate<T> predicate) {
        return CollectionUtils.emptyIfNull(list).stream()
                .filter(Objects::nonNull)
                .filter(Optional.ofNullable(predicate).orElse(t -> true))
                .map(t -> apply(t, function))
                .filter(Objects::nonNull);
    }

    static <T, R> R apply(T t, Function<T, R> function) {
        try {
            return function.apply(t);
        } catch (Exception e) {
            return null;
        }
    }

    static <T> Function<T, Long> trans2LongFunction(Function<T, Integer> function) {
        return function.andThen(INTEGER_LONG_FUNCTION);
    }
}
