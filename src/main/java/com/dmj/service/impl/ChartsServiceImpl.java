package com.dmj.service.impl;

import com.dmj.dao.ChartsMapper;
import com.dmj.service.ChartsService;
import com.dmj.vo.PieChartsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class ChartsServiceImpl implements ChartsService {

    @Resource
    private ChartsMapper chartsMapper;

    /**
     * 查询每个年度总营业额
     *
     * @return
     */
    public List<Map> getTotalPriceByYear() {
        return chartsMapper.getTotalPriceByYear();
    }

    public List<Double> getTotalPriceByYearOfMonth(String year) {
        return chartsMapper.getTotalPriceByYearOfMonth(year);
    }

    public List<Map> getQuarterTotalPriceByYear(String year) {
        return chartsMapper.getQuarterTotalPriceByYear(year);
    }

    public List<PieChartsVo> getRoomTypeCountByYearAndMonth(String year) {
        return chartsMapper.getRoomTypeCountByYearAndMonth(year);
    }

    public List<PieChartsVo> getCurrentDateHotelByDate(String date) {
        return chartsMapper.getCurrentDateHotelByDate(date);
    }
}
