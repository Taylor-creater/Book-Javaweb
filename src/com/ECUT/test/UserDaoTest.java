package com.ECUT.test;

import com.ECUT.dao.UserDao;
import com.ECUT.dao.impl.UserDaoImpl;
import com.ECUT.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("xwb"));
//        if (userDao.queryUserByUsername("xwb")==null){
//            System.out.println("用户名可用！！");
//        }else {
//            System.out.println("用户名已存在！");
//        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
         if(userDao.queryUserByUsernameAndPassword("xwb","123456")==null){
             System.out.println("用户名或密码错误，登陆失败！");
         }
         else {
             System.out.println("登陆成功！！");
         }
    }

    @Test
    public void saveuser() {
        if(userDao.saveuser(new User("xiaoming","654321","1114689763@qq.com"))==-1){
            System.out.println("插入失败");
        }else {
            System.out.println("插入成功！");
        }
    }
}