<!DOCTYPE html >
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="../static/js/layui/css/layui.css"/>


</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">短租房</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul id="li1" class="layui-nav layui-layout-left">
            <shiro:hasPermission name="kzt">
            <li class="layui-nav-item kzt" ><a href="">控制台</a></li>
            </shiro:hasPermission>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul id="leftmenu" class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">所有商品</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="javascript:;">列表三</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="../static/js/layui/layui.all.js"/>
<script src="../static/js/jsall.js"></script>
<#--<script>-->
    <#--$(function(){-->
        <#--$.ajax({-->
            <#--url: url + "menu/getMenu",-->
            <#--data: "menu_father=0&menu_leven=0",-->
            <#--dataType: "json",-->
            <#--type: "post",-->
            <#--success: function (data) {-->
                <#--if (data.code == "200") {-->
                    <#--var htmls="";-->
                    <#--if(data.data!=null){-->
                        <#--var datas=data.data;-->
                        <#--for(i=0;i<datas.length;i++){-->
                            <#--htmls+="<li class=\"layui-nav-item\"  onclick=\"leftmenu("+datas[i].menu_id+")\"><a href=\"\">"+datas[i].menu_name+"</a></li>";-->
                        <#--}-->
                        <#--$("#li1").html(htmls);-->
                    <#--}-->
                <#--}else {-->
                    <#--layer.alert(data.msg);-->
                <#--}-->
            <#--}-->
        <#--})-->
        <#--leftmenu(1);-->
    <#--})-->


    <#--function leftmenu(id){-->
        <#--$.ajax({-->
            <#--url: url + "menu/getMenu",-->
            <#--data: "menu_father="+id+"&menu_leven=1",-->
            <#--dataType: "json",-->
            <#--type: "post",-->
            <#--success: function (data) {-->
                <#--if (data.code == "200") {-->
                    <#--var htmls="";-->
                    <#--if(data.data!=null){-->
                        <#--var datas=data.data;-->
                        <#--for(i=0;i<datas.length;i++){-->
                            <#--htmls+="<li class=\"layui-nav-item\"><a href=\"\">"+datas[i].menu_name+"</a></li>";-->
                        <#--}-->
                        <#--$("#leftmenu").html(htmls);-->
                    <#--}-->
                <#--}else {-->
                    <#--layer.alert(data.msg);-->
                <#--}-->
            <#--}-->
        <#--})-->
    <#--}-->
    <#--//JavaScript代码区域-->
    <#--// layui.use('element', function(){-->
    <#--//     var element = layui.element;-->
    <#--// });-->

<#--</script>-->
</body>
</html>