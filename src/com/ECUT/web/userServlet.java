package com.ECUT.web;

import com.ECUT.dao.UserDao;
import com.ECUT.dao.impl.UserDaoImpl;
import com.ECUT.pojo.User;
import com.ECUT.service.UserService;
import com.ECUT.service.impl.userServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class userServlet extends BaseServlet{

    UserService userService=new userServiceimpl();
    UserDao userDao=new UserDaoImpl();

    protected void loginout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if (userService.Login(new User(username,password,null))==null){
          req.setAttribute("msg","用户名或密码错误");
          req.setAttribute("username",username);
          req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("user",userService.Login(new User(username,password,null)));
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String token=(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if (token!=null&&token.equalsIgnoreCase(code)) {
            if (userService.existsusername(username)){
                req.setAttribute("usernamemsg","用户名已存在");
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
                userDao.saveuser(new User(username,password,email));
            }

        } else {
            req.setAttribute("codemsg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
