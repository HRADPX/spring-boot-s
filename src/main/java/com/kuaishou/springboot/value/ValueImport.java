package com.kuaishou.springboot.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-12-19
 */
@Data
@Component
public class ValueImport {

    @Value("${product.type}")
    public static int type;
}
