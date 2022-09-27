import com.beans.aaa.User;
import com.beans.aaa.UserBean;
import com.beans.aaa.UserController;
import com.beans.aaa.UserController2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Add {
    public static void main(String[] args) {
        //1.先得到上下文对象
        ApplicationContext context=
                new ClassPathXmlApplicationContext("spring-config.xml");
//        //2.得到bean
//        UserController controller =
//                context.getBean("userController",UserController.class);
//        //3.使用 bean
//        controller.sayHi();

//        User user=context.getBean("user1",User.class);
//        System.out.println(user);
        UserController2 userController2=context.getBean("userController2",UserController2.class);

        userController2.sayHi();


    }
}
