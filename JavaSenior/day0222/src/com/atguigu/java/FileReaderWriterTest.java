package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * Created by 艾敬鹏 on 2020/2/23.
 */
public class FileReaderWriterTest {

    //实现读取了硬盘中的文件的功能
    @Test
    public void testFileReader() throws IOException {
        //1.实例化File类对应的文件，指明要操作的文件
        File file = new File("hello.txt");
        //2.提供护体的流
        FileReader fr = new FileReader(file);
        //3.数据的读入
        //read():返回读入的一个字符，如果到达文件末尾，返回-1
        int data = fr.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fr.read();


        }
        //流的关闭
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testFileReader1() {
        FileReader fr = null;
        //1.File类的实例化
        try {
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            // /3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果到达文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一
                //错误的写法
                //     for (int i=0;i<cbuf.length;i++){
                //       System.out.println(cbuf[i]);
                // }
                //正确的
                //     for (int i = 0; i < len; i++) {
                //       System.out.println(cbuf[i]);
                // }
                //}
                //方式二
                //错误的写法
                //  String str = new String(cbuf);
                //System.out.println(str);
                //正确的写法

                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fr != null) {
                //4.流的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        }
    }

    /*
    从内存中写出数据到硬盘的文

    */
    @Test
    public void testFileWriter() throws IOException {
        //1.指明File类的文件，指明写出到的文件
        File file = new File("hello1.txt");
        //2.提供流（FileWriter)
        FileWriter fw = new FileWriter(file);
        //3.写出的操作
        fw.write("l have a dream\n");
        fw.write("you need to have a dream!");

        //4.流的关闭
        fw.close();


    }

    //文件的复制
    @Test
    public void testFileReaderFileWriter() throws IOException {
        //1.创建File类的文件，指明读入和写出的文件
        FileWriter fw = null;
        FileReader fr = null;


        //2.创建读入和写出的流
        try {
            File src = new File("hello.txt");
            File src1 = new File("hello2.txt");
            fr = new FileReader(src);
            fw = new FileWriter(src1);


            //3.数据的读入与写出
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);


            }
            //4.流的关闭
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //图片的复制
    @Test
    public void testFileInputOutputStream() throws IOException {
        FileInputStream fls = null;
        FileOutputStream fos = null;


        //1.File对应文件的实例化
        try {
            File src = new File("Sun Flower.jpg");
            File destsrc = new File("Sun Flower1.jpg");

            //2.实例化对应的流
            fls = new FileInputStream(src);
            fos = new FileOutputStream(destsrc);
            //3.流对应的写入写出
            byte[] bytn = new byte[5];
            int len;
            while ((len = fls.read(bytn)) != -1) {
                fos.write(bytn, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                fls.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //指定文件目录的复制
    public void copyFile(String srcPath,String desPath){
        FileInputStream fls=null;
        FileOutputStream fos=null;
        try{
            File file1=new File(srcPath);
            File file2=new File(desPath);
            fls=new FileInputStream(file1);
            fos=new FileOutputStream(file2);

            byte[] buffer=new byte[5];
            int len=0;
            while ((len=fls.read(buffer))!=-1){
                fos.write(buffer,0,len);


            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fls.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }







    }













    }

