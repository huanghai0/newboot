package com.example.newboot.netty.nio;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class test2 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel socketChannel = serverSocketChannel.accept();

        int length = 8;
        while (true) {
            int readLength = 0;
            if (readLength < length) {
                long l = socketChannel.read(byteBuffers);
                readLength += l;

                Arrays.asList(byteBuffers).stream().map(buffer -> "postion=" + buffer.position() + ", limit=" + buffer.limit()).forEach(System.out::println);

            }
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            int writeLength = 0;
            while (writeLength < length) {
                long l = socketChannel.write(byteBuffers);
                writeLength += l;

            }

            Arrays.asList(byteBuffers).forEach(buffer -> buffer.clear());
            System.out.println("readLength= " + readLength + ", writeLength= " + writeLength + ", megger = " + length);
        }


    }
}
