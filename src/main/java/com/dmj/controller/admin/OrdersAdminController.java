package com.dmj.controller.admin;

import com.alibaba.fastjson.JSON;
import com.dmj.entity.Orders;
import com.dmj.service.OrdersService;
import com.dmj.utils.DataGridViewResult;
import com.dmj.utils.SystemConstant;
import com.dmj.vo.OrdersVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/orders")
public class OrdersAdminController {

    @Resource
    private OrdersService ordersService;

    /**
     * 查询订单列表
     * @param ordersVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(OrdersVo ordersVo){
        //设置分页信息
        PageHelper.startPage(ordersVo.getPage(),ordersVo.getLimit());
        //调用分页查询订单列表的方法
        List<Orders> ordersList = ordersService.findOrdersList(ordersVo);
        //创建分页对象
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(ordersList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 确认订单
     * @param orders
     * @return
     */
    @RequestMapping("/confirmOrders")
    public String confirmOrders(Orders orders){
        Map<String,Object> map = new HashMap<String,Object>();
        //将订单状态改成已确认(status=2)
        orders.setStatus(2);
        //调用修改的方法
        if(ordersService.updateOrders(orders)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"订单确认成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"订单确认失败");
        }
        return JSON.toJSONString(map);
    }


    /**
     * 批量确认订单
     * @param ids
     * @return
     */
    @RequestMapping("/batchConfirm")
    public String batchConfirm(String ids){
        Map<String,Object> map = new HashMap<String,Object>();
        int count = 0;
        //将字符串拆分成数组
        String[] idsStr = ids.split(",");
        //循环确认
        for (int i = 0; i < idsStr.length; i++) {
            //创建Orders对象
            Orders orders = new Orders();
            orders.setStatus(2);//已确认
            orders.setId(Integer.valueOf(idsStr[i]));
            //调用修改订单的方法
            count = ordersService.updateOrders(orders);
            //判断受影响行数是否大于0
            if(count>0){
                map.put(SystemConstant.SUCCESS,true);
                map.put(SystemConstant.MESSAGE,"订单确认成功");
            }
        }

        //判断受影响行数是否小于0
        if(count<=0){
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"订单确认失败");
        }

        return JSON.toJSONString(map);
    }

}
