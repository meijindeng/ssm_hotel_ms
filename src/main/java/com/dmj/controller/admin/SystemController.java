package com.dmj.controller.admin;

import com.dmj.utils.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/*
   负责跳转页面
 */
@Controller
@RequestMapping("/admin")

public class SystemController {
    /**
     * 去到登录页面
     * @return
     */
    @RequestMapping("/login.html")
    public String login(){
        return "admin/login";
    }

    /**
     * 去到后台主页
     * @return
     */
    @RequestMapping("/home.html")
    public String home(){ return "admin/home"; }

    /**
     * 退出系统
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清空session
        session.removeAttribute(SystemConstant.LOGINUSER);
        //session.invalidate();
        //重定向到登录页面
        return "redirect:/admin/login.html";
    }

    /**
     * 去到部门管理页面
     * @return
     */
    @RequestMapping("/toDeptManager")
    public String toDeptManager(){
        return "admin/dept/deptManager";
    }

    /**
     * 去到角色管理页面
     * @return
     */
    @RequestMapping("/toRoleManager")
    public String toRoleManager(){
        return "admin/role/roleManager";
    }

    /**
     * 去到员工管理页面
     * @return
     */
    @RequestMapping("/toEmployeeManager")
    public String toEmployeeManager(){
        return "admin/employee/employeeManager";
    }

    /**
     * 去到菜单管理页面
     * @return
     */
    @RequestMapping("/toMenuManager")
    public String toMenuManager(){
        return "admin/menu/menuManager";
    }

    /**
     * 去到楼层管理页面
     * @return
     */
    @RequestMapping("/toFloorManager")
    public String toFloorManager(){
        return "admin/floor/floorManager";
    }

    /**
     * 去到房型管理页面
     * @return
     */
    @RequestMapping("/toRoomTypeManager")
    public String toRoomTypeManager(){
        return "admin/roomType/roomTypeManager";
    }

    /**
     * 去到房间管理页面
     * @return
     */
    @RequestMapping("/toRoomManager")
    public String toRoomManager(){
        return "admin/room/roomManager";
    }

    /**
     * 去到预定管理页面
     * @return
     */
    @RequestMapping("/toOrdersManager")
    public String toOrdersManager(){
        return "admin/orders/ordersManager";
    }

    /**
     * 去到入住管理页面
     * @return
     */
    @RequestMapping("/toCheckinManager")
    public String toCheckinManager(){
        return "admin/checkin/checkinManager";
    }
}
