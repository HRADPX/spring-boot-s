package com.kuaishou.springboot.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2024-05-19
 */
@Service
public class BService {

    @Autowired
    private AService aService;
}
