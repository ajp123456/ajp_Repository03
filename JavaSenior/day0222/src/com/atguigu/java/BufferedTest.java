package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * Created by 艾敬鹏 on 2020/2/24.
 */
/*
1.处理流:
BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter

2.作用：提供流的读取写度
  提高速度的原因：内部提供了一个缓冲区
*/
public class BufferedTest {


    @Test
    public void BufferedStreamTest() {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {


            //1.造文件
            File file1 = new File("Sun Flower.jpg");
            File file2 = new File("Sun Flower2.jpg");
            //2.造流
            //2.1造节点流
            FileInputStream fls = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //2.2造缓冲流
            bis = new BufferedInputStream(fls);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取与写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }
    //方法：实现文件的复制
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis=null;
        BufferedOutputStream bos=null;

     try {
         File srcFile = new File(srcPath);


         File destFile = new File(destPath);
         FileOutputStream fos = new FileOutputStream(destFile);
         FileInputStream fis = new FileInputStream(srcFile);
         bis = new BufferedInputStream(fis);
         bos = new BufferedOutputStream(fos);
         byte[] buffer = new byte[10];
         int len;
         while ((len = bis.read(buffer))!=-1){
             bos.write(buffer,0, len);
         }
     }catch (IOException e){
         e.printStackTrace();
     }finally {
         if (bis!=null){
             try {
                 bis.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         if (bos!=null){
             try {
                 bos.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

     }
    }
    @Test
    public void testCopyFileWithBuffered(){
        long start=System.currentTimeMillis();
        String srcPath="Sun Flower.jpg";
        String destPath="Sun Flower3.jpg";
        copyFileWithBuffered(srcPath,destPath);
        long end=System.currentTimeMillis();
        System.out.println("复制操作所需要的时间:"+(end-start));








    }
    /*
    使用BufferedReader和BufferedWriter来实现文本文件的复制


     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br=null;
        BufferedWriter bw=null;
        try {
            File srcFile = new File("dbcp.txt");
            File descFile = new File("dbcp1.txt");
            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(descFile);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            //char[] cbuf = new char[10];
            //int len;
            //while ((len = fr.read(cbuf)) != -1) {
              //  fw.write(cbuf, 0, len);
            String data;
            while ((data=br.readLine())!=null){

                bw.write(data);//data不包含换行符
                bw.newLine();



            }
        }catch(IOException e){
                e.printStackTrace();
            }finally {


            if (br!=null){

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw!=null){


                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }









        }






    }




}