<%--
  Created by IntelliJ IDEA.
  User: 74132
  Date: 2018/8/7
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="head.jsp"></jsp:include>
<script>
  $(function(){
    $("#goods").datagrid({
      columns:[[
        {field:'fuZhu',title:'X',width:50,align:'center',checkbox:true},
        {field:'goodsId',title:'商品id',width:100,align:'center'},
        {field:'goodsName',title:'商品名称',width:200,align:'center'},
        {field:'goodsSubtitle',title:'商品副标题',width:300,align:'center'},
        {field:'gcId',title:'商品分类id',width:100,align:'center'},
        {field:'gcName',title:'商品分类名称',width:100,align:'center'},
        {field:'goodsPrice',title:'商品原价',width:100,align:'center'},
        {field:'goodsSellPrice',title:'商品现价',width:100,align:'center'},
        {field:'goodsImage',title:'商品图片',width:200,align:'center'},
        {field:'goodsClick',title:'商品浏览数',width:100,align:'center'},
        {field:'goodsState',title:'商品状态',width:100,align:'center'},
        {field:'goodsCommend',title:'商品推荐',width:100,align:'center'},
        {field:'goodsCloseReason',title:'商品违规下架原因',width:200,align:'center'},
        {field:'commentNum',title:'评论次数',width:100,align:'center'},
        {field:'thumbsUpNum',title:'商品点赞量',width:100,align:'center'},
        {field:'salenumNum',title:'售出数量',width:100,align:'center'},
        {field:'goodsCollectNum',title:'商品收藏数量',width:100,align:'center'},
        {field:'isDel',title:'是否删除 ',width:100,align:'center'},
        {field:'memberId',title:'上传者',width:100,align:'center'},
        {field:'stock',title:'商品库存',width:100,align:'center'},
        {field:'updateTime',title:'商品修改时间',width:200,align:'center'},
        {field:'createTime',title:'商品上传时间',width:200,align:'center'}
      ]],
      url:"goodsinfodata",
      pagination:true,

      fit:true,
      title:"商品列表",
      toolbar: [{
        iconCls: 'icon-add',
        text:'增加商品',
        handler: function(){
          alert('弹出一个增加商品的窗口')}
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
  <table id="goods"></table>
</div>


<jsp:include page="wei.jsp"></jsp:include>

