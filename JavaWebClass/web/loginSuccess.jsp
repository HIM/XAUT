<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/10/29
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
    <link href="css/javaweb.css" rel="stylesheet">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.0.min.js"></script>
</head>
<body>
    <%
        Date date = new Date();String year = String.format("%tY", date);String month = String.format("%tm", date);String day = String.format("%td", date);String dateStr = year + "/" + month + "/" + day;
        request.setAttribute("dateStr",dateStr);
        String username = request.getParameter("username");
    %>
    <div id="box">
        <div id="head">
            <div id="head_left"><a href="#">登录成功</a></div>
            <div id="head_right"><%=dateStr%></div>
        </div>
        <div id="context">
            <div id="context_head"><%=username%>,欢迎您</div>
            <%--<a href="${pageContext.request.contextPath}/findServlet" style="text-decoration:none;font-size:33px">进入管理页面</a>--%>
            <a href="${pageContext.request.contextPath}/manage.jsp" style="text-decoration:none;font-size:33px">进入管理页面</a>
        </div>
        <div id="foot">
            <div id="foot_word">Liugm@xaut.edu.cn</div>
        </div>
    </div>
</body>
</html>
