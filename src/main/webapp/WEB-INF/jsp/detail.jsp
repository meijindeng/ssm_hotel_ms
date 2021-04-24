<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="fly-html-layui fly-html-store">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/layui/dist/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/css/global.css" charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/css/global(1).css" charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/statics/front/css/store.css" charset="utf-8">
    <link rel="icon" href="${pageContext.request.contextPath}/statics/front/images/favicon.ico">
    <title>房间详情</title>
<body>
<!-- 顶部start -->
<div class="layui-header header header-store" style="background-color: #393D49;">
    <div class="layui-container">
        <a class="logo" href="index.html">
            <img src="${pageContext.request.contextPath}/statics/front/images/logo.png" alt="layui">
        </a>
        <div class="layui-form component" lay-filter="LAY-site-header-component"></div>
        <ul class="layui-nav" id="layui-nav-userinfo">
            <li data-id="index" class="layui-nav-item layui-hide-xs">
                <a class="fly-case-active" data-type="toTopNav"
                   href="/home.html">首页</a>
            </li>
            <li data-id="room" class="layui-nav-item layui-hide-xs layui-this">
                <a class="fly-case-active" data-type="toTopNav"
                   href="/room/hotelList.html">房间</a>
            </li>
            <li data-id="login" class="layui-nav-item layui-hide-xs ">
                <a class="fly-case-active" data-type="toTopNav"
                   href="/login.jsp">登录</a>
            </li>
            <li data-id="register" class="layui-nav-item layui-hide-xs ">
                <a class="fly-case-active" data-type="toTopNav"
                   href="/register.jsp">注册</a>
            </li>
            <span class="layui-nav-bar" style="left: 560px; top: 55px; width: 0px; opacity: 0;"></span></ul>
    </div>
</div>
<!-- 顶部end -->

<!-- 中间区域开始 -->
<div class="shop-nav shop-index">
    <!--搜索 start-->
    <div id="LAY-topbar" style="height: auto;">
        <form class="layui-form layuimini-form">
            <div class="input-search">
                <div id="searchRoom"><input type="text" placeholder="搜索你需要的房间" name="keywords" id="searchKeywords"
                                            autocomplete="off" value="">
                    <button class="layui-btn layui-btn-shop" lay-submit="" lay-filter="searchHotelRoom" style="background-color: #009688"><i
                            class="layui-icon layui-icon-search"></i></button>
                </div>
                <div class="layui-container layui-hide-xs"><a href="#" class="topbar-logo"> <img
                        src="${pageContext.request.contextPath}/statics/front/images/logo-1.png" alt="layui"> </a></div>
            </div>
        </form>
    </div>
    <!--搜索 end-->

</div>
<!-- 中间区域结束 -->

