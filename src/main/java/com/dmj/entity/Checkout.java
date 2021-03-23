package com.dmj.entity;

import java.util.Date;

public class Checkout {

    private Long id;
    private String checkOutNumber;
    private Long checkInId;
    private Double consumePrice;
    private Date createDate;
    private Integer createdBy;
    private String remark;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckOutNumber() {
        return checkOutNumber;
    }

    public void setCheckOutNumber(String checkOutNumber) {
        this.checkOutNumber = checkOutNumber;
    }

    public Long getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Long checkInId) {
        this.checkInId = checkInId;
    }

    public Double getConsumePrice() {
        return consumePrice;
    }

    public void setConsumePrice(Double consumePrice) {
        this.consumePrice = consumePrice;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
