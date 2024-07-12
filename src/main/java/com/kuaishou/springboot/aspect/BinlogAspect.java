package com.kuaishou.springboot.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Repository;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2021-12-15
 */
@Repository
@Aspect
public class BinlogAspect {

    private static final Logger logger = LoggerFactory.getLogger(BinlogAspect.class);

    @Pointcut("execution(* com.kuaishou.springboot.binlog.*.resolve(..))")
    public void binlogPointCut() {
        logger.info("binlog consumer interceptor");
    }

//    @Around("binlogPointCut()")
//    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//        Object[] args = pjp.getArgs();
//        System.out.println(Arrays.toString(args));
//        args[0] = "showgif";
//        return pjp.proceed();
//    }

    @Before("binlogPointCut() && args(a, b)")
    public void beforeAdvice(JoinPoint pjp, String a, Object b) {

        System.out.println(pjp.getSignature().getName());
        System.out.println(pjp.getSignature().getDeclaringType().getSimpleName());
        System.out.println(pjp.getSignature().getDeclaringTypeName());
        System.out.println(Modifier.isPublic(pjp.getSignature().getModifiers())); // 方法修饰符
        System.out.println(pjp.getSourceLocation());
        System.out.println(pjp.getKind());
        System.out.println(pjp.getStaticPart().getSignature());
    }

    @Around("binlogPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Annotation[] declaredAnnotations = signature.getMethod().getDeclaredAnnotations();
        Annotation mergedAnnotation = AnnotatedElementUtils.findMergedAnnotation(signature.getMethod(),
                ConditionalOnWebApplication.class);

        System.out.println("---输出方法注解---");
        System.out.println(mergedAnnotation);
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation.annotationType());
        }
        System.out.println("---输出方法注解---");
        return pjp.proceed();
    }
}
