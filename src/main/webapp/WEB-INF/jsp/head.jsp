<%--
  Created by IntelliJ IDEA.
  User: 74132
  Date: 2018/8/7
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>饰品销售管理台</title>
  <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
  <script type="text/javascript" src="easyui/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="easyui/js/jquery.easyui.min.js"></script>
  <script>
//    $(function(){
//      //alert("Hello world");
//      console.log("后台悄悄输出的")
//    })
  </script>
</head>
<body>
<div class="easyui-layout" style="width:100%;height:100%;">
  <div region="north" split="true" title="" style="height:100px;">
    <h1>饰品销售管理平台</h1>
  </div>
  <div region="west" split="true" title="操作区" style="width:200px;">
    <ul class="easyui-tree">
      <li>
        <span>饰品销售管理平台</span>
        <ul>
          <li><span>会员管理</span></li>
          <li><span>文章管理</span></li>
          <li><span>评论管理</span></li>
          <li><span>订单管理</span></li>
          <li><span><a href="advertisement">广告管理</a></span></li>
          <li><span><a href="goodsinfo">商品管理</a></span></li>
          <li><span>类别管理</span></li>
          <li><span>系统设置</span></li>
        </ul>
      </li>
    </ul>
  </div>