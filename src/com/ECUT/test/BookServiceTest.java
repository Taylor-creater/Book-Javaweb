package com.ECUT.test;

import com.ECUT.dao.BookDao;
import com.ECUT.dao.impl.BookDaoImpl;
import com.ECUT.pojo.Book;
import com.ECUT.pojo.Page;
import com.ECUT.service.BookService;
import com.ECUT.service.impl.BookServiceimpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService=new BookServiceimpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(21,"新华字典","某某",new BigDecimal(22),100,200,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(21,"水浒传","施耐庵",new BigDecimal(22),100,200,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(3, 4, 10, 50);
        for(Book book :page.getItems()){
            System.out.println( book);
        }
    }
}