<!-- 房间详情start -->
<div class="layui-container shopdata">
    <div class="layui-card shopdata-intro">
        <div class="layui-card-header">
				<span class="layui-breadcrumb layui-hide-xs" style="visibility: visible;">
				    <a href="/home.html">酒店首页</a><span lay-separator="">/</span>
                    <a href="/home.html"
                       id="floorNumber">酒店${room.floorName}</a><span lay-separator="">/</span>
						 <a><cite>房间详情</cite></a>
                </span>
        </div>
        <div class="layui-card-body layui-row">
            <div class="layui-col-md6">
                <div class="intro-img photos">
                    <img id="coverImg" src="/hotel/show/${room.photo}" alt="产品封面" layer-index="0"> </div>
            </div>
            <div class="layui-col-md6">
                <div class="intro-txt">
                    <h1 class="title" id="roomName">${room.typeName}</h1>
                    <input type="hidden" id="id" name="id" value="1">
                    <div class="store-attrs">
                        <div class="summary">
                            <p class="reference"><span>房间号</span> <span id="roomNumber">NO.${room.roomnum}</span></p>
                            <p class="reference"><span>床位数</span> <span id="bedType">${room.bedNum}张</span></p>
                            <p class="reference"><span>宽　带</span> <span id="broadband">免费wifi</span></p>
                            <p class="reference"><span>标准价</span> ￥<span id="standardPrice">${room.price}</span></p>
                            <p class="activity"><span>会员价</span><strong class="price"><i>￥</i><span id="memberPrice">${room.price}</span></strong></p>
                            <p class="activity"><span>状&#12288;态</span>
                            <strong class="status">

                                 <span>${room.statusStr}</span>

                                </strong>

                            </p>
                        </div>
                    </div>

                    <p class="store-detail-active" id="shopEvent">
                        <%-- 隐藏域，保存当前登录用户的ID值 --%>
                        <input type="hidden" id="currentUserId" value="${sessionScope.currentUser.id}">
                        <%-- 隐藏域，保存房间价格 --%>
                        <input type="hidden" id="price" value="${room.price}">
                        <c:if test="${room.status==3}">
                            <a href="javascript:;" id="bookRoomBtn" data-type="memberReserveHotel" class="store-bg-green fly-memberReserveHotel">
                            <i class="layui-icon layui-icon-dollar"></i>立即预定 </a>
                        </c:if>
                        <c:if test="${room.status!=3}">
                            <a href="javascript:;" id="bookRoomBtn2" data-type="memberReserveHotel" class="store-bg-orange fly-memberReserveHotel">
                                <i class="layui-icon layui-icon-dollar"></i>立即预定 </a>
                        </c:if>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-card shopdata-content">
        <div class="layui-card-body detail-body layui-text">
            <div class="layui-elem-quote"> ${room.roomrequirement}</div>
            <div id="roomContent">
                ${room.roomdesc}
            </div>
        </div>
    </div>
</div>
<!-- 房间详情end -->

<%-- 预订房间窗口 --%>
<div style="display: none;padding: 5px" id="orderRoomWindow">
    <form class="layui-form" style="width:90%;" id="dataFrm" lay-filter="dataFrm">
        <%-- 添加3个隐藏域，分别保存用户ID、房间ID、房型ID --%>
        <input type="hidden" name="accountid" value="${sessionScope.currentUser.id}">
        <input type="hidden" name="roomid" value="${room.id}">
        <input type="hidden" name="roomtypeid" value="${room.roomtypeid}">
        <div class="layui-form-item">
            <label class="layui-form-label">预订日期</label>
            <div class="layui-input-block">
                <input type="text" id="book_date" lay-verify="required" autocomplete="off" readonly placeholder="请选择预订日期范围"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">入住时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="arrivedate" id="arrivedate" lay-verify="required"  readonly placeholder="请选择入住时间"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">离店时间</label>
                <div class="layui-input-inline">
                    <input type="text" name="leavedate" id="leavedate" lay-verify="required" readonly  placeholder="请选择离店时间"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">入住天数</label>
                <div class="layui-input-inline">
                    <input type="text" name="day" id="day" lay-verify="required" readonly  placeholder="入住天数自动计算"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">房费价格</label>
                <div class="layui-input-inline">
                    <input type="text" name="reserveprice" id="reservePrice" lay-verify="required"  readonly placeholder="房费价格自动计算"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">预订姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="reservationname" lay-verify="required"  placeholder="请输入预订人姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">预订电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" lay-verify="required"  placeholder="请输入预订人电话"
                           class="layui-input">
                </div>
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">身份证号</label>
            <div class="layui-input-block">
                <input type="text" name="idcard" lay-verify="required" autocomplete="off" placeholder="请输入身份证号码"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注留言</label>
            <div class="layui-input-block">
                <textarea class="layui-textarea" name="remark" id="content"></textarea>
            </div>
        </div>
        <div class="layui-form-item" style="margin-left: 80px">
            <span style="color: red;font-size: 16px;">预订须知：请携带本人的身份证办理入住手续，办理入住需要在前台缴纳押金￥100</span>
        </div>
        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block" style="text-align: center;">
                <button type="button" class="layui-btn" lay-submit lay-filter="doSubmit"><span
                        class="layui-icon layui-icon-add-1"></span>提交
                </button>
                <button type="reset" class="layui-btn layui-btn-warm"><span
                        class="layui-icon layui-icon-refresh-1"></span>重置
                </button>
            </div>
        </div>
    </form>
