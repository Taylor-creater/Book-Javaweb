package com.ECUT.test;

import com.ECUT.pojo.Cart;
import com.ECUT.pojo.CartItem;
import com.ECUT.service.OrderService;
import com.ECUT.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"web",1,new BigDecimal(30),new BigDecimal(30)));
        OrderService orderService=new OrderServiceImpl();
        orderService.createOrder(cart,6);
    }
}