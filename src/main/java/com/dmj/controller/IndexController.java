package com.dmj.controller;

import com.dmj.entity.Floor;
import com.dmj.entity.Room;
import com.dmj.entity.RoomType;
import com.dmj.service.FloorService;
import com.dmj.service.RoomService;
import com.dmj.service.RoomTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {


    @Resource
    private RoomTypeService roomTypeService;

    @Resource
    private FloorService floorService;

    @Resource
    private RoomService roomService;


    @RequestMapping("/home.html")
    public String index(Model model){
        //调用查询房型列表的方法
        List<RoomType> roomTypeList = roomTypeService.findRoomTypeList(null);
        //调用查询所有楼层列表的方法
        List<Floor> floorList = floorService.findFloorList(null);
        //调用查询每个楼层的房间列表
        List<Room> roomList = roomService.findRoomListByFloorId();
        //将数据放到模型中
        model.addAttribute("roomTypeList",roomTypeList);
        model.addAttribute("floorList",floorList);
        model.addAttribute("roomList",roomList);
        //return "forward:/home.jsp";
        return "forward:/home.jsp";
    }

}
