import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理用户请求
        String userName=req.getParameter("userName");
        String userPassword=req.getParameter("userPassword");

        resp.setContentType("text/html;charset=utf8");
        //判断用户名或者密码是否正确
        if ("zhangsan".equals(userName) && "123456".equals(userPassword)){
            //登陆成功
            //创建会话，并保存必要的身份信息。
            HttpSession httpSession=req.getSession(true);
            //往会话中存储键值对，
            httpSession.setAttribute("userName",userName);

            //初始情况下。将登录次数设置为0,此处的零是一个object对象
            httpSession.setAttribute("count",0);
            resp.sendRedirect("index");
        }else {
            //登陆失败
            resp.getWriter().write("登录失败");
        };

    }
}
