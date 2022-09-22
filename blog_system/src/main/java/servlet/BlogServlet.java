package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

//通过这个类，来处理/blog路径对应的请求
@WebServlet("/blog")
public class BlogServlet extends HelloServlet {
    private ObjectMapper objectMapper=new ObjectMapper();
    //这个方法用来获取数据库中的博客列表
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先尝试获取到req中的bolgId参数，如果参数存在，说明是要req博客详情
        //如果参数不存在，说明是要请求博客列表
        BlogDao blogDao =new BlogDao();
        String param=req.getParameter("blogId");
        resp.setContentType("application/json;charset=utf8");
        if (param == null){
            //不存在参数，获取博客列表
            List<Blog> blogList=blogDao.selectAll();
            //将blogList对象转换成JSON格式，此处转换的时候json调用了getPostTime（）方法
            String respJson=objectMapper.writeValueAsString(blogList);
            resp.getWriter().write(respJson);
        }else {
            //存在参数，获取博客详情
            int blogId=Integer.parseInt(param);
            Blog blog=blogDao.selectId(blogId);
            String respJson=objectMapper.writeValueAsString(blog);
            resp.getWriter().write(respJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession(false);
        if (session ==null){
            //当前用户没有登录
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前用户未登录，不能提交blog");
            return;
        }
        User user=(User) session.getAttribute("user");
        if (user==null){
            //当前用户没有登录
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前用户未登录，不能提交blog");
            return;
        }
        req.setCharacterEncoding("utf8");
        //先从请求中取出参数,博客的标题和正文
        String title=req.getParameter("title");
        String content=req.getParameter("content");


        if (title == null||"".equals(title)||content==null||"".equals(content)){
            //直接告诉客户端，请求参数不对
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("提交博客失败！缺少必要的参数！");
            return;
        }
        //构造blog对象
        //此处要给Blog设置的属性，主要是title，content，userId（作者信息）
        Blog blog=new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        //作者id就是当前提交这个博客的用户的身份信息！
//        blog.setBlogId(user.getUserId());
        blog.setUserId(user.getUserId());

        BlogDao blogDao=new BlogDao();
        blogDao.insert(blog);

        resp.sendRedirect("blog_list.html");
    }
}
