package com.dmj.service.impl;

import com.dmj.dao.EmployeeMapper;
import com.dmj.entity.Employee;
import com.dmj.service.EmployeeService;
import com.dmj.utils.PasswordUtil;
import com.dmj.utils.SystemConstant;
import com.dmj.utils.UUIDUtils;
import com.dmj.vo.EmployeeVo;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.Date;

@Service
@Transactional  //声明事务
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 员工登录
     * @param loginName
     * @param loginPwd
     * @return
     */
    public Employee login(String loginName, String loginPwd) {
        //调用根据账号查询员工信息的方法
        Employee employee = employeeMapper.findEmployeeByLoginName(loginName);
        //判断对象是否为空
        if (employee!=null){
            //加密处理
            String newPassword = PasswordUtil.md5(loginPwd,employee.getSalt(), SystemConstant.PASSWORD_COUNT);
            //比较密码是否一致
            if (employee.getLoginPwd().equals(newPassword)){
                return employee;//登录成功
            }
        }
        //登录失败
        return null;
    }
    public int getEmployeeCountByDeptId(Integer deptId) {
        return employeeMapper.getEmployeeCountByDeptId(deptId);
    }

    public int getEmployeeCountByRoleId(Integer roleId) {
        return employeeMapper.getEmployeeCountByRoleId(roleId);
    }

    public List<Employee> findEmployeeList(EmployeeVo employeeVo) { return employeeMapper.findEmployeeList(employeeVo); }

    public int addEmployee(Employee employee) {
        employee.setSalt(UUIDUtils.randomUUID());//加密盐值
        employee.setCreateDate(new Date());//创建时间
        employee.setLoginPwd(PasswordUtil.md5(SystemConstant.DEFAULT_LOGIN_PWD,employee.getSalt(),SystemConstant.PASSWORD_COUNT));//密码
        return employeeMapper.addEmployee(employee);
    }

}
