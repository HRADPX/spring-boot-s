package com.kuaishou.springboot.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableSet;
import com.kuaishou.springboot.common.ThrowableSupplier;
import com.kuaishou.springboot.kbus.inter.ChangeData;
import com.kuaishou.springboot.kbus.inter.KBusAffinityResolver;
import com.kuaishou.springboot.kbus.inter.UpdateChangeData;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
@Component
public class KBusRunner implements ApplicationRunner {

    @Autowired
    private KBusAffinityResolver kBusService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ThrowableSupplier<ChangeData, Throwable> throwableSupplier = () -> new UpdateChangeData() {
            @Override
            public Set<String> getChangeColumns() {
                return ImmutableSet.of("material_id", "material_type");
            }
        };
        kBusService.resolver(throwableSupplier);
    }
}
