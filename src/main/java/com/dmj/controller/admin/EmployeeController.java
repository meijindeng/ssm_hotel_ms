package com.dmj.controller.admin;

import com.alibaba.fastjson.JSON;
import com.dmj.entity.Employee;
import com.dmj.service.EmployeeService;
import com.dmj.utils.SystemConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 员工登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        Map<String,Object> map = new HashMap<String, Object>();
        //调用员工登录的方法
        Employee employee = employeeService.login(username, password);
        //判断对象是否为空，不为空表示登录
        if (employee!=null){
            //保存当前用户
            session.setAttribute(SystemConstant.LOGINUSER,employee);
            map.put(SystemConstant.SUCCESS,true);
        }else {
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"账号密码错误，登录失败");
        }
        return JSON.toJSONString(map);
    }


}
