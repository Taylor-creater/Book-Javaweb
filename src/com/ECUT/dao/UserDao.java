package com.ECUT.dao;

import com.ECUT.pojo.User;

public interface UserDao {
    public User queryUserByUsername(String username);
    public User queryUserByUsernameAndPassword(String username,String password);
    public int saveuser(User user);


}
