<%@ page import="medicines.domain.details.Factory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/1/13
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>药品进销存管理系统</title>
    <link href="./Dashboard Template for Bootstrap_files/bootstrap.min.css" rel="stylesheet">
    <link href="./Dashboard Template for Bootstrap_files/dashboard.css" rel="stylesheet">
    <script src="./Dashboard Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>

    <link rel="stylesheet" href="./css/my.css">
    <link rel="stylesheet" href="./css/settlement.css">
    <link rel="stylesheet" href="./css/bottom.css">

    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script type="text/javascript" src="./js/dropdown.js"></script>
    <script>
        window.onload = function() {

            //获取所有+按钮
            var increment = document.getElementsByClassName("increase");

            for (var i = 0; i < increment.length; i++) {
                //为a标签添加index属性，用于记录下标
                increment[i].index = i;

                //点击+数量增加的功能函数
                increment[i].onclick = function() {
                    var flag = this.index;
                    //获取当前a标签对应的数量框
                    var q = document.getElementsByClassName("quantity")[flag];

                    var newvalue = parseInt(q.value) + 1;

                    //用q.value=parseInt(q.value)+1
                    //会导致数值只在点击的一瞬间发生变化，然后又跳回1
                    q.setAttribute('value', newvalue);
                    //更新此商品对应的‘小计’
                    changeSum(flag, newvalue);
                }
            }

            //获取所有-按钮
            var decrement = document.getElementsByClassName('decrease');

            //点击-数量减少的功能函数
            for (var j = 0; j < decrement.length; j++) {
                decrement[j].index = j;

                decrement[j].onclick = function() {
                    var flag = this.index;
                    //获取当前a标签对应的那个数量框
                    var q = document.getElementsByClassName("quantity")[flag];

                    if (parseInt(q.value) > 0) {
                        var newvalue = parseInt(q.value) - 1;

                        q.setAttribute('value', newvalue);

                        changeSum(flag, newvalue);
                    }
                }
            }


            //结算功能
            var calculate = document.getElementById('calculate');

            calculate.onclick = function() {

                var radios = document.getElementsByName('p-radio');

                var sumPrice = 0;

                var p = document.getElementsByClassName('onlySum');

                for (var m = 0; m < p.length; m++) {
                    sumPrice = sumPrice + parseInt(p[m].innerHTML);
                }

                document.getElementsByClassName("sum-price")[0].innerHTML = sumPrice;
            }


            //提交订单的功能
            var submit = document.getElementById("submit-order");

            submit.onclick = function() {

                var data = [];
                var radios = document.getElementsByName('p-radio');
                var count = document.getElementsByClassName("quantity");
                var items = document.getElementsByClassName("item");

                for (var m = 0; m < radios.length; m++) {
                    if (radios[m].checked == true) {
                        var item = {};
                        item.tradeid = items[m].getAttribute('id');
                        item.amount = count[m].value;

                        data.push(item);
                    }
                }

                var result = JSON.stringify(data);

                $.ajax({
                    type: "post",

                    url: '', //后台请求地址

                    data: result,

                    contentType: "application/json", //如果提交的是json数据类型，则必须有此参数,表示提交的数据类型 

                    async: false, //异步请求

                    success: function() {},

                    error: function() {
                        alert("订单总额为");
                    }

                });
            }
        }


        //更新每个商品的‘小计’
        function changeSum(flag, num) {
            //获取对应单价所在的标签
            var temp = document.getElementsByClassName("onlyPrice")[flag];

            //获取单价
            var unitPrice = temp.innerHTML;

            //计算新的小计价格
            var newPrice = parseInt(unitPrice) * num;

            var sum = document.getElementsByClassName("onlySum")[flag];

            sum.innerHTML = newPrice;
        }


        //设置全选/全不选的功能
        function setAll() {
            var box = document.getElementById('allchecked');

            var radios = document.getElementsByName('p-radio');

            //alert(box.checked);

            if (box.checked == false) {
                for (var i = 0; i < radios.length; i++) {
                    radios[i].checked = false;
                }
            } else {
                for (var i = 0; i < radios.length; i++) {
                    radios[i].checked = true;
                }
            }
        }
    </script>
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
                <li class="active"><a href="#">生产厂家</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/inServlet">进货单</a></li>
                <li><a href="${pageContext.request.contextPath}/outServlet">销售单</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/inMoreServlet">进货明细</a></li>
                <li><a href="${pageContext.request.contextPath}/outMoreServlet">销售明细</a></li>
                <li><a href="${pageContext.request.contextPath}/clientServlet">客户</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="${pageContext.request.contextPath}/userBuyServlet">客户购买</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <h2 class="sub-header">已生产商品清单</h2>
            <div class="table-responsive">
                <form method="post" action="${pageContext.request.contextPath}/putInServlet">
                <table class="table table-striped">
                    <tr>
                        <th>厂家名称</th>
                        <th>药品名称</th>
                        <th>药品编号</th>
                        <th>生产日期</th>
                        <th>进价</th>
                        <th>数量</th>
                        <th>小计</th>
                    </tr>
                    <%
                        List<Factory> list = (List<Factory>) request.getAttribute("list");
                        if(list == null || list.size()<1){
                        }else {
                            for (Factory factory : list){
                    %>

                    <tr id="<%=factory.getMed_identify()%>">
                        <td><%=factory.getFac_name()%></td>
                        <td><%=factory.getMed_name()%></td>
                        <%--<td name="<%=factory.getMed_identify()%>_id"><%=factory.getMed_identify()%></td>--%>
                        <td><input name="<%=factory.getMed_identify()%>_id" value="<%=factory.getMed_identify()%>" /></td>
                        <td><%=factory.getProduction_date()%></td>
                        <td class="onlyPrice"><%=factory.getPurchase_price()%></td>
                        <td class="p-quantity">
                            <input type="button" class="decrease" value="-">
                            <input name="<%=factory.getMed_identify()%>_num" type="text" class="quantity" value="0"/>
                            <input type="button" class="increase" value="+">
                        </td>
                        <td><div class="p-sum">￥<span class="onlySum">0</span></div></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>

                    <div class="settlement">
                        <div class="ww">
                            <div id="calculate">结算</div>
                            <div class="price-sum">
                                总价：￥<span class="sum-price"></span>
                            </div>
                        </div>

                        <div class="submit">
                            <button class="btn btn-danger" type="submit">提交进货订单</button>
                            <%--<a href="javascript:void(0)" id="submit-order">提交订单</a>--%>
                        </div>
                    </div>



                </form>
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
