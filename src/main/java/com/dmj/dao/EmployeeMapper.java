package com.dmj.dao;

import com.dmj.entity.Employee;
import com.dmj.vo.EmployeeVo;

import java.util.List;

public interface EmployeeMapper {
    /**
     * 根据登录账号查找员工信息
     * @param loginName
     * @return
     */
    Employee findEmployeeByLoginName(String loginName);

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

    /**
     * 查询员工的列表
     * @param employeeVo
     * @return
     */
    List<Employee> findEmployeeList(EmployeeVo employeeVo);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    int addEmployee(Employee employee);
}
