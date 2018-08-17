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
    loadData("goodsinfodata",null);


    $("#search").panel({
      width: "100%",
      height:80,
      title:'搜索'
    });

    $("#ss").searchbox({
      searcher: function(value,name){
        loadData("goodsinfodatabypro",{pn: name,pv: value});
      },
      menu:'#mm',
      prompt:'请输入搜素关键字'
    });


    $("status").combobox({
      data:[
        {
          "value": "",
          "text":"全部"
        },{
          "value": "1",
          "text":"启用"
        },{
          "value": "0",
          "text":"禁用"
        }
      ],
      editable:false,
      onsSelect:function(){
        var v= $('#status').combobox("getValue");
        loadData("goodsinfodatabypro",{pn: "goods_state",pv: v});
      }
    });

    $('#start').datetimebox();
    $('#end').datetimebox();
    //搜索按钮
    $("#link").linkbutton;
    $('#link').bind('click',function(){
      var start = $('#start').datetimebox('getValue').toString();
      var end =$('#end').datetimebox('getValue').toString();
      if(start&&end){
        loadData("goodsinfodatabytime",{startTime:start,endTime:end});
      }else{
        loadData("goodsinfodata",null);
      }
    });


  })

function loadData(url,param){
  $('#goods').datagrid({
    queryParams:param,
    height:700,
    columns:[[
      {field:'fuZhu',title:'X',width:50,align:'center',checkbox:true},
      {field:'goodsId',title:'商品id',width:100,align:'center'},
      {field:'goodsName',title:'商品名称',width:200,align:'center'},
      {field:'goodsSubtitle',title:'商品副标题',width:300,align:'center'},
      {field:'gcId',title:'商品分类id',width:100,align:'center'},
      {field:'gcName',title:'商品分类名称',width:100,align:'center'},
      {field:'goodsPrice',title:'商品原价',width:100,align:'center'},
      {field:'goodsSellPrice',title:'商品现价',width:100,align:'center'},
      {field:'goodsImage',title:'商品图片',width:200,align:'center',formatter:function(v,r,i){
        return "<img src="+v+" height=20";
      }},
      {field:'goodsClick',title:'商品浏览数',width:100,align:'center'},
      {field:'goodsState',title:'商品状态',width:100,align:'center',formatter:function(v,r,i){
        if(v==1){
          return "违规下架";
        }else{
          return "开启";
        }
      }},
      {field:'goodsCommend',title:'商品推荐',width:100,align:'center',formatter:function(v,r,i){
        if(v==1){
          return "推荐";
        }else{
          return "未推荐";
        }
      }},
      {field:'goodsCloseReason',title:'商品违规下架原因',width:200,align:'center'},
      {field:'commentNum',title:'评论次数',width:100,align:'center'},
      {field:'thumbsUpNum',title:'商品点赞量',width:100,align:'center'},
      {field:'salenumNum',title:'售出数量',width:100,align:'center'},
      {field:'goodsCollectNum',title:'商品收藏数量',width:100,align:'center'},
      {field:'isDel',title:'是否删除 ',width:100,align:'center',formatter:function(v,r,i){
        if(v==1){
          return "已删除";
        }else{
          return "未删除";
        }

      }},
      {field:'memberId',title:'上传者',width:100,align:'center'},
      {field:'stock',title:'商品库存',width:100,align:'center'},
      {field:'updateTime',title:'商品修改时间',width:200,align:'center',formatter:function(value,row,index){
        if(value){
          var unixTimestamp = new Date(value);
          return unixTimestamp.toLocaleString('chinese',{hour12:false});
        }
        else
          return null;
      }},
      {field:'createTime',title:'商品上传时间',width:200,align:'center',formatter:function(value,row,index){
        if(value){
          var unixTimestamp = new Date(value);
          return unixTimestamp.toLocaleString('chinese',{hour12:false});
        }
        else return null;
      }},
      {field:'edit',title:"编辑",width:100,align:'center',formatter:function(v,r,i){
        return "<a href='javascript:showWindow("+ r.goodsId+")'>编辑</a>"
      }},
      {field:'delete',title:"删除",width:100,align:'center',formatter:function(v,r,i){
        return "<a href='javascript:del("+ r.goodsId+")'>删除</a>"
      }}
    ]],
    url:url,
    pagination:true,
    singleSelect:true,

    title:"商品列表",
    toolbar: [{
      iconCls: 'icon-add',
      text:'增加商品',
      handler: function(){
        showInsertWindow()}
    }]


  })
}
  function del(goodsId){
    $("deleteGoods").window({
      width:800,
      height:500,
      title:"删除商品信息"
    })
    $("#contentbody2").attr("src","http://localhost:8080/deletegoodsinfobyid?id="+goodsId)
    $('#goods').datagrid('reload')
  }
  function showInsertWindow(){
    $("#insertGoods").window({
      width:800,
      height:500,
      title:"增加商品信息",
      onClose:function(){
        $('#goods').datagrid('reload')
      }
    })
    $("#contentbody1").attr("src","http://localhost:8080/page_shangpinzengjia")
  }
  function showWindow(goodsId){
    $("#updateGoods").window({
      width:800,
      height:500,
      title:"编辑商品信息",
      onClose:function(){
        $('#goods').datagrid('reload')
      }
    })
    $("#contentbody").attr("src","http://localhost:8080/goodsinfobyid?id="+goodsId)
  }

</script>





<div id="content" region="center"  style="padding:5px;">
  <div id="search" style="padding:10px;">
    <table width="100%" border="0">
      <tr>
        <td align="left" width="80">
          关键字搜索:
        </td>
        <td align="left" width="200">
          <input id="ss" class="easyui-searchbox" style="width:300px" />
          <div id="mm" style="width:120px">
            <div data-options="name:'goods_name'">按商品名搜索</div>
          </div>
        </td>
        <td width="80" align="left">
          按状态搜索:
        </td>
        <td width="200">
          <input id="status" name="dept" value="全部">
        </td>
        <td width="80" align="left">
          根据创建时间:
        </td>
        <td width="350">
          <input id="start" name="start">
          -
          <input id="end" name="end" >
        </td>
        <td>
          <a href="#" id="link">搜索</a>
        </td>
      </tr>
    </table>
  </div>

  <div id="content" region="center" title=""  style="padding: 5px;">
    <table id="goods"></table>
    <div id="updateGoods">
      <iframe id="contentbody" src="" width="600" frameborder="0" height="400" scrolling="no"></iframe>
    </div>
    <div id="insertGoods">
      <iframe id="contentbody1" src="" width="800" frameborder="0"  scrolling="no"></iframe>
    </div>
    <div id="deleteGoods">
      <iframe id="contentbody2" src="" width="800" frameborder="0" scrolling="no" style="display: none"></iframe>
    </div>
</div>
</div>
<jsp:include page="wei.jsp"></jsp:include>

