package com.ECUT.dao.impl;

import com.ECUT.dao.BookDao;
import com.ECUT.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql="insert into t_book(id ,name , author , price , sales , stock , img_path) values(?,?,?,?,?,?,?)";
        return update(sql,book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
      String sql="select id,name,author,price,sales,stock,img_path from t_book where id=?";
      return queryForone(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select id,name,author,price,sales,stock,img_path from t_book";
        return queryForlist(Book.class,sql);
    }

    @Override
    public Integer querypageTotalCount() {
        String sql="select count(*) from t_book";
        Number number=(Number) querySinglevalue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForpageItems(int begin,int pageSize) {
        String sql="select id,name,author,price,sales,stock,img_path from t_book limit ?,?";
       return queryForlist(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer querypageTotalCountByPrice(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number number=(Number) querySinglevalue(sql,min,max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForpageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select id,name,author,price,sales,stock,img_path from t_book where price between ? and ? order by price  limit ?,?";
        return queryForlist(Book.class,sql,min,max,begin,pageSize);
    }
}
