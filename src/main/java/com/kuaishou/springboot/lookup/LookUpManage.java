package com.kuaishou.springboot.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import com.kuaishou.springboot.service.CommandService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-31
 * LookUp 注解的规范：<public|protected> [abstract] <return-type> theMethodName(no-arguments);
 */
@Service
public abstract class LookUpManage {

    public void process() {
        CommandService commandService = createCommand();
        commandService.execute();
    }

    @Lookup
    protected abstract CommandService createCommand();
}
