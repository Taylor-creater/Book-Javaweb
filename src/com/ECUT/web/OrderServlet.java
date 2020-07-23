package com.ECUT.web;

import com.ECUT.dao.BookDao;
import com.ECUT.dao.impl.BookDaoImpl;
import com.ECUT.pojo.Cart;
import com.ECUT.pojo.User;
import com.ECUT.service.OrderService;
import com.ECUT.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
OrderService orderService=new OrderServiceImpl();
BookDao bookDao=new BookDaoImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user=(User) req.getSession().getAttribute("user");
        if (user==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
        String orderId=orderService.createOrder(cart, user.getId());
        //req.setAttribute("orderId", orderId);
       // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
