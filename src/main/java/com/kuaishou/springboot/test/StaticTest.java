package com.kuaishou.springboot.test;

import java.util.Collections;
import java.util.List;
import java.util.Map;


import com.google.common.collect.ImmutableList;

import lombok.Data;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-26
 */
public class StaticTest {

    // 支持的原子能力
    private List<Ability> atomicAbilityList = ImmutableList.of(new Ability(1), new Ability(2), new Ability(3));

    // 支持的组合能力
    private List<Integer> supportAbilityList;

    private Map<Integer, String> aigcTypeMap = Collections.emptyMap();

    // 允许制作aigc创意的创意状态

    private String taskNameFormat = "%s-%s-%s";

    private String defaultUserName = "aigc-system";

    private long defaultExpireHours = 6L;

    private String noticeFormat = "您提交的%s，已生成完毕。请点击跳转爬山虎，预判相关创意吧！";

    private String failureNoticeFormat = "taskId:【%s】aigc 生成失败。";

    private String failureNoticeUser = "huangran";

    private String jumpUrlFormat;

    // 这两个参数是 ytech 提供测试使用
    private String appId = "82ae9e06-a64f-47b0-acf7-5c397097558c";
    private String bizName = "testTraffic";

    public String getAgicAbilityName(int aigcType) {
        return aigcTypeMap.get(aigcType);
    }


    @Data
    public static class Ability {
        private int type;
        private String abilityName;
        private String effect;

        public Ability(int type) {
            this.type = type;
        }
    }

    public Ability findNextAbility(int currentAbility, int aigcType) {
        for (Ability ability : atomicAbilityList) {
            if (ability.getType() <= currentAbility) {
                continue;
            }
            int shift = 1 << (ability.getType() - 1);
            if ((aigcType & shift) >= shift) {
                return ability;
            }
        }
        return null;
    }


    public static void main(String[] args) {

        System.out.println(StaticClass.field);
        StaticClass.setField(100);
        System.out.println(StaticClass.getField());
        System.out.println(1 << 1);
        StaticTest staticTest = new StaticTest();
        int currentAbility = 0;
        System.out.println("-----------------------");
        Ability ability = null;
        while ((ability =  staticTest.findNextAbility(currentAbility, 4)) != null) {
            System.out.println(ability);
            currentAbility = ability.getType();
        }
    }
}
