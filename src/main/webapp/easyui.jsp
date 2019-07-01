<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/15
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.min.js" language="javascript"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript">
        $(function(){  //加载事件
           $("#but1").click(function(){
               //弹出对话框
               $('#dd').dialog({
                   title: 'My Dialog',
                   width: 400,
                   height: 200,
                   closed: false,
                   cache: false,
                   href: 'add.jsp',
                   modal: true
               });


           });


        });

    </script>

</head>
<body>
<input type="button" id="but1" value="添加">
<!--
<div id="dd" class="easyui-dialog" title="添加学生" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true">
    >>添加年级
    <form method="post" name="s" action="addGrade">
        年级名称:<input type="text" name="gname" /><br/>
        <input type="submit" name="ss" value="添加" />
    </form>
</div>-->
<div id="dd">Dialog Content.</div>

<div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
    <div title="Tab1" style="padding:20px;">
        tab1
    </div>
    <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;">
        tab2
    </div>
    <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;">
        tab3
    </div>
</div>
</body>
</html>
