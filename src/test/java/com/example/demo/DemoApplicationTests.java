package com.example.demo;

import com.example.bean.User;
import com.example.dto.Exposer;
import com.example.dto.SeckillExcution;
import com.example.mapper.UserMapper;
import com.example.service.ISeckillService;
import com.example.service.IUserService;
import com.example.service.ex.RepeatKillExcption;
import com.example.service.ex.SeckillCloseException;
import com.example.service.ex.UserExistException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@ComponentScan(basePackages = {"com.example"})
@MapperScan("com.example.mapper")
@EnableTransactionManagement
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired
    IUserService userService;

    @Test
    public void contextLoads() {

        Date now=new Date();
        User u=new User(0,
                        "xiayin",
                        "769873",
                        "13775536307",
                        "387648522@qq.com",
                        1,
                        "[system]",
                        now,
                        "[Administrator]",
                        now
                        );
        userService.insertNewUser(u);

        userService.loginUser("387648522@qq.com","769873");
        System.out.println("登陆成功");

    }

}
