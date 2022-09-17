import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Message{
    public String from;
    public String to;
    public String message;
}

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper=new ObjectMapper();

    //改成数据库，就不需要这个变量了
//    private List<Message> messagesList=new ArrayList<>();
//    Message message=new Message();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //获取消息列表
        List<Message> messagesList=load();
        //此处需要使用ObjectMapper把java对象，转成json格式字符串
        String jsonString=objectMapper.writeValueAsString(messagesList);
//        System.out.println("jsonString"+jsonString);

        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理提交消息
       Message message= objectMapper.readValue(req.getInputStream(),Message.class);
        //最简单的保存方法就是保存在内存中
//       messagesList.add(message);
        save(message);
        //通过ContentType来告知页面，返回的数据是json格式
        //有了这样的声明此时Jquery ajax就会自动的帮我们把字符串转成js对象。
        //如果没有，jquery ajax就只是当成字符串来处理的~~
       resp.setContentType("application/json; charset=utf8");
       resp.getWriter().write("{\"ok\":true}");
    }
    //把一条消息保存在数据库中
    private void save(Message message){
        Connection connection=null;
        PreparedStatement statement=null;
        try {
            //1.和数据库建立连接
            connection=DBUtil.getConnection();
            //2.构造SQL语句
            String sql="insert into message value(?,?,?)";
            statement=connection.prepareStatement(sql);
            statement.setString(1,message.from);
            statement.setString(2,message.to);
            statement.setString(3,message.message);
            //3.执行sql
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           //4.释放资源
           DBUtil.close(connection,statement,null);
        }

    }
    //从数据库中取出所有消息
    private List<Message> load(){

        List<Message> messagesList=new ArrayList<>();

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            connection=DBUtil.getConnection();
            String sql="select * from message";
            //在数据库中构造sql
            statement=connection.prepareStatement(sql);
            resultSet=statement.executeQuery();

            while (resultSet.next()){
                Message message=new Message();
                message.from=resultSet.getString("from");
                message.to=resultSet.getString("to");
                message.message=resultSet.getString("message");
                messagesList.add(message);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return messagesList;
    }

}
