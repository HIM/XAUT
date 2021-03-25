$(document).ready(function () {
    var searchText = $("#search").val();
    $("#tb_user").html("");
    $.getJSON("findServlet?search=" + searchText, function (result) {
        console.log("result: "+result);
        var tbhtml = "";
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

