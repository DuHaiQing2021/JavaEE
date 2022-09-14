import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要将父类的doGet干掉，不能调用父类的！！！
//        super.doGet(req, resp);

        System.out.println("hello world!  console");

        //如果不给响应页面中任何内容就会出现空白页面
//        resp.getWriter().write("hello world! web"+System.currentTimeMillis());

    }
}
