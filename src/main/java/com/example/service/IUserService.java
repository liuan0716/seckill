package com.example.service;

import com.example.bean.User;
import com.example.service.ex.UpdateUserInfoFailException;
import com.example.service.ex.UserExistException;

public interface IUserService {
    /**
     *
     * @param name
     * @return
     */
    int checkExistUser(String name);

    /**
     *
     * @param email
     * @return
     */
    int checkExitEmail(String email);

    /**
     *
     * @param phone
     * @return
     */
    int checkExitPhone(String phone);

    /**
     *
     * @param user
     * @return
     */
    int insertNewUser(User user) throws UserExistException;

    /**
     *
     * @param user
     * @return
     */
    int updateUserInfo(User user) throws UpdateUserInfoFailException;

    /**
     *
     * @param email
     * @param password
     * @return
     */
    int loginUser(String email,String password);

    /**
     *
     * @param email
     * @return
     */
    User queryUserByEmail(String email);
}
