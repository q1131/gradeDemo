 <%@page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
  <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
  <script src="js/jquery-1.8.3.min.js" language="javascript"></script>
  <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
  <script src="js/jquery.easyui.min.js"></script>
   <script language="javascript">
    //使用jquery封装ajax的方法实现异步调用
    /*$(document).ready(function(){

    });*/
    $(function(){  //jquery的加载事件
       //给按钮添加点击事件
       $("#but1").click(function(){
           //alert("点不死你...");
           //使用ajax技术获取服务器数据
          /* $.ajax({
               type: "get",  //发送请求的方式
               url: "getData2", //发送请求的服务器地址
               //data: "name=John&location=Boston",  //给服务传递
               dataType:"json", //表示返回的是json格式
               success: function(data){  //回调函数  data代表的就是服务器返回的数据
                  // alert( "Data Saved: " + data );
                   // 将数据显示到网页里
                   var table="<table border=1>";
                   table=table+"<tr><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>生日</td></tr>";
                   for(var i=0;i<data.length;i++){
                     var s=data[i];
                       table=table+"<tr><td>"+s.xh+"</td><td>"+s.name+"</td><td>"+s.sex+"</td><td>"+s.age+"</td><td>"+s.birthday+"</td></tr>";
                   }
                   table=table+"</table>";
                   //显示
                   $("#div1").html(table);
               }
           });*/

         //使用get或者post发送异步请求获取数据
           //$.post("服务器地址","传递给服务器的参数",回调函数,"json");
           $.post("getData2",null,function(data){
               // 将数据显示到网页里
               var table="<table border=1>";
               table=table+"<tr><td>学号</td><td>姓名</td><td>性别</td><td>年龄</td><td>生日</td></tr>";
               for(var i=0;i<data.length;i++){
                   var s=data[i];
                   table=table+"<tr><td>"+s.xh+"</td><td>"+s.name+"</td><td>"+s.sex+"</td><td>"+s.age+"</td><td>"+s.birthday+"</td></tr>";
               }
               table=table+"</table>";
               //显示
               $("#div1").html(table);
           },"json")

      });



       $("#but2").click(function(){
            //绑定数据展示  自动给请求传递页码page，页大小rows
           $('#dg').datagrid({
               url:'getData3',
               pagination:true,  // 显示分页插件
               pageList:[3,6,9,12],  //设置每页显示条数
               pageSize:3,  //默认页大小
               columns:[[
                   {field:'xh',title:'学号',width:100},
                   {field:'name',title:'姓名',width:100},
                   {field:'sex',title:'性别',width:100,align:'right'},
                   {field:'age',title:'年龄',width:100,align:'right'},
                   {field:'birthday',title:'生日',width:100,align:'right',
                       //实现单元格的格式
                       formatter: function(value,row,index){
                          //return "<input type='text' value='"+value+"'>";  //内容就是显示在单元格中的内容
                          var date=new Date(value);
                          var year=date.getFullYear();
                           var moneth=date.getMonth()+1;
                           var day=date.getDay();

                          return year+"年"+moneth+"月"+day+"日";
                   }
                   },
                   {field:'address',title:'地址',width:100,align:'right'},
                   {field:'gid',title:'年级编号',width:100,align:'right'}
               ]]
           });

       });
    });
  </script>
</head>
<body>
  <input  type="button"   id="but1" value="显示所有学生">
  <div id="div1"></div>
  <hr/>
  <!--
  <table class="easyui-datagrid" style="width:400px;height:250px"
              data-options="url:'getData2',fitColumns:true,singleSelect:true">
  <thead>
  <tr>
    <th data-options="field:'xh',width:100">学号</th>
    <th data-options="field:'name',width:100">姓名</th>
    <th data-options="field:'sex',width:100,align:'right'">性别</th>
  </tr>
  </thead>-->
  <input  type="button"   id="but2" value="显示所有学生使用datagrid">

  <table id="dg"></table>

  </table>
</body>
</html>
