package com.example.service;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import com.example.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService implements IUserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public int checkExistUser(String name) {
        if("".equals(name)){
            return -1;
        }
        User user=userMapper.queryUserByName(name,null,null);
        if(user!=null){
            return 1;
        }
        return -2;
    }

    @Override
    public int checkExitEmail(String email) {
        if("".equals(email)){
            return -1;
        }
        User user=userMapper.queryUserByName(null,email,null);
        if(user!=null){

            return 1;
        }
        return -2;
    }

    @Override
    public int checkExitPhone(String phone) {
        if("".equals(phone)){
            return -1;
        }
        User user=userMapper.queryUserByName(null,null,phone);
        if(user!=null){

            return 1;
        }
        return -2;
    }

    @Override
    public int insertNewUser(User user) throws UserRegisterFailedException,UserExistException{
        if(user!=null){
            //-2代表此用户名不存在于数据库
            if(checkExistUser(user.getName())==-2 && checkExitEmail(user.getEmail())==-2 && checkExitPhone(user.getPhone())==-2){
                //密码加密MD5
                user.setPassword(getMD5(user.getPassword()));
                int res=userMapper.insertNewUser(user);
                if(res<=0){
                    throw new UserRegisterFailedException("用户注册失败");
                }

            }else{
                throw new UserExistException("用户存在，无法注册");
            }
        }
        return 1;
    }

    @Override
    public int updateUserInfo(User user) throws UpdateUserInfoFailException{
        if(user!=null){
            //1代表用户存在
            if(checkExistUser(user.getName())==1){
                int res=userMapper.updateInfo(user);
                if(res<=0){
                    throw new UpdateUserInfoFailException("更新用户信息失败");
                }
            }
        }
        return 1;
    }

    @Override
    public int loginUser(String email, String password) throws PasswordNotMatchException,UserNotExistException{

        if(!"".equals(email)){
            User user=userMapper.queryUserByName(null,email,null);
            if(user!=null && !"".equals(password)){
                if(user.getPassword().equals(getMD5(password))){
                    return 1;
                }else{
                    throw new PasswordNotMatchException("密码不匹配");
                }
            }
            throw new UserNotExistException("用户不存在");
        }
        throw new UserNotExistException("用户不存在");
    }

    @Override
    public User queryUserByEmail(String email) {
        if("".equals(email)){
            return null;
        }
        return userMapper.queryUserByName(null,email,null);
    }

    //md5加密
    private String getMD5(String password){
        String slat="abcdefg++---(()))";
        return DigestUtils.md5DigestAsHex((slat+password).getBytes());
    }


}
