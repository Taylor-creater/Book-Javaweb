package com.ECUT.service.impl;

import com.ECUT.dao.UserDao;
import com.ECUT.dao.impl.UserDaoImpl;
import com.ECUT.pojo.User;
import com.ECUT.service.UserService;

public class userServiceimpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveuser(user);
    }

    @Override
    public User Login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsusername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }else {
            return true;
        }
    }
}
