package com.dmj.controller.admin;

import com.alibaba.fastjson.JSON;
import com.dmj.entity.Room;
import com.dmj.service.RoomService;
import com.dmj.utils.DataGridViewResult;
import com.dmj.utils.SystemConstant;
import com.dmj.vo.RoomVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/room")
public class RoomAdminController {

    @Resource
    private RoomService roomService;

    /**
     * 查询房型列表
     * @param roomVo
     * @return
     */
    @RequestMapping("/list")
    public DataGridViewResult list(RoomVo roomVo){
        //设置分页信息
        PageHelper.startPage(roomVo.getPage(),roomVo.getLimit());
        //调用查询的方法
        List<Room> roomList = roomService.findRoomListByPage(roomVo);
        //创建分页对象
        PageInfo<Room> pageInfo = new PageInfo<Room>(roomList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加房间
     * @param room
     * @return
     */
    @RequestMapping("/addRoom")
    public String addRoom(Room room){
        Map<String,Object> map = new HashMap<String,Object>();
        if(roomService.addRoom(room)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"添加成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"添加失败");
        }
        return JSON.toJSONString(map);
    }
    /**
     * 修改房间
     * @param room
     * @return
     */
    @RequestMapping("/updateRoom")
    public String updateRoom(Room room){
        Map<String,Object> map = new HashMap<String,Object>();
        if(roomService.updateRoom(room)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"修改成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"修改失败");
        }
        return JSON.toJSONString(map);
    }
    /**
     * 删除房间
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id){
        Map<String,Object> map = new HashMap<String,Object>();
        if(roomService.deleteById(id)>0){
            map.put(SystemConstant.SUCCESS,true);//成功
            map.put(SystemConstant.MESSAGE,"删除成功");
        }else{
            map.put(SystemConstant.SUCCESS,false);//失败
            map.put(SystemConstant.MESSAGE,"删除失败");
        }
        return JSON.toJSONString(map);
    }

}
