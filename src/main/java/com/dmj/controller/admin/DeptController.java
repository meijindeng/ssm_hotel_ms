package com.dmj.controller.admin;


import com.alibaba.fastjson.JSON;
import com.dmj.entity.Dept;
import com.dmj.service.DeptService;
import com.dmj.service.EmployeeService;
import com.dmj.utils.DataGridViewResult;
import com.dmj.utils.SystemConstant;
import com.dmj.vo.DeptVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @Resource
    private EmployeeService employeeService;

    /**
     * 查询部门列表
     * @param deptVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(DeptVo deptVo){
        //设置分页信息
        PageHelper.startPage(deptVo.getPage(),deptVo.getLimit());
        //调用分页查询的方法
        List<Dept> deptList = deptService.findDeptListByPage(deptVo);
        //创建分页对象
        PageInfo<Dept> pageInfo = new PageInfo<Dept>(deptList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }


    /**
     * 添加部门
     * @param dept
     * @return
     */
    @RequestMapping("/addDept")
    public String addDept(Dept dept){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用添加部门的方法
        if(deptService.addDept(dept)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"添加成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"添加失败");
        }
        //将map集合以JSON格式返回
        return JSON.toJSONString(map);
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @RequestMapping("/updateDept")
    public String updateDept(Dept dept){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用修改部门的方法
        if(deptService.updateDept(dept)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        //将map集合以JSON格式返回
        return JSON.toJSONString(map);
    }


    /**
     * 检查该部门下是否存在员工信息
     * @param id
     * @return
     */
    @RequestMapping("/checkDeptHasEmployee")
    public String checkDeptHasEmployee(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用根据部门编号查询员工数量的方法
        if(employeeService.getEmployeeCountByDeptId(id)>0){
            map.put(SystemConstant.EXIST,true);//存在
            map.put(SystemConstant.MESSAGE,"该部门存在员工信息，无法删除");
        }else{
            map.put(SystemConstant.EXIST,false);//不存在
        }
        return JSON.toJSONString(map);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用删除部门的方法
        if(deptService.deleteById(id)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping("/deptList")
    public String deptList(){
        //调用查询所有部门信息的方法并返回到页面
        return JSON.toJSONString(deptService.findDeptList());
    }

}
