package com.dmj.dao;

import com.dmj.entity.Checkin;
import com.dmj.vo.CheckinVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CheckinMapper {

    /**
     * 查询入住列表
     * @param checkinVo
     * @return
     */
    List<Checkin> findCheckinList(CheckinVo checkinVo);

    /**
     * 添加入住信息
     * @param checkin
     * @return
     */
    int addCheckin(Checkin checkin);

    /**
     * 根据主键查询入住信息
     * @param checkInId
     * @return
     */
    @Select("select * from t_checkin where id = #{id}")
    Checkin findById(Long checkInId);

    /**
     * 修改入住信息的方法
     * @param checkin
     * @return
     */
    int updateCheckin(Checkin checkin);
}
