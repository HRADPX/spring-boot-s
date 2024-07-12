package com.kuaishou.springboot.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-18
 */
public class Server {

    public static void main(String[] args) throws IOException {

        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(9999));

    }
}
