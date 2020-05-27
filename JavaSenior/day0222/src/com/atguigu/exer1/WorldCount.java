package com.atguigu.exer1;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 艾敬鹏 on 2020/2/25.
 */
/*
练习三：获取文本字符出现的次数，把数据写入文件
思路：
1.遍历文本的每一个字符
2.字符出现的次数存在Map中




 */


public class WorldCount {


    @Test
    public void testWorldCount(){
        FileReader fr=null;
        BufferedWriter bw=null;
        try {
            //1创建一个Map集合
            Map<Character, Integer> map = new HashMap<>();
            //2.遍历每一个字符，每一个字符出现的次数放到map中
            fr = new FileReader("dbcp.txt");
            int c = 0;
            while ((c = fr.read()) != -1) {
                //int还原成char
                char ch = (char) c;
                //判断char是否是第一次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }


            }
            //3.把map数据存到count.txt
            //3.1创建writer
            bw = new BufferedWriter(new FileWriter("worldcount.txt"));
            //3.2遍历map,再写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车=" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行=" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bw.newLine();


            }

        }catch (IOException e){
            e.printStackTrace();

        }finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
