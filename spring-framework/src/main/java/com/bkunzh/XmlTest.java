package com.bkunzh;

import com.alibaba.fastjson.JSON;
import com.bkunzh.dto.MyBean;
import com.bkunzh.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/6/3
 */
public class XmlTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService);
        System.out.println(userService.myService);
        userService.myService.say();

        // env profile 实现方式1:在开发环境环境变量spring_env设置为dev，测试环境环境变量spring_env设置为test
        System.out.println("环境变量spring_env=" + context.getEnvironment().getProperty("spring_env"));
        MyBean myBean = context.getBean("myBean", MyBean.class);
        System.out.println(JSON.toJSONString(myBean));

        // 构造器声明map
        System.out.println(JSON.toJSONString(context.getBean("mymap")));
    }
}
