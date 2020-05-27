package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 艾敬鹏 on 2020/3/29.
 */
@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //post 获取请求参数
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
//        System.out.println("post");
//        System.out.println(username);
        String[] hobbies = request.getParameterValues("hobby");
        for(String s:hobbies){
            System.out.println(s);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数
//        String username = request.getParameter("username");
//        System.out.println("get");
//        System.out.println(username);
        this.doPost(request,response);


    }
}
