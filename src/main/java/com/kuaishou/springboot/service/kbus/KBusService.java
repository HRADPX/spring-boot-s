package com.kuaishou.springboot.service.kbus;

import org.springframework.stereotype.Service;

import com.kuaishou.springboot.kbus.annotation.KBusHandler;
import com.kuaishou.springboot.kbus.inter.ChangeData;
import com.kuaishou.springboot.kbus.inter.KBusResolver;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
@Slf4j
@Service
public class KBusService implements KBusResolver {

    @KBusHandler(includeFields = {"materialType"})
    @Override
    public void resolver(ChangeData changeData) {
        log.info("------------changeColumns: {}", changeData.getChangeColumns());
    }
}
