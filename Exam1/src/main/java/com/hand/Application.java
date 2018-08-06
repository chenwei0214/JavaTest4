package com.hand;


import com.hand.api.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private ApplicationContext context;

    public Application(){
//        this.context=new ClassPathXmlApplicationContext("classpath:applicationContext*.xml");
        String [] resources=new String[]{"applicationContext.xml","applicationContext-mybatis.xml"};
        this.context=new ClassPathXmlApplicationContext(resources);
    }

    public void testSelectUser(){
        UserService userService = this.context.getBean(UserService.class);

        System.out.println(userService.findUserId(3l).getUsername());
    }

    public static void main(String[] args) {
        Application application=new Application();
        application.testSelectUser();
    }
}
