package com.dmj.controller.admin;

import com.alibaba.fastjson.JSON;
import com.dmj.entity.Checkin;
import com.dmj.entity.Employee;
import com.dmj.service.CheckinService;
import com.dmj.utils.DataGridViewResult;
import com.dmj.utils.SystemConstant;
import com.dmj.vo.CheckinVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/checkin")
public class CheckinAdminController {

    @Resource
    private CheckinService checkinService;

    /**
     * 查询入住列表
     * @param checkinVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(CheckinVo checkinVo){
        //设置分页信息
        PageHelper.startPage(checkinVo.getPage(),checkinVo.getLimit());
        //调用查询入住列表方法
        List<Checkin> checkinList = checkinService.findCheckinList(checkinVo);
        //创建分页对象
        PageInfo<Checkin> pageInfo = new PageInfo<Checkin>(checkinList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 登记入住
     * @param checkin
     * @return
     */
    @RequestMapping("/addCheckin")
    public String addCheckin(Checkin checkin, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        //获取当前登录用户
        Employee employee = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        //创建人
        checkin.setCreatedby(employee.getId());
        //调用添加入住信息的方法
        if(checkinService.addCheckin(checkin)>0){
            map.put(SystemConstant.SUCCESS,true);
            map.put(SystemConstant.MESSAGE,"办理入住成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);
            map.put(SystemConstant.MESSAGE,"办理入住失败");
        }
        return JSON.toJSONString(map);
    }

}
