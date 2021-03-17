package com.dmj.vo;

import com.dmj.entity.Dept;

public class DeptVo extends Dept {
    //当前页码
    private Integer page;
    //每页显示数量
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
