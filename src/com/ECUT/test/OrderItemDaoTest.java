package com.ECUT.test;

import com.ECUT.dao.OrderItemDao;
import com.ECUT.dao.impl.OrderItemDaoImpl;
import com.ECUT.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
 OrderItemDao orderItemDao=new OrderItemDaoImpl();
    @Test
    public void saveorderItem() {
        orderItemDao.saveorderItem(new OrderItem(null,"dadad",2,new BigDecimal(15),new BigDecimal(30),"1234"));
    }
}