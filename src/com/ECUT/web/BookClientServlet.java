package com.ECUT.web;

import com.ECUT.pojo.Book;
import com.ECUT.pojo.Page;
import com.ECUT.service.BookService;
import com.ECUT.service.impl.BookServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookClientServlet extends BaseServlet {
    BookService bookService=new BookServiceimpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo;
        if (req.getParameter("pageNo")==null){
            pageNo=1;
        }else {
            pageNo= Integer.parseInt(req.getParameter("pageNo"));
        }
        int pageSize= Page.PAGE_SIZE;
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("client/bookclientservlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp );
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo;
        if (req.getParameter("pageNo")==null){
            pageNo=1;
        }else {
            pageNo= Integer.parseInt(req.getParameter("pageNo"));
        }
        int min;
        if (req.getParameter("min")==null||req.getParameter("min")==""){
            min=0;
        }else {
            min= Integer.parseInt(req.getParameter("min"));
        }
        int max;
        if (req.getParameter("max")==null||req.getParameter("max")==""){
            max=Integer.MAX_VALUE;
        }else {
            max= Integer.parseInt(req.getParameter("max"));
        }
        int pageSize= Page.PAGE_SIZE;
        Page<Book> page=bookService.pageByPrice(pageNo,pageSize,min,max);
        page.setUrl("client/bookclientservlet?action=pageByPrice&min="+min+"&max="+max);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp );
    }
}
