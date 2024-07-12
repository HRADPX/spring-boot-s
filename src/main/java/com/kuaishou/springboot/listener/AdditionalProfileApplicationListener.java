package com.kuaishou.springboot.listener;

import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import com.google.common.collect.Sets;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-04-28
 */
public class AdditionalProfileApplicationListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        SpringApplication springApplication = event.getSpringApplication();
        if (springApplication != null) {
            Set<String> additionProfiles =
                    Sets.newHashSet(CollectionUtils.emptyIfNull(springApplication.getAdditionalProfiles()));
            additionProfiles.add("staging");
            springApplication.setAdditionalProfiles(additionProfiles.toArray(new String[0]));
        }
    }
}
