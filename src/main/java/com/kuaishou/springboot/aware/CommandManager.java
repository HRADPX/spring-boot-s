package com.kuaishou.springboot.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.kuaishou.springboot.service.CommandService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-31
 */
@Service
public class CommandManager implements ApplicationContextAware {


    private ApplicationContext applicationContext;

    public void process() {
        CommandService commandService = createCommand();
        commandService.execute();
    }


    protected CommandService createCommand() {
        return this.applicationContext.getBean(CommandService.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
