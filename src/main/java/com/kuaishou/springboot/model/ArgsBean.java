package com.kuaishou.springboot.model;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-15
 */
@Component
public class ArgsBean {

    public ArgsBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        if (debug) {
            System.out.println(files);
        }
        // if run with "--debug logfile.txt" prints ["logfile.txt"]
    }
}
