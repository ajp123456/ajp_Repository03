package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * Created by 艾敬鹏 on 2020/2/26.
 */
/*
处理流之二：转换流的使用
1.转换流：属于字符流
   InputStreamReader：将一个字节的输入流转换为字符的输入流
   OutputStreamWriter：将一个字符的输出流转换为字节的输出流

2.作用：提供字节流与字符流的转换

3.解码：字节，字节数组---》字符数组，字符串
  编码：字符数组，字符串---》字节，字节数组

4.字符集




 */
public class InputStreamReaderTest{

    @Test
    public void test1() throws IOException {
        FileInputStream fls = new FileInputStream("dbcp.txt");
        InputStreamReader isr = new InputStreamReader(fls);
        char[] cbuf = new char[10];
        int len;
        while ((len=isr.read(cbuf))!=-1){

            String str=new String(cbuf,0,len);
            System.out.println(str);



        }
        isr.close();


    }
    /*
综合使用InputStreamReader和OuputStreamWriter
*/
    @Test
    public void test2() throws IOException {
        File file1 = new File("dbcp.txt");
        File file2 = new File("dbcp_gbk.txt");
        FileInputStream fis=new FileInputStream(file1);
        FileOutputStream fos=new FileOutputStream(file2);
        InputStreamReader isr=new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osr=new OutputStreamWriter(fos,"gbk");

        //读取过程
        char[] cbuf=new char[10];
        int len;
        while ((len=isr.read(cbuf))!=-1){
            osr.write(cbuf,0,len);
        }
        isr.close();
        fos.close();





    }
    @Test
    public void test3() throws IOException {
        FileInputStream fis = new FileInputStream(new File("dbcp.txt"));
        FileOutputStream fos = new FileOutputStream(new File("dbcp_gbk2.txt"));
        InputStreamReader isr=new InputStreamReader(fis);
        OutputStreamWriter osw=new OutputStreamWriter(fos);
//        byte[] buffer=new byte[1024];
        char[] cbuf=new char[1024];
        int len;
        while ((len=isr.read(cbuf))!=-1){
            osw.write(cbuf,0,len);
        }
        isr.close();
        osw.close();


    }














}
