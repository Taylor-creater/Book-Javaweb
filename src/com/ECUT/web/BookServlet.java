package com.ECUT.web;

import com.ECUT.pojo.Book;
import com.ECUT.pojo.Page;
import com.ECUT.service.BookService;
import com.ECUT.service.impl.BookServiceimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BookServlet extends BaseServlet {
     BookService bookService=new BookServiceimpl();
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int pageNo=0;
           pageNo= Integer.parseInt(req.getParameter("pageTotal"));
            pageNo++;//保证每次加完图书后都能自动跳转到最后一页
            Book book=new Book();
            BeanUtils.populate(book,req.getParameterMap());
            bookService.addBook(book);
            //按F5刷新会再一次完成上一次的请求，会重复添加相同的书，所以不用请求转发，用重定向
            //req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
            resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        int i=Integer.parseInt(id);
       bookService.deleteBookById(i);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Book book=new Book();
        try {
            BeanUtils.populate(book,req.getParameterMap());
            bookService.updateBook(book);
            resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        int i=Integer.parseInt(id);
        Book book = bookService.queryBookById(i);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo;
        if (req.getParameter("pageNo")==null){
             pageNo=1;
        }else {
            pageNo= Integer.parseInt(req.getParameter("pageNo"));
        }
        int pageSize= Page.PAGE_SIZE;
        Page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp );
    }

}
