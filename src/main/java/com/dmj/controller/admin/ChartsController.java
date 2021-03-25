package com.dmj.controller.admin;

import com.alibaba.fastjson.JSON;
import com.dmj.service.ChartsService;
import com.dmj.vo.ChartsVo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admin/charts")
public class ChartsController {

    @Resource
    private ChartsService chartsService;

    /**
     * 统计每年营业额
     * @return
     */
    @RequestMapping("/getHotelYearCharts")
    public String getHotelYearCharts(){
        //创建Map集合保存数据
        Map<String,Object> dataMap = new HashMap<String,Object>();
        //调用统计每个年度营业总额的方法
        List<Map> mapList = chartsService.getTotalPriceByYear();
        //创建两个List集合，分别保存年份及对应的营业额
        List<String> keyList = new ArrayList<String>();//年份
        List<Double> valueList = new ArrayList<Double>();//营业额
        //循环遍历每年营业额集合
        for (Map map : mapList) {
            keyList.add(map.get("years").toString());//年份
            valueList.add(Double.valueOf(map.get("totalPrice").toString()));//金额
        }
        dataMap.put("keyList",keyList);
        dataMap.put("valueList",valueList);
        //将Map集合以JSON格式返回
        return JSON.toJSONString(dataMap);
    }

    /**
     * 统计月营业额报表
     * @param year
     * @return
     */
    @RequestMapping("/getHotelYearOfMonthCharts")
    public String getHotelYearOfMonthCharts(String year){
        //调用查询每年每月营业额的方法
        List<Double> list = chartsService.getTotalPriceByYearOfMonth(year);
        //循环遍历数据
        for (int i = 0; i < list.size(); i++) {
            //判断当前月份是否有数据，如果没有数据则以0代替
            if(list.get(i)==null){
                list.set(i,0D);
            }
        }
        //将集合以JSON格式返回
        return JSON.toJSONString(list);
    }


    /**
     * 统计季度营业额报表
     * @param year
     * @return
     */
    @RequestMapping("/getHotelQuarterCharts")
    public String getHotelQuarterCharts(String year){
        Map<String,Object> map = new HashMap<String,Object>();
        //调用根据指定的年份查询季度营业额报表的方法
        List<Map> listMap = chartsService.getQuarterTotalPriceByYear(year);
        //创建两个集合，分别保存key和value
        List<String> keyList = new ArrayList<String>();//保存季度名称
        List<ChartsVo> valueList = new ArrayList<ChartsVo>();//保存营业额数据
        //循环遍历
        for (Map m : listMap) {
            //获取每个季度的Key
            String typeName = m.get("typeName").toString();//季度名称
            keyList.add(typeName);//将季度名称保存到季度数组中
            //创建数组，保存每个季度的营业额
            Double [] dataList = {
                    Double.valueOf(m.get("Q1").toString()),
                    Double.valueOf(m.get("Q2").toString()),
                    Double.valueOf(m.get("Q3").toString()),
                    Double.valueOf(m.get("Q4").toString())
            };
            //创建ChartsVo类保存数据
            ChartsVo chartsVo = new ChartsVo(typeName,"line","总营业额",dataList);
            //将对象添加到营业额集合
            valueList.add(chartsVo);
        }
        map.put("keyList",keyList);
        map.put("valueList",valueList);
        return JSON.toJSONString(map);
    }

    /**
     * 统计每个房型每年每月被预订的数量
     * @param date
     * @return
     */
    @RequestMapping("/getHotelChartsByTypeName")
    public String getHotelChartsByTypeName(String date){
        //判断日期是否为空
        if(StringUtils.isEmpty(date)){
            //为空则格式化当前日期
            date = new SimpleDateFormat("yyyy-MM").format(new Date());
        }
        return JSON.toJSONString(chartsService.getRoomTypeCountByYearAndMonth(date));
    }

    /**
     * 统计当前开房报表
     * @param date
     * @return
     */
    @RequestMapping("/getCurrentDateHotelCharts")
    public String getCurrentDateHotelCharts(String date){
        //判断日期是否为空
        if(StringUtils.isEmpty(date)){
            //为空则格式化当前日期
            date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        return JSON.toJSONString(chartsService.getCurrentDateHotelByDate(date));
    }

}
