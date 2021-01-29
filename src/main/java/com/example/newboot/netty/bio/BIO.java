package com.example.newboot.netty.bio;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BIO {

    final static Logger log = LoggerFactory.getLogger(BIO.class);
    private static ExecutorService pool = Executors.newFixedThreadPool(5);
    ServerSocket serverSocket;


    public static void main(String[] args) throws IOException {
        BIO b = new BIO();
        b.bio();
    }

    public void bio() throws IOException {
        serverSocket = new ServerSocket(6666);
        while (true) {
            final Socket socket = serverSocket.accept();
            pool.execute(() -> {
                handle(socket);
            });
        }
    }

    private void handle(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream is = socket.getInputStream();
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                String meg = new String(bytes, 0, len);
                log.info("消息 ：", meg);
                System.out.println(meg);
            }
        } catch (IOException e) {
            log.error("io异常", e);
        } finally {
            try {
                socket.close();
                log.info("服务正常关闭");
            } catch (Exception e) {
                log.error("关闭异常", e);
            }
        }
    }

}
