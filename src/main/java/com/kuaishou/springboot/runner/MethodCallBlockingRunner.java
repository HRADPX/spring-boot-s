package com.kuaishou.springboot.runner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.google.common.collect.Iterators;
import com.kuaishou.springboot.service.methodcall.MethodCallService;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-11
 */
//@Component
public class MethodCallBlockingRunner implements ApplicationRunner {

    @Autowired
    private MethodCallService methodCallService;

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // simulate 100 method call
        IntStream.range(0, 100).forEach(i ->
                executorService.execute(() ->
                        System.out.println(Thread.currentThread().getName() + ": " + methodCallService.execute(i))));

    }


    public static <T> Stream<List<T>> partition(Stream<T> stream, int size) {
        Iterable<List<T>> iterable = () -> Iterators.partition(stream.iterator(), size);
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
