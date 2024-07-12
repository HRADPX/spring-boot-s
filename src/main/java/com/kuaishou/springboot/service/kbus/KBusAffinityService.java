package com.kuaishou.springboot.service.kbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaishou.springboot.common.ThrowableSupplier;
import com.kuaishou.springboot.kbus.annotation.KBusHandler;
import com.kuaishou.springboot.kbus.inter.ChangeData;
import com.kuaishou.springboot.kbus.inter.KBusAffinityResolver;
import com.kuaishou.springboot.methodcall.annotation.MethodCallBlockingLimit;
import com.kuaishou.springboot.service.methodcall.MethodCallService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
@Slf4j
@Service
public class KBusAffinityService implements KBusAffinityResolver {

    @Autowired
    private MethodCallService methodCallService;

    @Override
    @KBusHandler(includeFields = "material_type")
    public void resolver(ThrowableSupplier<ChangeData, Throwable> message) {
        try {
            log.info("changeColumns: {}", message.get().getChangeColumns());
        } catch (Throwable throwable) {
            log.info(",", throwable);
        }
    }

    @MethodCallBlockingLimit(concurrency = 1)
    public String execute(int id) {
       return methodCallService.execute(id);
    }
}
