package com.dmj.dao;

import com.dmj.vo.PieChartsVo;

import java.util.List;
import java.util.Map;

public interface ChartsMapper {

    /**
     * 查询每个年度总营业额
     * @return
     */
    List<Map> getTotalPriceByYear();

    /**
     * 根据指定的年份统计每个月的营业额
     * @param year
     * @return
     */
    List<Double> getTotalPriceByYearOfMonth(String year);


    /**
     * 根据指定的年份统计该年份下每个季度的营业额
     * @param year
     * @return
     */
    List<Map> getQuarterTotalPriceByYear(String year);

    /**
     * 根据年月统计每个房型的预订数量
     * @param year
     * @return
     */
    List<PieChartsVo> getRoomTypeCountByYearAndMonth(String year);

    /**
     * 查询当天开房记录
     * @param date
     * @return
     */
    List<PieChartsVo> getCurrentDateHotelByDate(String date);
}
