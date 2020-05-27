package cn.itcast.domin.dao;

import cn.itcast.domin.User;
import cn.itcast.domin.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 * Created by 艾敬鹏 on 2020/4/14.
 */
public class UserDao {
    //声明JDBCTemplate对象共用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSouce());

    //登录方法
    public User login(User loginUser){
        try {
            String sql="select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;//user包含用户全部数据，没有查询到，返回null
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;

        }
    }
}
