package com.ECUT.service.impl;

import com.ECUT.dao.BookDao;
import com.ECUT.dao.OrderDao;
import com.ECUT.dao.OrderItemDao;
import com.ECUT.dao.impl.BookDaoImpl;
import com.ECUT.dao.impl.OrderDaoimpl;
import com.ECUT.dao.impl.OrderItemDaoImpl;
import com.ECUT.pojo.*;
import com.ECUT.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao=new OrderDaoimpl();
    OrderItemDao orderItemDao=new OrderItemDaoImpl();
    BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId= System.currentTimeMillis()+""+userId;
      orderDao.saveOrder(new Order(orderId, new Date(), cart.getTotalprice(), 0, userId));
      for(Map.Entry<Integer, CartItem> entry: cart.getItems().entrySet()){
          CartItem cartItem=entry.getValue();
          orderItemDao.saveorderItem(new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalprice(),orderId));
          Book book = bookDao.queryBookById(cartItem.getId());
          book.setSales(book.getSales()+cartItem.getCount());
          book.setStock(book.getStock()-cartItem.getCount());
          bookDao.updateBook(book);
      }

      //清空购物车
      cart.clear();
      return orderId;
    }
}
