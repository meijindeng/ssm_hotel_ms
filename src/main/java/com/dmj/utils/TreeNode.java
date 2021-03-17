package com.dmj.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点属性类
 */
public class TreeNode {

    private Integer id;//菜单节点编号
    @JsonProperty(value = "parentId")
    private Integer pid;//父节点菜单编号
    private String title;//菜单节点名称
    private String icon;//菜单节点图标
    private String href;//菜单路径
    private Boolean spread;//是否展开
    //子节点菜单
    private List<TreeNode> children = new ArrayList<TreeNode>();

    //复选框是否被选中
    private String checkArr = "0";//默认不选中

    public String getCheckArr() {
        return checkArr;
    }

    public void setCheckArr(String checkArr) {
        this.checkArr = checkArr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNode() {
    }

    /**
     * 构建树节点菜单
     * @param id    节点编号
     * @param pid   父节点
     * @param title 节点标题
     * @param icon  节点图标
     * @param href  节点菜单路径
     * @param spread    节点展开状态
     */
    public TreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.icon = icon;
        this.href = href;
        this.spread = spread;
    }

    /**
     * 构建dtree组件
     * @param id        编号
     * @param pid       父级编号
     * @param title     名称
     * @param spread    展开状态
     */
    public TreeNode(Integer id, Integer pid, String title, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
    }

    /**
     * 带参构造方法
     * @param id          菜单权限ID
     * @param pid         菜单权限父ID
     * @param title       菜单权限名称
     * @param spread      是否展开
     * @param checkArr    复选框是否选中
     */
    public TreeNode(Integer id, Integer pid, String title, Boolean spread, String checkArr) {
        this.id = id;
        this.pid = pid;
        this.title = title;
        this.spread = spread;
        this.checkArr = checkArr;
    }
}
