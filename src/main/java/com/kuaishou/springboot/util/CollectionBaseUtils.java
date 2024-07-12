package com.kuaishou.springboot.util;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import lombok.Data;
import lombok.NonNull;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-04-29
 */
public class CollectionBaseUtils {

    private CollectionBaseUtils() {

    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> List<T> getEnumValues(@NonNull Class<T> enumClass) {
        try {
            Method valuesMethod = MethodUtils.getAccessibleMethod(enumClass, "values");
            return ImmutableList.copyOf((T[]) valuesMethod.invoke(enumClass));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    static <T> boolean isSingletonSpecifiedCollection(Collection<T> list, T t) {
        Set<T> set = applySet(list, Function.identity());
        return set.size() == 1 && (Iterables.getLast(set).equals(t) || t == Iterables.getLast(set));
    }

    static <T, R> Set<R> applySet(Collection<T> list, Function<T, R> function) {
        return applyStream(list, function, null).collect(Collectors.toSet());
    }

    static <T, R> Stream<R> applyStream(Collection<T> list, Function<T, R> function, Predicate<T> predicate) {
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


    public static void main(String[] args) {

//        List<Long> integers = Arrays.asList(1L, 2L);
//        boolean singletonCollection = isSingletonSpecifiedCollection(integers, 1L);
//        System.out.println(singletonCollection);
//
//        Info info1 = new Info(1, 1, 2);
//        Info info2 = new Info(2, 2, 3);
//        Info info3 = new Info(3, 3, 4);
//        Info info4 = new Info(4, 5, 6);
//        List<Info> infoList = Arrays.asList(info1, info2, info3, info4);
//
//        Map<IdInfo, Integer> idInfoMap = infoList.stream().sorted(Comparator.comparingLong(Info::getId))
//                .collect(LinkedHashMap::new, (map, info) -> map.put(new IdInfo(info.getInfoId(), info.getDevId()), info.getDevId()), LinkedHashMap::putAll);
//        idInfoMap.forEach((key, value) ->
//                System.out.println("key: " + key + ", value: " + value));

        System.out.println(formatYTechPrice(0));

    }


    @Data
    static class Info {

        public Info(long id, int infoId, int devId) {
            this.id = id;
            this.infoId = infoId;
            this.devId = devId;
        }

        private long id;
        private int infoId;
        private int devId;
    }

    @Data
    static
    class IdInfo {

        public IdInfo(int infoId, int devId) {
            this.infoId = infoId;
            this.devId = devId;
        }

        private int infoId;
        private int devId;
    }

    private static final NumberFormat NF_WITH_2_DECIMALS = NumberFormat.getNumberInstance();
    public static String fen2YuanWithFormat(long price) {
        BigDecimal yuan = new BigDecimal(price).divide(new BigDecimal(100));
        return NF_WITH_2_DECIMALS.format(yuan.doubleValue());
    }


    public static String formatYTechPrice(long priceFen) {
        String priceYuan = fen2YuanWithFormat(priceFen);
        String[] split = priceYuan.split("\\.");
        if (split.length <= 1) {
            // 可能只有元 没有角
            return priceYuan;
        }
        String yuanPart = split[0];
        String jiaoPart = split[1];
        int yuanLength = yuanPart.length();
        switch (yuanLength) {
            case 1:
                return priceYuan;
            case 2:
                return yuanPart + "." + jiaoPart.charAt(0);
            default:
                return yuanPart;
        }
    }

}
