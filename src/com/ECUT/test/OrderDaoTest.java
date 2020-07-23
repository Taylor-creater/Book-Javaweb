package com.ECUT.test;

import com.ECUT.dao.OrderDao;
import com.ECUT.dao.impl.OrderDaoimpl;
import com.ECUT.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
OrderDao orderDao=new OrderDaoimpl();
    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234",new Date(),new BigDecimal(10),0,2));
    }
}