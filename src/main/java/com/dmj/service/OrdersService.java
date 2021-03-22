package com.dmj.service;

import com.dmj.entity.Orders;
import com.dmj.vo.OrdersVo;

import java.util.List;

public interface OrdersService {
    /**
     * 添加订单
     * @param orders
     * @return
     */
    int addOrders(Orders orders);

    /**
     * 查询订单列表
     * @param ordersVo
     * @return
     */
    List<Orders> findOrdersList(OrdersVo ordersVo);

    /**
     * 修改订单
     * @param orders
     * @return
     */
    int updateOrders(Orders orders);
}
