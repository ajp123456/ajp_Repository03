package com.atguigu.java;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 *1.ObjectInputStream和ObjectOutputStream
 *2.作用：用于存储和读取基本类型数据或对象的处理流。强大之处在于可以把java中的对象写入到
 * 数据源中，也能把对象从数据源中还原出来
 *
 *3.要想一个Java对象是可序列化的，需满足相应的要求
 *
 *4.序列化的机制：
 * 对象序列化机制允许把内存中的Java对象转换成与平台无关的二进制流，
 * 从而允许把这种二进制流持久的保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。
 * 当其他程序获取了这种二进制流，就可以恢复原来的Java对象
 *
 *
 *
 * Created by 艾敬鹏 on 2020/2/26.
 */
public class ObjectInputOutputStreamTest {
/*
序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
使用ObjectOutputStream实现

 */
@Test
    public  void testObjectoutputStream(){
    ObjectOutputStream oos=null;
    try {
        oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject(new String("我爱北京天安门"));
        oos.flush();
        oos.writeObject(new Person("张三",25));
        oos.flush();
    }catch (IOException e){
        e.printStackTrace();
    }finally {

        if (oos!=null){
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }






}
//反序列化过程

@Test
    public void test1(){
    ObjectInputStream ois=null;
    try{
        ois=new ObjectInputStream(new FileInputStream("object.dat"));
        Object obj = ois.readObject();
        String str=(String) obj;
        System.out.println(str);
        Person p=(Person) ois.readObject();
        System.out.println(p);


    }catch (IOException e) {
        e.printStackTrace();
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }finally {
        if (ois!=null){
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





}

@Test
    public void test3() throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object1.dat"));
        oos.writeObject(new String("你好帅"));
        oos.flush();
        oos.close();
}




}
