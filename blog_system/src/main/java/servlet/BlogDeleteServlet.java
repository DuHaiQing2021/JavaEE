package servlet;

import model.Blog;
import model.BlogDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/blogDelete")
public class BlogDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //检查当前用户是否登录
        HttpSession session=req.getSession(false);
        if (session == null){
            resp.setContentType("text/html ; charset=utf8");
            resp.getWriter().write("当前尚未登录，不能删除！");
            return;
        }
        User user =(User) session.getAttribute("user");
        if (user == null){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前尚未登陆，不能删除");
            return;
        }

        //2.获取要删除的博客信息
        String blogId=req.getParameter("blogId");
        if (blogId == null || "".equals(blogId)){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前blogId参数不对");
            return;
        }
        //3.获取要删除的博客信息
        BlogDao blogDao=new BlogDao();
        Blog blog=blogDao.selectId(Integer.parseInt(blogId));
        if (blog == null ){
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前要删除的博客不存在");
            return;
        }

        //4.再次校验，当前的用户是否就是博客的作者
        if (user.getUserId() != blog.getUserId()){
            //这一点在前端这里其实也处理过~~但是此处该市再校验一次，不是坏事
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前登录用户不是作者，没有权限！");
            return;
        }
        //5.确认无误，可以删除
        blogDao.delete(Integer.parseInt(blogId));

        //6.重定向博客列表页
        resp.sendRedirect("blog_list.html");

    }
}
