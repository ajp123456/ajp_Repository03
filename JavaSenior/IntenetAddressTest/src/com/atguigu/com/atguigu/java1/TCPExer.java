package com.atguigu.com.atguigu.java1;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求：客户端给服务端发送文本，服务端将文本转成大写再返回给客户端
 * Created by 艾敬鹏 on 2020/2/28.
 */
public class TCPExer {
    @Test
    public void client() throws IOException {
            Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),2365);
            OutputStream os = socket.getOutputStream();
            os.write("aijingpeng,haoshuai!".getBytes());
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            byte[] buffer=new byte[10];
            int len;
            while ((len=is.read(buffer))!=-1){
                String s = new String(buffer,0,len);
            }



    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(2365);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] buffer=new byte[20];
        int len;
        String str;
        while ((len=is.read(buffer))!=-1){
            str=new String(buffer,0,len);
            str.toUpperCase();

        }
        OutputStream os = socket.getOutputStream();
        os.write(str);




    }

}