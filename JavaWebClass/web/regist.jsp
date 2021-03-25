<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>regist</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.0.min.js"></script>

    <script src="js/regist_Jquery.js"></script>
</head>
<body>
    <%
        Date date = new Date();String year = String.format("%tY", date);String month = String.format("%tm", date);String day = String.format("%td", date);String dateStr = year + "/" + month + "/" + day;
        request.setAttribute("dateStr",dateStr);
    %>
    <div class="container" style="width: 400px;">
        <center><h1>注册</h1></center>
        <form id="iform" action="${pageContext.request.contextPath}/registSuc.jsp" method="post">
            <div class="form-group">
                <label>用户类型</label>
                <input type="radio" name="usertype" value="学生" checked="checked"/>学生
                <input type="radio" name="usertype" value="教师"/>教师
                <input type="radio" name="usertype" value="管理员"/>管理员
            </div>
            <div class="form-group">
                <label>用户名</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名"/>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="text" name="password" class="form-control" id="password" placeholder="请输入密码"/>
            </div>
            <div class="form-group">
                <label>确认密码</label>
                <input type="text" name="conpassword" class="form-control" id="conpassword" placeholder="确认密码请和上一行密码保持相同"/>
            </div>
            <div class="form-group">
                <label>真实姓名</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="请输入真实姓名"/>
            </div>
            <div class="form-group">
                <label>手机号码</label>
                <input type="text" name="phone" class="form-control" id="phone" placeholder="请输入手机号码"/>
            </div>
            <div class="form-group">
                <label>邮箱</label>
                <input type="text" name="email" class="form-control" id="email" placeholder="请输入邮箱"/>
            </div>
            <div class="form-group">
                <label>所在单位</label>
                <input type="text" name="department" class="form-control" id="department" placeholder="请输入所在单位名称"/>
            </div>
            <div class="form-group">
                <label>验证码</label>
                <input type="text" name="check" class="form-inline" id="check" placeholder="请输入验证码"/>
                <img src="img/timg.jpg" style="width: 100px;"/>
            </div>
            <div class="form-group" style="text-align: center">
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn btn-primary" type="button" id="isubmit" value="注册">
            </div>
        </form>
    </div>
</body>
</html>