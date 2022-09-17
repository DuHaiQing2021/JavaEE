import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //返回一个主页
        HttpSession httpSession=req.getSession(false);
        String userName= (String) httpSession.getAttribute("userName");

        Integer count=(Integer) httpSession.getAttribute("count");
        count+=1;
        httpSession.setAttribute("count",count);
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("<h3>欢迎"+userName+"，这是第"+count+"访问页面</h3>");
    }
}
