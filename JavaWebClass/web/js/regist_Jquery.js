$(function () {
    $("#isubmit").click(function () {
        var reg_phone = /^[1][3,4,5,7,8][0-9]{9}$/;
        var reg_email = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        if ($("#username").val() == ""){
            alert("用户名为空");
            return;
        }else if($("#password").val() == ""){
            alert("用户名为空");
            return;
        }else if($("#conpassword").val() !== $("#password").val()){
            alert("密码为空");
            return;
        }else if($("#name").val() == ""){
            alert("真实姓名为空");
            return;
        }else if($("#phone").val() == ""){
            alert("电话号码请输入正确格式");
            return;
        }else if($("#email").val() == ""){
            alert("邮箱请输入正确格式");
            return;
        }else if($("#department").val() == ""){
            alert("部门为空");
            return;
        }else if($("#check").val() !== "uwv6"){
            alert("验证码错误");
            return;
        }else if($("#username").val() !== "" && $("#password").val() !== "" && $("#conpassword").val() == $("#password").val() && $("#name").val() !== "" && reg_phone.test($("#phone").val()) && reg_email.test($("#email").val()) && $("#department").val() !== "" && $("#check").val() == "uwv6"){
            $("#iform").submit();
        }
    })

    // $("#username").blur(function () {
    //     var check = $("#username").val();
    //     if(check == ""){
    //         $("#message_u").html("请输入用户名")
    //     }else if(check !== ""){
    //         $("#message_u").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }
    // })
    // $("#password").blur(function () {
    //     var check = $("#password").val();
    //     if(check == ""){
    //         $("#message_p").html("请输入密码")
    //     }else if(check !== ""){
    //         $("#message_p").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }
    // })
    // $("#conpassword").blur(function () {
    //     var check = $("#conpassword").val();
    //     var checkp = $("#password").val();
    //     if(check !== checkp){
    //         $("#message_conp").html("请和上一行密码保持一致")
    //     }else if(check == checkp){
    //         $("#message_conp").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }
    // })
    // $("#name").blur(function () {
    //     var check = $("#name").val();
    //     if(check == ""){
    //         $("#message_n").html("请输入姓名")
    //     }else if(check !== ""){
    //         $("#message_n").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }
    // })
    // $("#phone").blur(function () {
    //     var phone = $("#phone").val();
    //     var reg_phone = /^[1][3,4,5,7,8][0-9]{9}$/;
    //     var flag = reg_phone.test(phone);
    //     if(flag){
    //         $("#message_phone").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }else {
    //         $("#message_phone").html("手机号码格式不正确")
    //     }
    // })
    // $("#email").blur(function () {
    //     var email = $("#email").val();
    //     var reg_email = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    //     var flag = reg_email.test(email);
    //     if(flag){
    //         $("#message_e").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }else {
    //         $("#message_e").html("邮箱格式不正确")
    //     }
    // })
    // $("#department").blur(function () {
    //     var check = $("#department").val();
    //     if(check == ""){
    //         $("#message_d").html("请输入所在单位")
    //     }else if(check !== ""){
    //         $("#message_d").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }
    // })
    // $("#check").blur(function () {
    //     var checkk = $("#check").val();
    //     if(checkk == "uwv6"){
    //         $("#message_c").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }else if(checkk !== "uwv6"){
    //         $("#message_c").html("验证码输入错误")
    //     }
    // })

})

