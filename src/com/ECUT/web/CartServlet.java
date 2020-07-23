package com.ECUT.web;

import com.ECUT.pojo.Book;
import com.ECUT.pojo.Cart;
import com.ECUT.pojo.CartItem;
import com.ECUT.service.BookService;
import com.ECUT.service.impl.BookServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
BookService bookService=new BookServiceimpl();
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=0;
      id= Integer.parseInt(req.getParameter("id"));
      Book book=bookService.queryBookById(id);
        CartItem cartItem=new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastname",cartItem.getName());
       resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=0;
        id= Integer.parseInt(req.getParameter("id"));
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(id);
       // resp.sendRedirect(req.getContextPath()+"/pages/cart/cart.jsp");
        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
    }
    protected void clearItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart=(Cart) req.getSession().getAttribute("cart");
        cart.clear();
        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
    }

    protected void updateItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      int id= Integer.parseInt(req.getParameter("id"));
       int count= Integer.parseInt(req.getParameter("count"));
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        cart.updateCount(id,count);
        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
    }
}
