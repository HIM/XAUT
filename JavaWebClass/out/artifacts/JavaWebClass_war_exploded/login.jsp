<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.0.min.js"></script>

    <script src="js/login_Jquery.js"></script>

</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        Date date = new Date();String year = String.format("%tY", date);String month = String.format("%tm", date);String day = String.format("%td", date);String dateStr = year + "/" + month + "/" + day;
        request.setAttribute("dateStr",dateStr);

        String username = "";
        String password = "";
        String s;
        Cookie [] cookies =request.getCookies();
        for (Cookie cookie:cookies) {
            s=cookie.getName(); //通过getName方法获得cookie的名称
            if (s.equals("username")) {
                if (cookie.getValue()!=null) {
                    username=username+cookie.getValue(); //通过getValue方法获得cookie的值
                }
            } else
            if (s.equals("password")) {
                if (cookie.getValue()!=null) {
                    password=password+cookie.getValue();
                }
            }
        }
    %>
    <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">登录</h3>
        <form id="iform" action="${pageContext.request.contextPath}/loginServlet" method="post">
            <div class="form-group">
                <label for="username">用户名：</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            </div>

            <div class="form-inline">
                <label>验证码：</label>
                <input type="text" name="check" class="form-control" id="check" placeholder="请输入验证码" style="width: 120px;"/>
                <img src="img/timg.jpg" style="width: 100px;"/>
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" id="isubmit" type="button" value="登录">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/regist.jsp">注册</a>
            </div>
        </form>
    </div>

</body>
</html>