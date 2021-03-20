package com.dmj.dao;

import com.dmj.entity.Floor;
import com.dmj.vo.FloorVo;

import java.util.List;

public interface FloorMapper {


    /**
     * 查询楼层列表
     * @param floorVo
     * @return
     */
    List<Floor> findFloorList(FloorVo floorVo);

    /**
     * 添加楼层
     * @param floor
     * @return
     */
    int addFloor(Floor floor);

    /**
     * 修改楼层
     * @param floor
     * @return
     */
    int updateFloor(Floor floor);


}
