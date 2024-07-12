package com.kuaishou.springboot.qualifier.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.kuaishou.springboot.qualifier.QualifierService;
import com.kuaishou.springboot.qualifier.annotation.TypeQualifier;
import com.kuaishou.springboot.qualifier.annotation.TypeQualifier.FormatType;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2023-12-08
 */
@Component
public class QualifierRunner implements CommandLineRunner {

    @Autowired
    private QualifierService qualifierServiceA;
    @Autowired
    private QualifierService qualifierServiceB;

    @Autowired
    @TypeQualifier(type = FormatType.COMMON)
    private List<QualifierService> commonQualifierServiceList;

    @Autowired
    @TypeQualifier(type = FormatType.UNIQUE)
    private List<QualifierService> uniqueQualifierServiceList;

    @Autowired
    @TypeQualifier(type = FormatType.ABSOLUTELY)
    private List<QualifierService> absolutelyQualifierServiceList;


    @Override
    public void run(String... args) throws Exception {
        System.out.println(qualifierServiceA);
        System.out.println(qualifierServiceB);
        System.out.println(commonQualifierServiceList);
        System.out.println(uniqueQualifierServiceList);
        System.out.println(absolutelyQualifierServiceList);
    }
}
