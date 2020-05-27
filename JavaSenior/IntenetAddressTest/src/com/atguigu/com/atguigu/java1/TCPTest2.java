package com.atguigu.com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络协议
 * 例题2：客户端发送文件给服务端，服务端将文件保存至本地
 *
 *
 * Created by 艾敬鹏 on 2020/2/27.
 */
public class TCPTest2 {

    @Test
    public void client() throws IOException {

        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("Lake.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        fis.close();
        os.close();
        socket.close();

    }


    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("Lake1.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        ss.close();
        socket.close();
        is.close();
        fos.close();

    }




}
