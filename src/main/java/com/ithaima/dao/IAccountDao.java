package com.ithaima.dao;/*
@outhor shkstart
@date 2019/12/13-17:09
*/

import com.ithaima.domain.Account;
import com.ithaima.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    /**一个账户只能有一个用户
     * 查询所有账户,同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户,同时要获取到当前账户的用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();

}
