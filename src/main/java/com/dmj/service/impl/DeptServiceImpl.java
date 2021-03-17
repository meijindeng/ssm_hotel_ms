package com.dmj.service.impl;

import com.dmj.dao.DeptMapper;
import com.dmj.entity.Dept;
import com.dmj.service.DeptService;
import com.dmj.vo.DeptVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    /**
     * 查询部门列表
     *
     * @param deptVo
     * @return
     */
    public List<Dept> findDeptListByPage(DeptVo deptVo) {
        return deptMapper.findDeptListByPage(deptVo);
    }

    /**
     * 添加部门信息
     * @param dept
     * @return
     */
    public int addDept(Dept dept) {
        //保存创建时间
        dept.setCreateDate(new Date());
        return deptMapper.addDept(dept);
    }

    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }

    public List<Dept> findDeptList() {
        return deptMapper.findDeptList();
    }
}
