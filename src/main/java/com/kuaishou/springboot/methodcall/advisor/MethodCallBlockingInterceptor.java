package com.kuaishou.springboot.methodcall.advisor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.google.common.collect.Maps;
import com.kuaishou.springboot.methodcall.annotation.MethodCallBlockingLimit;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-11
 *
 * @see MethodCallBlockingAdvisor
 * @see MethodCallBlockingLimit
 */
public class MethodCallBlockingInterceptor implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MethodCallBlockingInterceptor.class);

    private static final Map<String, BlockingQueue<Integer>> BLOCKING_QUEUE_MAP = Maps.newConcurrentMap();
    private static final String DEFAULT_NAME_FORMAT = "%s_%s";

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Method method = invocation.getMethod();
        MethodCallBlockingLimit methodCallBlockingLimit = AnnotatedElementUtils.findMergedAnnotation(method, MethodCallBlockingLimit.class);

        Assert.notNull(methodCallBlockingLimit, "@CallBlockingLimit annotation may not be null!");

        int concurrency = methodCallBlockingLimit.concurrency();
        if (concurrency <= 0) {
            return invocation.proceed();
        }

        Class<?> userClass = ClassUtils.getUserClass(invocation.getMethod().getDeclaringClass());
        String name = String.format(DEFAULT_NAME_FORMAT, userClass.getName(), method.getName());
        log.info("className: {}, methodName: {}, final keyName: {}, concurrency: {}",  userClass.getName(), method.getName(), name, concurrency);

        BlockingQueue<Integer> blockingQueue = BLOCKING_QUEUE_MAP.computeIfAbsent(name, v -> new LinkedBlockingQueue<>(concurrency));
        try {
            // blocking method, if blocking is full, thread wait here until queue is not full.
            log.info("current queue size: {}", blockingQueue.size());
            blockingQueue.put(1);
            return invocation.proceed();
        } finally {
            blockingQueue.poll();
            log.info("method done! current queue size: {}", blockingQueue.size());
        }
    }
}
