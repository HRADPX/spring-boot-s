package com.kuaishou.springboot.kbus.inter;

import com.kuaishou.springboot.common.ThrowableSupplier;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
public interface KBusAffinityResolver {

    void resolver(ThrowableSupplier<ChangeData, Throwable> message);
}
