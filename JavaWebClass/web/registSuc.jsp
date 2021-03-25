<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/10/12
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <link href="css/javaweb.css" rel="stylesheet">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.0.min.js"></script>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
    %>
    <jsp:useBean id="user" class="javawebclass.domain.User">
        <jsp:setProperty name="user" property="*"/>
    </jsp:useBean>
    <%
        Date date = new Date();String year = String.format("%tY", date);String month = String.format("%tm", date);String day = String.format("%td", date);String dateStr = year + "/" + month + "/" + day;
        request.setAttribute("dateStr",dateStr);
        session.setAttribute("username",user.getUsername());
        session.setAttribute("username",user.getUsername());
        session.setAttribute("password",user.getPassword());
        session.setAttribute("usertype",user.getUsertype());
        session.setAttribute("truename",user.getName());
        session.setAttribute("phone",user.getPhone());
        session.setAttribute("email",user.getEmail());
        session.setAttribute("department",user.getDepartment());
    %>
    <div id="box">
        <div id="head">
            <div id="head_left"><a href="#">注册成功</a></div>
            <div id="head_right"><%=dateStr%></div>
        </div>
        <div id="context">
            <div id="context_head">注册成功</div>
            <div>
                <ul>
                    <li>
                        用户名：<jsp:getProperty name="user" property="username" />
                    </li>
                    <li>
                        密码：<jsp:getProperty name="user" property="password" />
                    </li>
                    <li>
                        用户类型：<jsp:getProperty name="user" property="usertype" />
                    </li>
                    <li>
                        姓名：<jsp:getProperty name="user" property="name" />
                    </li>
                    <li>
                        电话号码：<jsp:getProperty name="user" property="phone" />
                    </li>
                    <li>
                        邮箱：<jsp:getProperty name="user" property="email" />
                    </li>
                    <li>
                        部门：<jsp:getProperty name="user" property="department" />
                    </li>
                </ul>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/regServlet">点击进入管理页面</a>
            </div>
        </div>
        <div id="foot">
            <div id="foot_word">Liugm@xaut.edu.cn</div>
        </div>
    </div>

</body>
</html>
