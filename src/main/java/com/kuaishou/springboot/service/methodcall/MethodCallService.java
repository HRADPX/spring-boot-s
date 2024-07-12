package com.kuaishou.springboot.service.methodcall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuaishou.springboot.methodcall.annotation.MethodCallBlockingLimit;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-11
 */
@Service
public class MethodCallService {

    @Autowired
    private MethodRpcCallService methodRpcCallService;

    @MethodCallBlockingLimit(concurrency = 1)
    public String execute(int id) {
        // simulate rpc method call, 1 second return response.
        return methodRpcCallService.rpcMethod(String.valueOf(id));
    }
}
