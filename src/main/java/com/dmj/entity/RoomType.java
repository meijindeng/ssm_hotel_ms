package com.dmj.entity;

public class RoomType {
    private Integer id;

    private String typename;

    private String photo;

    private Double price;

    private Integer livenum;

    private Integer bednum;

    private Integer roomnum;

    private Integer reservednum;

    private Integer avilablenum;

    private Integer livednum;

    private Integer status;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getLivenum() {
        return livenum;
    }

    public void setLivenum(Integer livenum) {
        this.livenum = livenum;
    }

    public Integer getBednum() {
        return bednum;
    }

    public void setBednum(Integer bednum) {
        this.bednum = bednum;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public Integer getReservednum() {
        return reservednum;
    }

    public void setReservednum(Integer reservednum) {
        this.reservednum = reservednum;
    }

    public Integer getAvilablenum() {
        return avilablenum;
    }

    public void setAvilablenum(Integer avilablenum) {
        this.avilablenum = avilablenum;
    }

    public Integer getLivednum() {
        return livednum;
    }

    public void setLivednum(Integer livednum) {
        this.livednum = livednum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
