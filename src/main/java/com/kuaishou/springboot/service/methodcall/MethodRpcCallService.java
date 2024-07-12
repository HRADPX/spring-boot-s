package com.kuaishou.springboot.service.methodcall;

import org.springframework.stereotype.Service;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-11
 */
@Service
public class MethodRpcCallService {

    public String rpcMethod(String id) {
        // simulate rpc call
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // ignore
        }
        return id;
    }
}
