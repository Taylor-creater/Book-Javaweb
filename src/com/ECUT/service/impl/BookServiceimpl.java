package com.ECUT.service.impl;

import com.ECUT.dao.BookDao;
import com.ECUT.dao.impl.BookDaoImpl;
import com.ECUT.pojo.Book;
import com.ECUT.pojo.Page;
import com.ECUT.service.BookService;

import java.util.List;

public class BookServiceimpl implements BookService {
    BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
          bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page=new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount=bookDao.querypageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        if (pageNo<1){
            pageNo = 1;
        }if (pageNo>pageTotal){
            pageNo=pageTotal;
        }
        page.setPageNo(pageNo);

        int begin=(pageNo-1)*pageSize;
        List<Book> items=bookDao.queryForpageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page=new Page<Book>();
        page.setPageSize(pageSize);
        Integer pageTotalCount=bookDao.querypageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);

        if (pageNo<1){
            pageNo = 1;
        }if (pageNo>pageTotal){
            pageNo=pageTotal;
        }
        page.setPageNo(pageNo);

        int begin=(pageNo-1)*pageSize;
        List<Book> items=bookDao.queryForpageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
