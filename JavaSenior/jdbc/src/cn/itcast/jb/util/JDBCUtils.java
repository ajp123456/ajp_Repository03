package cn.itcast.jb.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * Created by 艾敬鹏 on 2020/4/11.
 */
//获取连接
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     *
     * @return
     * @throws SQLException
     */
    static {
        try {
            //1.创建properties集合类
            Properties pro = new Properties();
            //获取src路径下的文件的方式---》ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            //2.加载文件
//            pro.load(new FileReader("C://Users//艾敬鹏//IdeaProjects//JavaSenior//jdbc//src//cn//itcast//jb//util//jdbc.properties"));
            pro.load(new FileReader(path));

            //3.获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        }   catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
//释放资源
    public static void close(Statement stmt, Connection conn, ResultSet rs){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
