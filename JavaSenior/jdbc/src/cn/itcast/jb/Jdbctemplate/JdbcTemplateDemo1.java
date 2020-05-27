package cn.itcast.jb.Jdbctemplate;

import cn.itcast.jb.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by 艾敬鹏 on 2020/4/12.
 */
//jdbcTemplate入门学习
public class JdbcTemplateDemo1 {
//    public static void main(String[] args) {
//        //1.导入jar包
//        //2.创建JDBCTemplate对象
//        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSouce());
//        //3.调用方法
//        //
//        String sql="update account set balance=5000 where id=?";
//        int count = template.update(sql, 3);
//        System.out.println(count);
//
//    }
public static void main(String[] args) {
    //1.导入jar包
    //2.创建Template对象
    JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSouce());
    //3.定义sql语句
    String sql="update account set balance=1000 where id=?";
    int i = template.update(sql, 1);
    System.out.println(i);


}

}
