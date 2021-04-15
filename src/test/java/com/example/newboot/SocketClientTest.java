package com.example.newboot;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientTest {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8081);
            OutputStream outputStream = socket.getOutputStream();
//            PrintWriter printWriter=new PrintWriter(outputStream);
//            printWriter.write("$tmb00035ET3318/08/22 11:5804029.94,027.25,20.00,20.00$");
//            printWriter.flush();
            String mgs = "$tmb00035ET3318/08/22 11:5804029.94,027.25,20.00,20.00$";
            outputStream.write(mgs.getBytes());
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
//                int number = 0;
//                for(int i = 0; i < 4 ; i++){
//                    number += bytes[i] << i*8;
//                }
//                System.out.println(number);
                System.out.println(new String(bytes,0,len));

            }
//            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            System.out.println(fromServer.readLine());
            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
