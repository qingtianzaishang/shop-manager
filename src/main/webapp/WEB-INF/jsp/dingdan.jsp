<%--
  Created by IntelliJ IDEA.
  User: 74132
  Date: 2018/8/7
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>
<script>
  $(function(){
    $("#order").datagrid({
      columns:[[
        {field:'orderId',title:'订单索引id',width:100,align:'center'},
        {field:'orderSn',title:'订单编号',width:100,align:'center'},
        {field:'buyerId',title:'买家id',width:100,align:'center'},
        {field:'buyerName',title:'买家姓名',width:100,align:'center'},
        {field:'buyerTel',title:'买家联系电话',width:100,align:'center'},
        {field:'addTime',title:'订单生成时间',width:200,align:'center',formatter:function(v,r,i){
          var d=new Date(v);
          return d.getFullYear()+"年"+(d.getMonth()+1)+"月"+ d.getDate()+"日  "+ d.getHours()+":"+ d.getMinutes()+":"+ d.getSeconds();
        }},
        {field:'paymentCode',title:'支付方式名称',width:100,align:'center'},
        {field:'paymentTime',title:'支付(付款)时间',width:200,align:'center',formatter:function(v,r,i){
          var d=new Date(v);
          return d.getFullYear()+"年"+(d.getMonth()+1)+"月"+ d.getDate()+"日  "+ d.getHours()+":"+ d.getMinutes()+":"+ d.getSeconds();
        }},
        {field:'finnshedTime',title:'订单完成时间',width:200,align:'center',formatter:function(v,r,i){
          var d=new Date(v);
          return d.getFullYear()+"年"+(d.getMonth()+1)+"月"+ d.getDate()+"日  "+ d.getHours()+":"+ d.getMinutes()+":"+ d.getSeconds();
        }},
        {field:'orderAmount',title:'订单总价格',width:100,align:'center'},
        {field:'orderState',title:'订单状态',width:100,align:'center'},
        {field:'createdTime',title:'订单初成时间',width:200,align:'center',formatter:function(v,r,i){
          var d=new Date(v);
          return d.getFullYear()+"年"+(d.getMonth()+1)+"月"+ d.getDate()+"日  "+ d.getHours()+":"+ d.getMinutes()+":"+ d.getSeconds();
        }},
        {field:'updatedTime',title:'订单更新时间',width:200,align:'center',formatter:function(v,r,i){
          var d=new Date(v);
          return d.getFullYear()+"年"+(d.getMonth()+1)+"月"+ d.getDate()+"日  "+ d.getHours()+":"+ d.getMinutes()+":"+ d.getSeconds();
        }},
      ]],
url:"orderinfodata",
      pagination:true,
      fit:true,
      title:"订单列表",
      toolbar: [{
        iconCls: 'icon-add',
        text:'增加订单',
        handler: function(){
          alert('弹出一个增加订单的窗口')}
      },'-',{
        iconCls: 'icon-cancel',
        text:'批量删除',
        handler: function(){
          alert('是否全部删除')}
      }]

    })



  })
</script>

<div id="content" region="center" title="Language" style="padding:5px;">
  <table id="order"></table>
</div>
<jsp:include page="wei.jsp"></jsp:include>
