package com.atguigu.com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议的网络编程
 * Created by 艾敬鹏 on 2020/2/28.
 */
public class UDPTest {
    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();
        String str=new String("我是UDO方式发送的导弹");
        byte[] data=str.getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);
        socket.send(packet);
        socket.close();

    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] buffer=new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));
        socket.close();





    }

}
