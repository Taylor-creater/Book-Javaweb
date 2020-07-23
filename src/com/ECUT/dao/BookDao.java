package com.ECUT.dao;

import com.ECUT.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();

    Integer querypageTotalCount();

    List<Book> queryForpageItems(int begin,int pageSize);

    Integer querypageTotalCountByPrice(int min, int max);

    List<Book> queryForpageItemsByPrice(int begin, int pageSize, int min, int max);
}
