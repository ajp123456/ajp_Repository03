package cn.itcast.domin.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类 使用Druid连接池
 * Created by 艾敬鹏 on 2020/4/14.
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        try {

            //1.加载配置文件
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //2.初始化连接池对象
    }

    //获取连接池对象
    public static DataSource getDataSouce(){
        return ds;
    }

    //获取Connection对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }




}
