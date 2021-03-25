<%@ page import="javawebclass.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/11/2
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <link href="css/javaweb.css" rel="stylesheet">


    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.0.min.js"></script>

    <script src="js/alterUser_Jquery.js"></script>
</head>
<body>
    <%
        Date date = new Date();String year = String.format("%tY", date);String month = String.format("%tm", date);String day = String.format("%td", date);String dateStr = year + "/" + month + "/" + day;
        request.setAttribute("dateStr",dateStr);
        User user = (User)request.getAttribute("user");
        session.setAttribute("id",user.getId());
    %>
<div id="box">
    <div id="head">
        <div id="head_left">修改用户信息</div>
        <div id="head_right"><%=dateStr%></div>
    </div>
    <div id="context">
        <form id="form" action="${pageContext.request.contextPath}/updateServlet" method="POST">
            <table border="0" class="form_table">
                <tr>
                    <td>用户类型：</td>
                    <td>
                        <input type="radio" name="usertype" value="学生" id="usertype1"/>学生
                        <input type="radio" name="usertype" value="教师" id="usertype2"/>教师
                        <input type="radio" name="usertype" value="管理员" id="usertype3"/>管理员
                    </td>
                </tr>
                <tr>
                    <td>用&nbsp;户&nbsp;名：</td>
                    <td>
                        <input type="text" name="username" id="username" value="<%=user.getUsername()%>"/>
                    </td>
                    <td id="message_u" class="error"></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                    <td>
                        <input type="text" name="password" id="password" value="<%=user.getPassword()%>"/>
                    </td>
                    <td id="message_p" class="error"></td>
                </tr>
                <tr>
                    <td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                    <td>
                        <input type="text" name="name" id="name" value="<%=user.getName()%>"/>
                    </td>
                    <td id="message_n" class="error"></td>
                </tr>
                <tr>
                    <td>手机号码：</td>
                    <td>
                        <input type="text" name="phone" id="phone" value="<%=user.getPhone()%>"/>
                    </td>
                    <td id="message_phone" class="error"></td>
                </tr>
                <tr>
                    <td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
                    <td>
                        <input type="text" name="email" id="email" value="<%=user.getEmail()%>"/>
                    </td>
                    <td id="message_e" class="error"></td>
                </tr>
                <tr>
                    <td>所在单位：</td>
                    <td>
                        <input type="text" name="department" id="department" value="<%=user.getDepartment()%>"/>
                    </td>
                    <td id="message_d" class="error"></td>
                </tr>
            </table>
            <div id="sub">
                <input type="reset" value="重置" id="reset"/>
                <input type="submit" value="提交" id="submit"/>
            </div>
        </form>
    </div>
    <div id="foot">
        <div id="foot_word">Liugm@xaut.edu.cn</div>
    </div>
</div>

</body>
</html>
