import beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args) {
        //1.两种方法得到spring上下文
        //1.1使用ApplicationContext得到Spring上下文对象
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("spring-config.xml");

        //1.2使用BeanFactory得到Spring上下文
        BeanFactory factory= new XmlBeanFactory(
                new ClassPathResource("spring-config.xml"));


        //2.根据上下文获取到bean对象a
        User user= (User) factory.getBean("user");
//
//
//        //3.使用
//        user.sayHi("张三");
    }
}
