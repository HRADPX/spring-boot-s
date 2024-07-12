package com.kuaishou.springboot.code.design.context;

import com.kuaishou.springboot.code.design.util.SleepUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-01
 */
public class HttpContextService {

    public void execute() {
        SleepUtils.sleep(1000);
        ActionContext.actionContext().context().setName(Thread.currentThread().getName());
    }
}
