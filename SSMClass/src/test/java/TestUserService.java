import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xaut.entity.User;
import xaut.service.UserService;

public class TestUserService {
    @Test
    public void testBasic(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);
        userService.addUser();
    }
}
