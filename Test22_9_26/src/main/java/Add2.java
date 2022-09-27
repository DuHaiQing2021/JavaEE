import com.beans.aaa.BeanLifeComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Add2 {
    public static void main(String[] args) {
        //得到Spring中bean
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring-config.xml");

        BeanLifeComponent beanLifeComponent=context.getBean("beanLifeComponent", BeanLifeComponent.class);

        beanLifeComponent.init();
        System.out.println("使用了 bean对象");
        //销毁
        context.destroy();
    }
}
