<%--
  Created by IntelliJ IDEA.
  User: 74132
  Date: 2018/8/7
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="head.jsp"></jsp:include>



<script>
  $(function(){
    $("#adv").datagrid({
      columns:[[
        {field:'advId',title:'广告编号',width:100,align:'center',checkbox:true},
        {field:'advTitle',title:'广告标题',width:200,align:'center'},
        {field:'advPicUrl',title:'广告图片',width:200,align:'center'},
        {field:'advOrder',title:'排位',width:200,align:'center'},
        {field:'advLinkUrl',title:'广告链接地址',width:300,align:'center'},
        {field:'advOffline',title:'广告状态',width:100,align:'center'},
        {field:'advCratetime',title:'创建时间',width:300,align:'center'}

      ]],
      url:"advertisementdata",
      width:"100%",
      pagination:true,
      fit:true,
      title:"广告列表",
      toolbar: [{
        iconCls: 'icon-add',
        text:'增加广告',
        handler: function(){
          alert('弹出一个增加的窗口')}
      },'-',{
        iconCls: 'icon-cancel',
        text:'批量删除',
        handler: function(){
          alert('是否全部删除')}
      }]




    })
  })

</script>


  <div id="content" region="center" title="" style="padding:5px;">
    <table id="adv"></table>
  </div>


<jsp:include page="wei.jsp"></jsp:include>
