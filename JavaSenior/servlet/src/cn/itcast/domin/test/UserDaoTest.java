package cn.itcast.domin.test;

import cn.itcast.domin.User;
import cn.itcast.domin.dao.UserDao;
import org.junit.Test;

/**
 * Created by 艾敬鹏 on 2020/4/14.
 */
public class UserDaoTest {


    @Test
    public void testLogin() {
        User loginuser = new User();
        loginuser.setUsername("superbaby");
        loginuser.setPassword("123");
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);


    }


}
