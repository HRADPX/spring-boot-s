package com.kuaishou.springboot.qualifier.impl;

import org.springframework.stereotype.Service;

import com.kuaishou.springboot.qualifier.QualifierService;
import com.kuaishou.springboot.qualifier.annotation.TypeQualifier;
import com.kuaishou.springboot.qualifier.annotation.TypeQualifier.FormatType;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-12-08
 */
@Service
@TypeQualifier(type = FormatType.ABSOLUTELY)
public class QualifierServiceD implements QualifierService {

    @Override
    public String toString() {
        return FormatType.ABSOLUTELY.name() + "::D";
    }
}
