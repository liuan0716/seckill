package com.example.controller;

import com.example.bean.User;
import com.example.dto.ResponseResult;
import com.example.service.UserService;
import com.example.service.ex.PasswordNotMatchException;
import com.example.service.ex.UserExistException;
import com.example.service.ex.UserNotExistException;
import com.example.service.ex.UserRegisterFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }

    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String goToReg(){
        return "register";
    }

    @RequestMapping(value = "/reg/execution",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult executeRegister(@RequestParam("username") String username,
                                          @RequestParam("email") String email,
                                          @RequestParam("password") String password,
                                          @RequestParam("tel") String phone){

        if("".equals(username)||"".equals(email)||"".equals(password)||"".equals(phone)){
            return new ResponseResult(-1,"请填写注册信息");
        }
        Date now=new Date();
        User user=new User(0,username,password,phone,email,0,"[system]",now,"[administrator]",now);

        try {
            userService.insertNewUser(user);
            return new ResponseResult(1,"success");
        } catch (UserRegisterFailedException e) {
            return new ResponseResult(-2,e.getMessage());
        } catch (UserExistException e) {
            return new ResponseResult(-3,e.getMessage());
        }

    }

    @RequestMapping(value="/login/execution",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult executeLogin(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletResponse response){
        try {
            int res=userService.loginUser(email,password);
            User user=userService.queryUserByEmail(email);
            user.setPassword("");
            //使用cookie将登陆信息存在客户端，减轻服务端压力
            Cookie cookie1=new Cookie("username",user.getName());
            Cookie cookie2 =new Cookie("phone",user.getPhone());
            cookie1.setMaxAge(60 * 60);// 设置为30min，生命周期
            cookie1.setPath("/");//设置Cookie的使用路径
            response.addCookie(cookie1);// 保存cookie到客户端
            cookie2.setMaxAge(60 * 60);// 设置为30min，生命周期
            cookie2.setPath("/");//设置Cookie的使用路径
            response.addCookie(cookie2);// 保存cookie到客户端
            return new ResponseResult<>(1,"success");
        } catch (PasswordNotMatchException e) {
            return new ResponseResult<>(-1,e.getMessage());
        } catch (UserNotExistException e) {
            return new ResponseResult<>(-2,e.getMessage());
        }
    }









}
