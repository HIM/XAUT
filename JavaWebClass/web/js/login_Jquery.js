$(function () {

    // $("#iform").submit(function () {
    //     return checkUsername()&&checkPassword()&&checkWord();
    // })

    $("#isubmit").click(function () {
        if ($("#username").val() == ""){
            return;
        }else if($("#password").val() == ""){
            return;
        }else if($("#check").val() == ""){
            return;
        }else if($("#username").val() !== "" && $("#password").val() !== "" && $("#check").val() == "uwv6"){
            $.ajax({
                url: "loginServlet",// 请求路径
                async: false,
                type: "POST",//请求方式
                data:{
                    username: $("#username").val(),
                    password: $("#password").val()
                },//请求参数
                dataType: "text",       //指定后台返回类型格式
                success: function (data) {
                    // window.location.href = "/loginServlet";
                    // if(data !== "")
                    //     alert("登录成功！");
                    // if(data>0)
                    //     alert("success");
                    // else
                    //     alert("fail");
                },//响应成功后的回调函数
                error:function () {
                    alert("出错了。。。")
                }//表示如果请求响应出现错误，会执行的回调函数
            });


            $("#iform").submit();
        }
    })

    //
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
    // $("#check").blur(function () {
    //     var check = $("#check").val();
    //     if(check !== "uwv6"){
    //         $("#message_c").html("验证码输入错误")
    //     }else if(check == "uwv6"){
    //         $("#message_c").html("<img width='35' height='25' src='img/gou.png'/>");
    //     }
    // })
})
// function checkUsername() {
//     var check = $("#username").val();
//     var flag = check == "";
//     return flag;
// }
// function checkPassword() {
//     var check = $("#password").val();
//     var flag = check == "";
//     return flag;
// }
// function checkWord() {
//     var check = $("#check").val();
//     var flag = check == "uwv6";
//     return flag;
// }