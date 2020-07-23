package com.ECUT.dao.impl;

import com.ECUT.dao.OrderItemDao;
import com.ECUT.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveorderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(name,count,price,total_price,order_id)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalprice(),orderItem.getOrderId());

    }
}