</div>

<!-- 底部 -->
<div class="fly-footer">
    <p><a href="#">酒店管理系统</a> 2021 ©
        <a href="https://gitee.com/meijindeng" target="_blank">gitee地址：https://gitee.com/meijindeng</a>
    </p>
</div>


<!-- 脚本开始 -->
<script src="${pageContext.request.contextPath}/statics/front/layui/dist/layui.js"></script>
<script>
    layui.use(["form","element","carousel","layer","laydate"], function () {
        var form = layui.form,
            layer = layui.layer,
            element = layui.element,
            carousel = layui.carousel,
            laydate = layui.laydate,
            $ = layui.$;

        //渲染轮播图
        carousel.render({
            elem: '#LAY-store-banner'
            ,width: '100%' //设置容器宽度
            ,height: '460' //设置容器高度
            ,arrow: 'always' //始终显示箭头
        });

        /**
         * 计算两个日期的天数差
         * @param strDateStart
         * @param strDateEnd
         * @returns {number}
         */
        function getDays(strDateStart,strDateEnd){
            var strSeparator = "-"; //日期分隔符
            Date1= strDateStart.split(strSeparator);
            oDate2= strDateEnd.split(strSeparator);
            var strDateS = new Date(Date1[0], Date1[1]-1, Date1[2]);
            var strDateE = new Date(oDate2[0], oDate2[1]-1, oDate2[2]);
            iDays = parseInt(Math.abs(strDateS - strDateE ) / 1000 / 60 / 60 /24)//把相差的毫秒数转换为天数
            return iDays ;
        }

        //渲染日期范围组件
        laydate.render({
            elem:"#book_date",
            min:"new Date()",//限定开始日期
            range:"至",//选择范围，内容可以自定义
            done:function (value,date,endDate) {
                //var startDate = value.substr(0,value.indexOf("至")).trim();
                //var endDate = value.substr(value.indexOf("至")+1,value.length).trim();
                var startDate = value.substr(0,value.indexOf(" ")).trim();//开始日期(入住日期)
                var endDate = value.substr(value.lastIndexOf(" "),value.length).trim();//结束日期(离店日期)
                //赋值
                $("#arrivedate").val(startDate);
                $("#leavedate").val(endDate);
                //计算天数差
                var day = getDays(startDate,endDate);
                //赋值入住天数
                $("#day").val(day);
                //计算房费价格
                var price  = day * $("#price").val();
                //赋值价格
                $("#reservePrice").val(price);
            }
        });


        var mainIndex;

        //点击立即预订按钮触发点击事件
        $("#bookRoomBtn").click(function () {
            //获取隐藏域中的用户ID值
            var userId = $("#currentUserId").val();
            //判断用户是否已经登录
            if(userId=="" || userId.length==0){
                //layer.alert("您还没有登录，请先登录！");
                alert("您还没有登录，请先登录！")
                location.href="/login.jsp";
            }
            //打开预订房间窗口
            mainIndex = layer.open({
                type: 1,//打开类型
                title: "预订房间",//窗口标题
                area: ["800px", "550px"],//窗口宽高
                content: $("#orderRoomWindow"),//引用的内容窗口
                success: function () {
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                }
            });
        });


        $("#bookRoomBtn2").click(function () {
            layer.alert("该房间已被预订",{icon:5});
        });

        //监听表单提交事件
        form.on("submit(doSubmit)",function (data) {

            console.log(data.field)

            $.post("/orders/addOrders",data.field,function(result){
                if(result.success){
                    layer.alert(result.message,{icon:6});
                    //关闭窗口
                    layer.close(mainIndex);
                    //刷新页面
                    window.location.reload();
                }else{
                    layer.alert(result.message,{icon:5});
                }
            },"json");

            return false;
        });



    });
</script>
<!-- 脚本结束 -->
<ul class="layui-fixbar">
    <li class="layui-icon layui-fixbar-top" lay-type="top" style=""></li>
</ul>
<div class="layui-layer-move"></div>

</body>
</html>
