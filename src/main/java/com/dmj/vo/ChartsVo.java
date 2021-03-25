package com.dmj.vo;

public class ChartsVo {
    private String name;
    private String type;
    private String stack;
    private Object data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ChartsVo(){

    }

    public ChartsVo(String name, String type, String stack, Object data) {
        this.name = name;
        this.type = type;
        this.stack = stack;
        this.data = data;
    }
}
