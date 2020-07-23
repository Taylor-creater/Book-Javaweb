package com.ECUT.service;

import com.ECUT.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
