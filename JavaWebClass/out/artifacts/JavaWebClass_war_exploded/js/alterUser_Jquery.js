$(function () {
    $("#isubmit").click(function () {
        var reg_phone = /^[1][3,4,5,7,8][0-9]{9}$/;
        var reg_email = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        if ($("#username").val() == ""){
            return;
        }else if($("#password").val() == ""){
            return;
        }else if($("#name").val() == ""){
            return;
        }else if($("#phone").val() == ""){
            return;
        }else if($("#email").val() == ""){
            return;
        }else if($("#department").val() == ""){
            return;
        }else if($("#check").val() !== "uwv6"){
            return;
        }else
        if($("#username").val() !== "" && $("#password").val() !== "" && $("#name").val() !== "" && reg_phone.test($("#phone").val()) && reg_email.test($("#email").val()) && $("#department").val() !== "" && $("#check").val() == "uwv6"){
            $("#iform").submit();
        }
    })

    $("#username").blur(function () {
        var check = $("#username").val();
        if(check == ""){
            $("#message_u").html("请输入用户名")
        }else if(check !== ""){
            $("#message_u").html("<img width='35' height='25' src='img/gou.png'/>");
        }
    })
    $("#password").blur(function () {
        var check = $("#password").val();
        if(check == ""){
            $("#message_p").html("请输入密码")
        }else if(check !== ""){
            $("#message_p").html("<img width='35' height='25' src='img/gou.png'/>");
        }
    })
    $("#name").blur(function () {
        var check = $("#name").val();
        if(check == ""){
            $("#message_n").html("请输入姓名")
        }else if(check !== ""){
            $("#message_n").html("<img width='35' height='25' src='img/gou.png'/>");
        }
    })
    $("#phone").blur(function () {
        var phone = $("#phone").val();
        var reg_phone = /^[1][3,4,5,7,8][0-9]{9}$/;
        var flag = reg_phone.test(phone);
        if(flag){
            $("#message_phone").html("<img width='35' height='25' src='img/gou.png'/>");
        }else {
            $("#message_phone").html("手机号码格式不正确")
        }
    })
    $("#email").blur(function () {
        var email = $("#email").val();
        var reg_email = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        var flag = reg_email.test(email);
        if(flag){
            $("#message_e").html("<img width='35' height='25' src='img/gou.png'/>");
        }else {
            $("#message_e").html("邮箱格式不正确")
        }
    })
    $("#department").blur(function () {
        var check = $("#department").val();
        if(check == ""){
            $("#message_d").html("请输入所在单位")
        }else if(check !== ""){
            $("#message_d").html("<img width='35' height='25' src='img/gou.png'/>");
        }
    })
    $("#check").blur(function () {
        var checkk = $("#check").val();
        if(checkk == "uwv6"){
            $("#message_c").html("<img width='35' height='25' src='img/gou.png'/>");
        }else if(checkk !== "uwv6"){
            $("#message_c").html("验证码输入错误")
        }
    })

})
