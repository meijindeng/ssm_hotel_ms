package com.dmj.dao;

import com.dmj.entity.Employee;

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
}
