package com.kuaishou.springboot.trx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-01-18
 */
@Service
public class BeanService {

    @Transactional
    public void execute(String s) {
//        ((BeanService) (AopContext.currentProxy())).update(s);
        System.out.println(s);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(String s) {
        System.out.println("----" + s);
    }
}
