<%@ page import="medicines.domain.Storage" %>
<%@ page import="java.util.List" %>
<%@ page import="medicines.domain.Medicine" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="medicines.domain.details.outMore" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/1/13
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>药品进销存管理系统</title>
    <link href="./Dashboard Template for Bootstrap_files/bootstrap.min.css" rel="stylesheet">
    <link href="./Dashboard Template for Bootstrap_files/dashboard.css" rel="stylesheet">
    <script src="./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-brand">药品进销存管理系统</div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/overView.jsp">概览</a></li>
                <li><a href="${pageContext.request.contextPath}/infoServlet">药品信息</a></li>
                <li><a href="${pageContext.request.contextPath}/resposityServlet">仓库</a></li>
                <li><a href="${pageContext.request.contextPath}/factoryServlet">生产厂家</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/inServlet">进货单</a></li>
                <li><a href="${pageContext.request.contextPath}/outServlet">销售单</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/inMoreServlet">进货明细</a></li>
                <li class="active"><a href="#">销售明细</a></li>
                <li><a href="${pageContext.request.contextPath}/clientServlet">客户</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/userBuyServlet">客户购买</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h2 class="sub-header">销售明细</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <tr>
                        <th>销售单号</th>
                        <th>客户账号</th>
                        <th>药品编号</th>
                        <th>药品名称</th>
                        <th>售价</th>
                        <th>折扣</th>
                        <th>数量</th>
                        <th>销售日期</th>
                        <th>总价</th>
                    </tr>
                    <%
                        List<outMore> list = (List<outMore>) request.getAttribute("list");
                        if(list == null || list.size()<1){
//                            PrintWriter writer = response.getWriter();
//                            writer.print("没有数据");
//                            writer.flush();
//                            writer.close();
                        }else {
                            for (outMore outmore : list){
                    %>

                    <tr id="medicine_list">
                        <%--<td><img src="<%=storage.getImg_url()%>" style="width: 40px;"></td>--%>
                        <td><%=outmore.getSale_id()%></td>
                        <td><%=outmore.getUser_id()%></td>
                        <td><%=outmore.getMed_id()%></td>
                            <td><%=outmore.getMed_name()%></td>
                            <td><%=outmore.getTrue_price()%></td>
                            <td><%=outmore.getSale_discount()%></td>
                            <td><%=outmore.getSale_num()%></td>
                            <td><%=outmore.getSale_date()%></td>
                            <td><%=outmore.getSum_price()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="./Dashboard Template for Bootstrap_files/jquery.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/bootstrap.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/holder.min.js"></script>
<script src="./Dashboard Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>

</body>
</html>
