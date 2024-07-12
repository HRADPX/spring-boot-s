package com.kuaishou.springboot.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @author huangran <huangran@kuaishou.com>
 * Created on 2022-11-18
 */
public class SelectorServer {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel server = ServerSocketChannel.open();
        server.socket().bind(new InetSocketAddress(8080));

        // 将其注册到 selector 中，监听 OP_ACCEPT 事件
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            if (CollectionUtils.isEmpty(selectionKeys)) {
                continue;
            }

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {

                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    // 有已经接受的新的到服务端的连接
                    SocketChannel socketChannel = server.accept();

                    // 有新的连接并不代表这个通道就有数据，
                    // 这里将这个新的 SocketChannel 注册到 Selector，监听 OP_READ 事件，等待数据
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    // 有数据可读
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                    int num = socketChannel.read(readBuffer);
                    if (num > 0) {

                        System.out.println("收到数据：" + new String(readBuffer.array()).trim());

                        // 给客户端返回数据
                        ByteBuffer buffer = ByteBuffer.wrap("返回给客户端数据....".getBytes());
                        socketChannel.write(buffer);
                    } else if (num == -1) {
                        // -1 表示关闭了连接
                        socketChannel.close();
                    }
                }
            }
        }
    }
}
