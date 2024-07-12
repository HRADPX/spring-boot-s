package com.kuaishou.springboot.code.design.context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-06-01
 */
public class ContextTest {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        IntStream.range(0, 2).forEach(i -> executorService.execute(() -> {

            HttpContextService httpContextService = new HttpContextService();
            DefaultContextService defaultContextService = new DefaultContextService();

            httpContextService.execute();
            Context context = ActionContext.actionContext().context();
            System.out.println(context.print());
            System.out.println(i + "-----" + context);
            defaultContextService.execute();
            Context idContext = ActionContext.actionContext().context();
            System.out.println(context.print());
            System.out.println(i + "-----" + idContext);
        }));
        executorService.shutdownNow();
    }
}
