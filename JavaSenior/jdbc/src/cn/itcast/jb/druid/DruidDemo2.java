package cn.itcast.jb.druid;

import cn.itcast.jb.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 艾敬鹏 on 2020/4/12.
 */
//使用新的工具类
public class DruidDemo2 {
    public static void main(String[] args) {
        //给account表添加一条记录
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql="insert into account values(null,?,?)";
           //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4给？赋值
            pstmt.setString(1,"wangwu");
            pstmt.setDouble(2,3000);
            //5.执行sql
            int count= pstmt.executeUpdate();
            System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pstmt,conn);
        }
    }
}
