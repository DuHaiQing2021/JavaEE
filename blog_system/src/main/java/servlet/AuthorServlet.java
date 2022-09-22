package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Blog;
import model.BlogDao;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorInfo")
public class AuthorServlet extends HttpServlet {
    private ObjectMapper objectMapper=new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf8");
        String param=req.getParameter("blogId");
        if (param == null || "".equals(param)){
            //参数缺少
            resp.getWriter().write("{\"ok\":false,\"reason\":\"参数缺失\"}");
            return;
        }
        //根据当前blogId在数据库中进行查找，找到对应的blog对象，再进一步根据blog对象的查看作者id
        BlogDao blogDao=new BlogDao();
        Blog blog=blogDao.selectId(Integer.parseInt(param));
        if (blog == null){
            resp.getWriter().write("{\"ok\":false,\"reason\":\"查询的博客不存在\"}");
            return;
        }

        //根据blog对象，查询到用户对象
         UserDao userDao=new UserDao();
         User author=userDao.selectById(blog.getUserId());
         System.out.println();
         if (author == null){
             resp.getWriter().write("{\"ok\":false,\"reason\":\"该博客作者不存在\"}");
             return;
         }
         //注意要把密码去掉
         author.setPassword("");
         resp.getWriter().write(objectMapper.writeValueAsString(author));
    }
}
