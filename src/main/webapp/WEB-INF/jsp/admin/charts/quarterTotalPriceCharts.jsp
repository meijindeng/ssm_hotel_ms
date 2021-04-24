<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/layui/css/public.css" media="all">
</head>
<body>
<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">选择年份:</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="year" readonly="readonly" placeholder="yyyy">
            </div>
        </div>
        <div class="layui-inline">
            <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
        </div>
    </div>
</form>
<!-- 搜索条件结束 -->

<!-- 报表界面开始 -->
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="container" style="height:550px;"></div>
<!-- 报表界面结束 -->

<script src="${pageContext.request.contextPath}/statics/echarts/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/echarts/echarts.min.js"></script>
<script src="${pageContext.request.contextPath}/statics/layui/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    layui.use(['jquery','form','layer','laydate'],function () {
        var $=layui.jquery;
        var form=layui.form;
        var layer=layui.layer;
        var laydate=layui.laydate;
        //初始化时间选择器
        laydate.render({
            elem:'#year',//绑定渲染的元素
            type:'year',//控件选择类型
            value:new Date()//默认选中当前年份
        });

        //当点击查询按钮时调用getData()方法
        $("#doSearch").click(function () {
            getData();
        });

        /**
         * 获取数据
         */
        function getData() {
            //获取年份
            var year = $("#year").val();
            //判断年份是否为空
            if(year=="" || year.length==0){
                //如果年份为空，则默认使用当前年份
                year = new Date().getFullYear();
            }
            //发送请求
            $.get("/admin/charts/getHotelQuarterCharts",{"year":year},function(result){
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('container'),'light');
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: result.keyList
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: ['第1季度', '第2季度', '第3季度', '第4季度']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: result.valueList

                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);

            },"json");
        }


        //调用方法
        getData();

    });
</script>
</body>
</html>
