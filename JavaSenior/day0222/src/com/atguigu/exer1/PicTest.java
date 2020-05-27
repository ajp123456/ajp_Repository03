package com.atguigu.exer1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 艾敬鹏 on 2020/2/25.
 */
public class PicTest {

//图片的加密
    @Test
        public void test1() {
        FileInputStream fis=null;
        FileOutputStream fos=null;
try {

    fis = new FileInputStream(new File("Sun Flower1.jpg"));
    fos = new FileOutputStream((new File("Sun Flower1Secret.jpg")));
    byte[] bytn = new byte[10];
    int len;
    while ((len = fis.read(bytn)) != -1) {
        for (int i = 0; i < len; i++) {
            bytn[i] = (byte) (bytn[i] ^ 5);
        }

        fos.write(bytn, 0, len);
    }
}catch (IOException e){
    e.printStackTrace();
}finally {
    if (fis!=null){
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
