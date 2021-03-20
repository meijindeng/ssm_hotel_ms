package com.dmj.entity;

public class Room {
    private Integer id;
    private String photo;
    private String roomnum;
    private Integer roomtypeid;
    private Integer floorid;
    //房间状态(1-已预订 2-已入住 3-可预订)
    private Integer status;
    private String roomrequirement;
    private String remark;
    private String roomdesc;

    //房型名称
    private String typeName;
    //楼层名称
    private String floorName;
    //状态字符串
    private String statusStr;

    //床位数
    private Integer bedNum;

    //房型价格
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBedNum() {
        return bedNum;
    }

    public void setBedNum(Integer bedNum) {
        this.bedNum = bedNum;
    }

    public String getStatusStr() {
        //判断状态是否为空
        if(status!=null){
            switch (status){
                case 1:
                    statusStr = "已预订";
                    break;
                case 2:
                    statusStr = "已入住";
                    break;
                case 3:
                    statusStr = "可预订";
                    break;
            }
        }
        return statusStr;
    }
    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public Integer getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Integer roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public Integer getFloorid() {
        return floorid;
    }

    public void setFloorid(Integer floorid) {
        this.floorid = floorid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomrequirement() {
        return roomrequirement;
    }

    public void setRoomrequirement(String roomrequirement) {
        this.roomrequirement = roomrequirement;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRoomdesc() {
        return roomdesc;
    }

    public void setRoomdesc(String roomdesc) {
        this.roomdesc = roomdesc;
    }
}
