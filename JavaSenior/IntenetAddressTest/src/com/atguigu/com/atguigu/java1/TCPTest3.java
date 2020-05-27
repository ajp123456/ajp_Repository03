package com.atguigu.com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 * 并关闭相应的连接。
 *
 *
 * Created by 艾敬鹏 on 2020/2/27.
 */
public class TCPTest3 {


    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos=null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8203);
            os = socket.getOutputStream();
            fis = new FileInputStream(new File("Lake.jpg"));
            byte[] buffer=new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            //关闭数据的输出
            socket.shutdownOutput();


            InputStream is = socket.getInputStream();
            //ByteArrayOutputStream
            baos = new ByteArrayOutputStream();
            byte[] bufferr=new byte[1024];
            int len1;
            while ((len1=is.read(bufferr))!=-1) {
                baos.write(bufferr,0,len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }






    }

    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os=null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(8203);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("Lake2.jpg"));
            byte[] buffer=new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }



            os = socket.getOutputStream();
            os.write("你好，美女，照片我已收到，非常漂亮".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }




    }
}
