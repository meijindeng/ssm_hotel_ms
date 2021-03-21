package com.dmj.controller;

import com.dmj.entity.Room;
import com.dmj.entity.RoomType;
import com.dmj.service.RoomService;
import com.dmj.service.RoomTypeService;
import com.dmj.vo.RoomVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Resource
    private RoomService roomService;

    @Resource
    private RoomTypeService roomTypeService;

    /**
     * 查询房间详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}.html")
    public String detail(@PathVariable Integer id, Model model){
        //调用查询房间详情的方法
        Room room = roomService.findById(id);
        //将数据放到模型中
        model.addAttribute("room",room);
        return "detail";
    }

    /**
     * 查询全部房间列表
     * @param model
     * @return
     */
    @RequestMapping("/list.html")
    public String list(Model model){
        //调用查询所有房型列表的方法
        List<RoomType> roomTypeList = roomTypeService.findRoomTypeList(null);
        //创建查询条件类
        RoomVo roomVo = new RoomVo();
        roomVo.setStatus(3);//可预订
        //查询房间列表
        List<Room> roomList = roomService.findRoomListByPage(roomVo);
        //将数据放到模型中
        model.addAttribute("roomTypeList",roomTypeList);
        model.addAttribute("roomList",roomList);
        return "hotelList";
    }


    /**
     * 根据房型查询房间列表
     * @param model
     * @return
     */
    @RequestMapping("/list/{id}")
    public String list(@PathVariable Integer id,Model model){
        //调用查询所有房型列表的方法
        List<RoomType> roomTypeList = roomTypeService.findRoomTypeList(null);
        //创建查询条件类
        RoomVo roomVo = new RoomVo();
        roomVo.setRoomtypeid(id);//房型ID
        roomVo.setStatus(3);//可预订
        //查询房间列表
        List<Room> roomList = roomService.findRoomListByPage(roomVo);
        //将数据放到模型中
        model.addAttribute("roomTypeList",roomTypeList);
        model.addAttribute("roomList",roomList);
        model.addAttribute("typeId",id);//将当前选中的房型ID保存到模型中，目的是在页面中回显选中的文本(改变选中的颜色)
        return "hotelList";
    }


}
