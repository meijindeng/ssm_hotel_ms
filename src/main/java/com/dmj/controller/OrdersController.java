package com.dmj.controller;

import com.alibaba.fastjson.JSON;
import com.dmj.entity.Orders;
import com.dmj.service.OrdersService;
import com.dmj.utils.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    /**
     * 添加订单
     * @param orders
     * @return
     */
    @RequestMapping("/addOrders")
    @ResponseBody
    public String addOrders(Orders orders){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用添加订单的方法
        if(ordersService.addOrders(orders)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"酒店预订成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"酒店预订失败，请重试！");
        }
        return JSON.toJSONString(map);
    }

}
