package com.dmj.service;

import com.dmj.entity.Employee;
import com.dmj.vo.EmployeeVo;

import java.util.List;

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

    /**
     * 修改员工
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);

    /**
     * 删除员工
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 重置密码
     * @param id
     * @return
     */
    int resetPwd(int id);

    /**
     * 保存员工角色关系
     * @param roleIds
     * @param empId
     * @return
     */
    boolean saveEmployeeRole(String roleIds, Integer empId);
}
