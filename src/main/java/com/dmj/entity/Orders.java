package com.dmj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Orders {
    private Integer id;//订单主键
    private String ordersno;//订单号
    private Integer accountid;//用户id
    private Integer roomtypeid;//房型ID
    private Integer roomid;//房间ID
    private String reservationname;//预订人姓名
    private String idcard;//身份证号码
    private String phone;//电话
    private Integer status;//订单状态 1-待确认 2-已确认 3-已入住
    //@JSONField(format = "yyyy-MM-dd HH:mm:ss") //阿里巴巴
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //jackson
    private Date reservedate;//预订时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivedate;//入住时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leavedate;//离店时间
    private Double reserveprice;//预订房价
    private String remark;//备注


    //房间对象
    private Room room;
    //房型对象
    private RoomType roomType;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdersno() {
        return ordersno;
    }

    public void setOrdersno(String ordersno) {
        this.ordersno = ordersno;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Integer roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getReservationname() {
        return reservationname;
    }

    public void setReservationname(String reservationname) {
        this.reservationname = reservationname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReservedate() {
        return reservedate;
    }

    public void setReservedate(Date reservedate) {
        this.reservedate = reservedate;
    }

    public Date getArrivedate() {
        return arrivedate;
    }

    public void setArrivedate(Date arrivedate) {
        this.arrivedate = arrivedate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public Double getReserveprice() {
        return reserveprice;
    }

    public void setReserveprice(Double reserveprice) {
        this.reserveprice = reserveprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
