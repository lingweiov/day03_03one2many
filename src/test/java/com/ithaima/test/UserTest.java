package com.ithaima.test;/*
@outhor shkstart
@date 2019/12/11-14:23
*/


import com.ithaima.dao.IAccountDao;
import com.ithaima.dao.IUserDao;
import com.ithaima.domain.Account;
import com.ithaima.domain.AccountUser;
import com.ithaima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserTest {
   /* public static void main(String[] args) throws  Exception {

    }*/
   private InputStream in;
   private SqlSession session;
   private IUserDao userDao;
   private SqlSessionFactory factory;
   @Before//用于在测试方法执行之前执行
   public void init() throws Exception {
       //1.读取配置文件
       in = Resources.getResourceAsStream("SqlMapConfig.xml");
       //2.创建SqlSessionFactory工厂
        factory=new SqlSessionFactoryBuilder().build(in);
       //3.使用工厂生产SqlSession对象
        session = factory.openSession();
       //4.使用SqlSession创建Dao接口的代理对象
       userDao = session.getMapper(IUserDao.class);
   }
   @After//用于在测试方法执行之后执行
   public void destroy() throws Exception {
       //提交事务
       session.commit();
       //6.释放资源
       session.close();
       in.close();
   }
   /**
    * 查询所有账户信息
    * */
    @Test
    public void testFindAll()  {
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("--每个用户的信息--- ");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

}
