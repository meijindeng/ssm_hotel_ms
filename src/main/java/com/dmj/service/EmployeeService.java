package com.dmj.service;

import com.dmj.entity.Employee;

public interface EmployeeService {
    /**
     * 员工登录
     * @param loginName
     * @param loginPwd
     * @return
     */
    Employee login(String loginName, String loginPwd);

    /**
     * 根据部门编号查询员工数量
     * @param deptId
     * @return
     */
    int getEmployeeCountByDeptId(Integer deptId);

    /**
     * 根据角色编号查询员工数量
     * @param roleId
     * @return
     */
    int getEmployeeCountByRoleId(Integer roleId);
}
