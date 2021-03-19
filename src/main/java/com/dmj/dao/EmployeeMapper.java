package com.dmj.dao;

import com.dmj.entity.Employee;
import com.dmj.vo.EmployeeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

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
     * 删除员工与角色的关系
     * @param id
     */
    void deleteEmployeeAndRole(Integer id);

    /**
     * 保存员工角色关系数据
     * @param roleId
     * @param empId
     */
    @Insert("insert into sys_role_employee (eid,rid) values(#{eid},#{rid})")
    void addEmployeeRole(@Param("rid") String roleId, @Param("eid") Integer empId);
}
