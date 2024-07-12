package com.kuaishou.springboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.kuaishou.springboot.aware.CommandManager;
import com.kuaishou.springboot.lookup.LookUpManage;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-31
 */
//@Service
public class CommandRunner implements ApplicationRunner {


    @Autowired
    private CommandManager commandManager;
    @Autowired
    private LookUpManage lookUpManage;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        commandManager.process();
        commandManager.process();
        lookUpManage.process();
        lookUpManage.process();
    }
}
