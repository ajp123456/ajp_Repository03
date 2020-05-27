package cn.itcast.jb.util;
import java.sql.*;
import java.util.Scanner;

//练习：需求，1.通过键盘录入用户名和密码 2.判断用户是否登录成功

/**
 * Created by 艾敬鹏 on 2020/4/12.
 */
public class JdbcDemo9 {
    public static void main(String[] args) {
        //1.键盘录入，接受用户名和密码
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2.调用方法
        boolean flag = new JdbcDemo9().login(username, password);
        //3.判断结果，输出不同语句
        if (flag){
            //登陆成功
            System.out.println("登录成功");
        }else {
            System.out.println("用户名或密码错误");
        }

    }





//登录方法
    public boolean login(String username,String password){
        if (username==null||password==null){
            return false;

        }
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        //1.获取连接
        try {
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql="select * from user where username='"+username+"' and password='"+password+"'";
            //3.获取执行sql 的对象
            stmt = conn.createStatement();
            //4.执行查询
            rs = stmt.executeQuery(sql);
//            if (rs.next()){
//                return true;
//            }else {
//                return false;
//            }
            return rs.next();




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(stmt,conn,rs);

        }


        return false;
    }
    //登录方法,使用PreparedStatement
    public boolean login2(String username,String password){
        if (username==null||password==null){
            return false;

        }
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        //1.获取连接
        try {
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql="select * from user where username=? and password=?";
            //3.获取执行sql 的对象
            pstmt = conn.prepareStatement(sql);
            //4.给？赋值
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            //5.执行查询
            rs = pstmt.executeQuery();
//            if (rs.next()){
//                return true;
//            }else {
//                return false;
//            }
            return rs.next();




        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn,rs);

        }


        return false;
    }





}
