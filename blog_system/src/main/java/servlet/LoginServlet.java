package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    ObjectMapper objectMapper=new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        //1.获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if (username == null||"".equals(username)|| password==null||"".equals(password)){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前的用户名或者密码为空！");
            return;
        }

        //2.和数据库的内容比较
        UserDao userDao=new UserDao();
        User user=userDao.selectByName(username);

        if (user==null || !user.getPassword().equals(password)){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("用户名或者密码错误！");
            return;
        }

        //3.如果通过，创建会话
        HttpSession session = req.getSession(true);
        //把刚才的用户信息，存储到会话中
        session.setAttribute("user",user);
        //4.返回一个重定向，跳转到博客列表页
        resp.sendRedirect("blog_list.html");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf8");
        resp.setCharacterEncoding("utf8");
        HttpSession session=req.getSession(false);

        if (session==null){
            //检测会话是否存在，不存在说明未登录
            User user=new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }

        User user=(User) session.getAttribute("user");

        if (user==null){
            //虽然有会话，但是会话里没有user对象，也是为未登录
            user=new User();
            resp.getWriter().write(objectMapper.writeValueAsString(user));
            return;
        }
        //已经登录的状态
        user.setPassword("");//密码不要传给前端
//        System.out.println(user);
        String s = objectMapper.writeValueAsString(user);
//        System.out.println(s);
        resp.getWriter().write(s);

    }
}
