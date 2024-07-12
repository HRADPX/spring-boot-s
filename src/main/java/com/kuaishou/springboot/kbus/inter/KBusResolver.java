package com.kuaishou.springboot.kbus.inter;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
public interface KBusResolver {

    void resolver(ChangeData changeData);
}
