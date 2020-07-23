package com.ECUT.test;

import com.ECUT.pojo.User;
import com.ECUT.service.UserService;
import com.ECUT.service.impl.userServiceimpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
        UserService userService=new userServiceimpl();
    @Test
    public void registerUser() {
         // userService.registerUser(new User("xiaogang","8888","111@qq.com"));
        userService.registerUser(new User("xuxiang","8888","120@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.Login(new User("xuxian","8888",null)));
    }

    @Test
    public void existsusername() {
        if (userService.existsusername("xuxian")==false){
            System.out.println("用户名可用");
        }else {
            System.out.println("no");
        }
    }
}