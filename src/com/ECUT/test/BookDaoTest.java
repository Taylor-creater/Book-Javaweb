package com.ECUT.test;

import com.ECUT.dao.BookDao;
import com.ECUT.dao.impl.BaseDao;
import com.ECUT.dao.impl.BookDaoImpl;
import com.ECUT.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(55,"安徒生童话","某某",new BigDecimal(60),100,200,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(20,"安徒生童话","某某",new BigDecimal(60),100,200,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        for (Book querybook :bookDao.queryBooks()) {
            System.out.println(querybook);
        }
    }

    @Test
    public void querypageTotalCount() {
        System.out.println(bookDao.querypageTotalCount());
    }

    @Test
    public void queryForpageItems() {
        List<Book> books = bookDao.queryForpageItems(1, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void querypageTotalCountByPrice() {
        System.out.println(bookDao.querypageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForpageItemsByPrice() {
        for (Book book : bookDao.queryForpageItemsByPrice(3, 4, 10, 50)) {
            System.out.println(book);
        }
    }
}