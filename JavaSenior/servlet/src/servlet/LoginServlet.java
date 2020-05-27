package servlet;

import cn.itcast.domin.User;
import cn.itcast.domin.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 艾敬鹏 on 2020/4/14.
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.设置请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.封装user对象
        User loginUser=new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //4.调用UserDao的login方法
        UserDao dao=new UserDao();
        User user = dao.login(loginUser);

        //5.判断user
        if (user==null){
            //登陆失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            //登录成功
            //存储数据
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }
    }
}
