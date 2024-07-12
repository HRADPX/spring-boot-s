package com.kuaishou.springboot.code.design.context;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-01
 */
public class ActionContext {

    private static final ThreadLocal<Context> CONTEXT = ThreadLocal.withInitial(Context::new);

    private static class ContextHolder {
        private static final ActionContext ACTION_CONTEXT = new ActionContext();
    }

    public static ActionContext actionContext() {
        return ContextHolder.ACTION_CONTEXT;
    }

    public Context context() {
        return CONTEXT.get();
    }
}
