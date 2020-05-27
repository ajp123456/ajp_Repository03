package com.atguigu;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by 艾敬鹏 on 2020/2/22.
 */
public class FileTset {
    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        System.out.println(file1);
        File file2 = new File("D:\\workspace_idea1", "JavaSenior");
        System.out.println(file2);
        File file3 = new File(file2, "hi.txt");
        System.out.println(file3);


    }
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }
    @Test
    public void test3(){
        File file1 = new File("E：\\io");
    /*    File[] files = file1.listFiles();
        for(File f:files){


            System.out.println(f);
     */  // }
        String[] list = file1.list();
        for(String s:list){
            System.out.println(s);
        }


    }
    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
      比如：file1.renameTo(file2)为例
        要想保证返回true,需要file1在硬盘中存在的，且file2不能存在


     */

    @Test
    public void test4(){
        File file1=new File("hello.txt");
        File file2 = new File("E:\\io\\hi.txt");
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);


    }
    @Test
    public void teat5(){
        File file = new File("E:\\io");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.isHidden());



    }
    @Test
    public void test6() throws IOException{
        //文件的创建
        File file = new File("hi.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }else {
            file.delete();//文件的删除
            System.out.println("删除成功");
        }


    }
    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("d:\\io\\io1\\io3");
        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println("创建成功1");
        }
        File file2 = new File("d:\\io\\io1\\io4");
        boolean mkdirs = file2.mkdirs();//
        if (mkdirs){
            System.out.println("创建成功2");
        }


    }






}
