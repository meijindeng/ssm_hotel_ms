package com.dmj.service.impl;

import com.dmj.dao.RoleMapper;
import com.dmj.entity.Role;
import com.dmj.service.RoleService;
import com.dmj.vo.RoleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 查询角色列表
     *
     * @param roleVo
     * @return
     */
    public List<Role> findRoleList(RoleVo roleVo) {
        return roleMapper.findRoleList(roleVo);
    }

    public int addRole(Role role) { return roleMapper.addRole(role); }

    public int updateRole(Role role) { return roleMapper.updateRole(role); }

    public int deleteById(Integer id) { return roleMapper.deleteById(id); }

    /**
     * 保存角色菜单关系
     * @param ids
     * @param roleId
     * @return
     */
    public int saveRoleMenu(String ids, Integer roleId) {
        try {
            //删除原有的菜单关系,后添加
            roleMapper.deleteRoleMenu(roleId);//根据角色ID删除
            //将ids拆分成数组
            String [] idsStr = ids.split(",");
            //循环调用
            for (int i = 0; i <idsStr.length ; i++) {
                //调用保存菜单角色关系的方法
                roleMapper.addRoleMenu(roleId,idsStr[i]);
            }
            return 1;//成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;//失败
    }

    /**
     * （员工管理分配角色）
     * @return
     */
    public List<Map<String, Object>> findRoleListByMap() {
        return roleMapper.findRoleListByMap();
    }

    /**
     * 根据员工ID查询该员工拥有的角色列表
     * @param employeeId
     * @return
     */
    public List<Integer> findEmployeeRoleByEmployeeId(Integer employeeId) {
        return roleMapper.findEmployeeRoleByEmployeeId(employeeId);
    }
}
