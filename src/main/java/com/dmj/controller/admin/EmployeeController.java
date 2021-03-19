package com.dmj.controller.admin;

import com.alibaba.fastjson.JSON;
import com.dmj.entity.Employee;
import com.dmj.service.EmployeeService;
import com.dmj.utils.DataGridViewResult;
import com.dmj.utils.SystemConstant;
import com.dmj.vo.EmployeeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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


    /**
     * 员工列表
     * @param employeeVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(EmployeeVo employeeVo){
        //设置分页信息
        PageHelper.startPage(employeeVo.getPage(),employeeVo.getLimit());
        //调用查询的方法
        List<Employee> employeeList = employeeService.findEmployeeList(employeeVo);
        //创建分页对象
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employeeList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加员工
     * @param employee
     * @param session
     * @return
     */
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        //获取当前登录用户
        Employee loginUser = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        //设置创建人
        employee.setCreatedBy(loginUser.getId());
        //调用新增员工的方法
        if(employeeService.addEmployee(employee)>0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "添加成功");
        }else{
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "添加失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 修改员工
     * @param employee
     * @param session
     * @return
     */
    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee,HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        //获取当前登录用户
        Employee loginUser = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        //设置修改人
        employee.setModifyBy(loginUser.getId());
        //调用新增员工的方法
        if(employeeService.updateEmployee(employee)>0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "修改成功");
        }else{
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "修改失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(int id){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用删除员工的方法
        if(employeeService.deleteById(id)>0){
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "删除成功");
        }else{
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "删除失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 重置密码
     * @param id
     * @return
     */
    @RequestMapping("/resetPwd")
    public String resetPwd(int id){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用重置密码的方法
        if(employeeService.resetPwd(id)>0){
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "密码重置成功");
        }else{
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "密码重置失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 分配角色
     * @param roleIds
     * @param empId
     * @return
     */
    @RequestMapping("/saveEmployeeRole")
    public String saveEmployeeRole(String roleIds,Integer empId){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用保存员工角色关系的方法
        if(employeeService.saveEmployeeRole(roleIds,empId)){
            map.put(SystemConstant.MESSAGE,"角色分配成功");
        }else{
            map.put(SystemConstant.MESSAGE,"角色分配失败");
        }
        return JSON.toJSONString(map);
    }


}
