<%@ page import="java.util.List" %>
<%@ page import="javawebclass.domain.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.0.min.js"></script>
    <script>
        <%--$(function () {--%>
            <%--$("#del").click(function () {--%>
                <%--if (confirm("您确定要删除？")) {}--%>
                    <%--window.location.href = "${pageContext.request.contextPath}/deleteServlet?id="--%>
            <%--})--%>
        <%--})--%>
        function del(id){
            if(confirm("您确定要删除嘛？")){
                location.href = "${pageContext.request.contextPath}/deleteServlet?id="+id;
            }
        }
    </script>
</head>
<body>
    <%
        Date date = new Date();String year = String.format("%tY", date);String month = String.format("%tm", date);String day = String.format("%td", date);String dateStr = year + "/" + month + "/" + day;
        request.setAttribute("dateStr",dateStr);
        String usern =  session.getAttribute("username").toString();
    %>
    <div class="container">
        <%--<div id="head">--%>
            <%--<div id="head_left">用户管理</div>--%>
            <%--<div id="head_right"><%=dateStr%></div>--%>
        <%--</div>--%>
        <form id="form-inline" action="${pageContext.request.contextPath}/findServlet">
            <tr>
                <td><input type="text" name="search"/></td>
                <td><input type="submit" value="查找"/></td>
            </tr>
            <span id="nowName">
                当前账户用户名：<%=usern%>
            </span>
        </form>
        <div id="context">
            <table border="1" id="table" class="table table-bordered table-hover">
                <tr class="success">
                    <th>用户id</th>
                    <th>用户名</th>
                    <th>姓名</th>
                    <th>用户类型</th>
                    <th>手机号码</th>
                    <th>邮箱</th>
                    <th>所在单位</th>
                    <th>操作</th>
                </tr>

                <%
                    List<User> list = (List<User>) request.getAttribute("list");
                    if(list == null || list.size()<1){
                        PrintWriter writer = response.getWriter();
                        writer.print("没有数据");
                        writer.flush();
                        writer.close();
                    }else {
                        for (User user : list){
                %>
                <tr class="hang">
                    <td><%=user.getId()%></td>
                    <td><%=user.getUsername()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getUsertype()%></td>
                    <td><%=user.getPhone()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getDepartment()%></td>
                    <td>
                        <a class="btn btn-default btn-sm" id="del" href="javascript:del(<%=user.getId()%>);">删除</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/alterServlet?id=<%=user.getId()%>" onclick="update()">修改</a>&nbsp;
                    </tr>
                <%
                        }
                    }
                %>

            </table>
        </div>
    </div>
</body>
</html>