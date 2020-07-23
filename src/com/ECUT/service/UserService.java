package com.ECUT.service;

import com.ECUT.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User Login(User user);

    /**
     *
     * @param username
     * @return 返回true说明用户名存在不可使用，false说明用户名不存在可以使用
     */
    public boolean existsusername(String username);
}
