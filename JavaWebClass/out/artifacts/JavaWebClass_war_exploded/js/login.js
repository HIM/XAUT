window.onload = function(){
    document.getElementById("form").onsubmit = function(){
        // return checkUsername() && checkPassword() && checkWord();
        return checkWord();
    }
    // document.getElementById("username").onblur = checkUsername;
    // document.getElementById("password").onblur = checkPassword;
    document.getElementById("check").onblur = checkWord;
}
//校验用户名
// function checkUsername(){
//     //获取用户名的值
//     var username = document.getElementById("username").value;
//     var flag = username == "lgm";
//     if(flag){
//         //提示绿色对勾
//         message_u.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
//     }else{
//         //提示红色用户名有误
//         message_u.innerHTML = "用户名格式有误";
//     }
//     return flag;
// }
//校验密码
// function checkPassword(){
//     var password = document.getElementById("password").value;
//     // var flag = password == "666666";
//     var flag = password.length == 6;
//     if(flag){
//         //提示绿色对勾
//         message_p.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
//     }else{
//         //提示红色有误
//         message_p.innerHTML = "密码有误";
//     }
//     return flag;
// }
//校验验证码
function checkWord(){
    var check = document.getElementById("check").value;
    var flag = check == "uwv6";
    if(flag){
        //提示绿色对勾
        message_c.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色有误
        message_c.innerHTML = "验证码输入错误";
    }
    return flag;
}