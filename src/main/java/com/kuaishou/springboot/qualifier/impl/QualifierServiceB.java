package com.kuaishou.springboot.qualifier.impl;

import org.springframework.stereotype.Service;

import com.kuaishou.springboot.qualifier.annotation.TypeQualifier;
import com.kuaishou.springboot.qualifier.annotation.TypeQualifier.FormatType;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-12-08
 */
@Service
@TypeQualifier(type = FormatType.COMMON)
public class QualifierServiceB extends QualifierServiceA {

    @Override
    public String toString() {
        return FormatType.COMMON.name() + "::B";
    }
}
