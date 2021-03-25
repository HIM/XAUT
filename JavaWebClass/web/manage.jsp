<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/11/23
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <%--<script src="js/manage_Jquery.js"></script>--%>
</head>
<body>
    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">用户管理</h3>
            </div>
            <div class="panel-body">
                <form id="form-inline" action="${pageContext.request.contextPath}/findServlet">
                    <tr>
                        <td><input type="text" name="search" id="search"/></td>
                        <td><input type="submit" value="查找"/></td>
                    </tr>
                    </span>
                </form>
                <table border="1" id="table" class="table table-bordered table-hover">
                    <thead>
                    <tr class="success">
                        <th>序号</th>
                        <th>用户id</th>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>用户类型</th>
                        <th>手机号码</th>
                        <th>邮箱</th>
                        <th>所在单位</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody id="tb_user">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            var searchText = $("#search").val();
            $("#tb_user").html("");
            $.getJSON("findServlet?search=" + searchText, function (result) {
                console.log("result: "+result);
                var tbhtml = "";
                alert("success");
                $.each(result, function (i, field) {
                    if(i % 2 == 0){
                        tbhtml += "<tr class='success'>"
                    }else{
                        tbhtml += "<tr class='warning'>"
                    }
                    tbhtml += "<td>" + (i+1) + "</td>";
                    tbhtml += "<td>" + field.id + "</td>";
                    tbhtml += "<td>" + field.username + "</td>";
                    tbhtml += "<td>" + field.name + "</td>";
                    tbhtml += "<td>" + field.usertype + "</td>";
                    tbhtml += "<td>" + field.phone + "</td>";
                    tbhtml += "<td>" + field.email + "</td>";
                    tbhtml += "<td>" + field.department + "</td>";
                    tbhtml += "<td><button type='button' class='btn btn-primary btn-ns' onclick='showEdit(" + field.id +")'>编辑</button><button type='button' class='btn btn-danger btn-ns'>删除</button></td>";
                    tbhtml += "</tr>"
                })
                $("#tb_user").html(tbhtml);
            });

        })

    </script>
</body>
</html>
