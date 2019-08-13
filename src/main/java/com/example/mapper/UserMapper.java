package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     *
     * @param user
     * @return
     */
    int insertNewUser(User user);


    User queryUserByName(@Param("username") String name,@Param("email") String email,@Param("phone") String phone);

    /**
     *
     * @param user
     * @return
     */
    int updateInfo(User user);
}
