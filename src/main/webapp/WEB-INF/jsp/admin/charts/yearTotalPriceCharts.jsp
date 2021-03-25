<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>年度营业额报表</title>
    <!-- 引入 ECharts 文件 -->
    <script src="${pageContext.request.contextPath}/statics/echarts/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/echarts/echarts.min.js"></script>
</head>
<body>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="height:550px;"></div>


<script>

    /**
     * 获取数据
     */
    function getData() {

        $.get("/admin/charts/getHotelYearCharts",function(result){
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'),'light');
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '年度营业额报表统计分析',//标题
                    left: 'center'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                xAxis: {
                    data: result.keyList //年份
                },
                yAxis: {},
                series: [{
                    name: '营业额',
                    type: 'bar',
                    data: result.valueList
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);


        },"json");


    }

    //调用获取数据的方法
    getData();

</script>


</body>
</html>
