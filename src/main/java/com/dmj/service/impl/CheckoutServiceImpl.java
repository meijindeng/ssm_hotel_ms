package com.dmj.service.impl;

import com.dmj.dao.*;
import com.dmj.entity.*;
import com.dmj.service.CheckoutService;
import com.dmj.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {

    @Resource
    private CheckoutMapper checkoutMapper;

    @Resource
    private CheckinMapper checkinMapper;

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private RoomTypeMapper roomTypeMapper;

    @Resource
    private RoomMapper roomMapper;

    /**
     * 添加退房记录
     *
     * @param checkout
     * @return
     */
    public int addCheckout(Checkout checkout) {
        //#1.新增一条退房记录
        checkout.setCreateDate(new Date());//创建时间（什么时候操作了办理退房）
        checkout.setCheckOutNumber(UUIDUtils.randomUUID());
        //调用新增退房记录的方法
        int count = checkoutMapper.addCheckout(checkout);
        if(count>0){

            //#2.修改t_checkin中status状态，修改成2(已离店)
            Checkin checkin = checkinMapper.findById(checkout.getCheckInId());
            checkin.setStatus(2);//已离店
            //调用修改入住订单的方法
            checkinMapper.updateCheckin(checkin);

            //#3.修改t_orders表中的status状态，修改成4(订单已完成)
            Orders orders = new Orders();
            orders.setStatus(4);//订单已完成
            orders.setId(checkin.getOrdersid());
            //调用修改订单的方法
            ordersMapper.updateOrders(orders);

            //#4.修改t_room_type表中的可用房间数(+1),已入住房间数-1
            RoomType roomType = roomTypeMapper.findById(checkin.getRoomtypeid());
            roomType.setAvilablenum(roomType.getAvilablenum()+1);//可用房间数+1
            roomType.setLivednum(roomType.getLivednum()-1);//已入住房间数-1
            //调用修改房型的方法
            roomTypeMapper.updateRoomType(roomType);
             //注意：退房对象Checkout中无法获取订单主键ID，也无法获取房型主键ID


            //修改房间状态(修改成可预订的状态)
            Room room = new Room();
            room.setId(checkin.getRoomid().intValue());//房间编号
            room.setStatus(3);//可预订状态
            roomMapper.updateRoom(room);
        }

        return count;
    }
}
