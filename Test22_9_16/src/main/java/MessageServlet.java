import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Message{
    public String from;
    public String to;
    public String message;

}
@WebServlet("/messageWall")
public class MessageServlet extends HttpServlet {
    private ObjectMapper objectMapper=new ObjectMapper();

    private List<Message> messageList=new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        获取收到的消息列表

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
       // 处理提交的消息请求
       Message message=objectMapper.readValue(req.getInputStream(),Message.class);
       //

    }
}
