package com.ithaima.dao;/*
@outhor shkstart
@date 2019/12/11-11:22
用户的持久层借口
*/

import com.ithaima.domain.User;
import java.util.List;

public interface IUserDao {
//@Select("select * from user")
    /**一个用户可以有多个账户
     * 查询所有用户,同时还要获取到当前用户的所属账户信息
     * @return
     */
    List<User> findAll();
    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

}
