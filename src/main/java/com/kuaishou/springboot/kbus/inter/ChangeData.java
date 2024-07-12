package com.kuaishou.springboot.kbus.inter;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-08-19
 */
public interface ChangeData {


    default Set<String> getChangeColumns() {
        return ImmutableSet.of("material_id", "material_type");
    }
}
