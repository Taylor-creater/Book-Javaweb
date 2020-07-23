package com.ECUT.web;

import com.ECUT.dao.UserDao;
import com.ECUT.dao.impl.UserDaoImpl;
import com.ECUT.pojo.User;
import com.ECUT.service.UserService;
import com.ECUT.service.impl.userServiceimpl;
import com.google.code.kaptcha.servlet.KaptchaServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class RegisterServlet extends HttpServlet {
    private UserService userService=new userServiceimpl();
    UserDao userDao=new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String token=(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        System.out.println(token);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if (token.equalsIgnoreCase(code)) {
            if (userService.existsusername(username)){
                System.out.println("用户名"+username+"已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
                userDao.saveuser(new User(username,password,email));
            }

        } else {
            System.out.println("验证码"+code+"错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
