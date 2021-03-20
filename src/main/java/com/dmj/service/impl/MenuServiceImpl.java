package com.dmj.service.impl;

import com.dmj.dao.MenuMapper;
import com.dmj.entity.Menu;
import com.dmj.service.MenuService;
import com.dmj.vo.MenuVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 查询所有菜单列表
     *
     * @return
     */
    public List<Menu> findMenuList() {
        return menuMapper.findMenuList();
    }

    public List<Integer> findMenuIdListByRoleId(int roleId) {
        return menuMapper.findMenuIdListByRoleId(roleId);
    }

    public List<Menu> findMenuByMenuId(List<Integer> currentRoleMenuIds) {
        return menuMapper.findMenuByMenuId(currentRoleMenuIds);
    }

    public List<Menu> findMenuListByPage(MenuVo menuVo) {
        return menuMapper.findMenuListByPage(menuVo);
    }

    //添加菜单
    public int addMenu(Menu menu) {
        //如果没有选择父级菜单，默认设置父级菜单为0
        if(menu.getPid()==null){
            menu.setPid(0);
        }
        menu.setTarget("_self");//设置打开方式，没有作用
        return menuMapper.addMenu(menu);
    }

    //修改菜单
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    //删除菜单
    public int deleteById(int id) {
        return menuMapper.deleteById(id);
    }

    //根据菜单ID查询该菜单是否有子菜单
    public int getMenuCountByMenuId(Integer id) {
        return menuMapper.getMenuCountByMenuId(id);
    }

    public List<Menu> findMenuListByEmployeeId(Integer employeeId) {
        return menuMapper.findMenuListByEmployeeId(employeeId);
    }
}
