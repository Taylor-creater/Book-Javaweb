package com.ECUT.test;

import com.ECUT.pojo.Cart;
import com.ECUT.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"web",1,new BigDecimal(30),new BigDecimal(30)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"web",1,new BigDecimal(30),new BigDecimal(30)));
        System.out.println(cart);
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"web",1,new BigDecimal(30),new BigDecimal(30)));
        System.out.println(cart);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"java从入门到放弃",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"web",1,new BigDecimal(30),new BigDecimal(30)));
        System.out.println(cart);
        cart.updateCount(1,3);
        System.out.println(cart);
    }
}