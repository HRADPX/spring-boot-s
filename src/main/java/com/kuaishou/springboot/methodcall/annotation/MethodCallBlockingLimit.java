package com.kuaishou.springboot.methodcall.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-11
 *
 * 接口限速注解
 *
 * 该注解的作用是限制调用其他业务接口的频率，内部通过一个固定长度阻塞队列 {@link java.util.concurrent.BlockingQueue} 来限制同一时间最多
 * 有多个请求调用。每调用一次接口，就会向队列里添加一个元素，接口返回则从队列中移除一个元素。如果当前队列已满，则会阻塞住线程，等待请求返回队列非
 * 空后完成入队后发送请求.
 *
 * Note:
 *  1) 如果 {{@link #concurrency()}} 返回的是一个非正数，表示不进行限速，此时相当于此注解不生效。
 *  2) 在多个方法使用该注解，内部通过一个 {@link java.util.Map} 维护映射关系，Key 默认是全路径类名 + 方法名来保证唯一性。
 * ⚠️ 如果是方法重载请慎用或修改 key 的生成逻辑。
 *
 * @see com.kuaishou.growth.creative.component.methodcall.advisor.MethodCallBlockingInterceptor
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MethodCallBlockingLimit {

    /**
     * 并发度，同一时刻最多多少个请求，超过则会阻塞当前方法执行
     * 如果是非正数，表示不限速，此时注解不生效
     */
    int concurrency();
}
