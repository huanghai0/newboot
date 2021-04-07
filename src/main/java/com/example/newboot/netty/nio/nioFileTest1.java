package com.example.newboot.netty.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class nioFileTest1 {

    private final static Logger log = LoggerFactory.getLogger(nioFileTest1.class);

    public static void main(String[] args) {
        try {
            String str = nioFileChannel();
            System.out.println(str);
        } catch (IOException e) {
            log.error("error: {}", e);
        }
    }

    public static String nioFileChannel() throws IOException {
        //读文件
        FileInputStream fileInputStream = new FileInputStream("ts.txt");
        FileChannel channelin = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        //写文件
        FileOutputStream fileOutputStream = new FileOutputStream("ts2.txt");
        FileChannel channelout = fileOutputStream.getChannel();

        StringBuilder stringBuilder = new StringBuilder();

        int len = 0;
        while (true) {
            byteBuffer.clear();
            len = channelin.read(byteBuffer);
            if (len == -1) break;
            //     log.info("文件内容：{}", new String(byteBuffer.array()));
            stringBuilder.append(new String(byteBuffer.array()));

            byteBuffer.flip();

            channelout.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
        return stringBuilder.toString();
    }

}
