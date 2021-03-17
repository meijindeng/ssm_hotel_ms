package com.dmj.service;

import com.dmj.entity.Menu;
import com.dmj.vo.MenuVo;

import java.util.List;

public interface MenuService {
    /**
     * 查询所有菜单列表
     * @return
     */
    List<Menu> findMenuList();

    /**
     * 根据角色ID查询该角色拥有的菜单ID集合
     * @param roleId
     * @return
     */
    List<Integer> findMenuIdListByRoleId(int roleId);

    /**
     * 根据菜单编号查询菜单信息
     * @param currentRoleMenuIds
     * @return
     */
    List<Menu> findMenuByMenuId(List<Integer> currentRoleMenuIds);

    /**
     * 查询菜单列表
     * @param menuVo
     * @return
     */
    List<Menu> findMenuListByPage(MenuVo menuVo);

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    int addMenu(Menu menu);

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    int updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 根据菜单ID查询该菜单是否有子菜单
     * @param id
     * @return
     */
    int getMenuCountByMenuId(Integer id);

    /**
     * 根据当前登录员工的角色查询菜单列表
     * @param employeeId
     * @return
     */
    List<Menu> findMenuListByEmployeeId(Integer employeeId);
}
