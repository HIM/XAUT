window.onload = function(){
    document.getElementById("form").onsubmit = function(){
        return checkUsername() && checkPassword() && checkConpassword() && checkName() && checkPhone() && checkEmail() && checkDepartment() && checkWord();
    }
    document.getElementById("username").onblur = checkUsername;
    document.getElementById("password").onblur = checkPassword;
    document.getElementById("conpassword").onblur = checkConpassword;
    document.getElementById("name").onblur = checkName;
    document.getElementById("phone").onblur = checkPhone;
    document.getElementById("email").onblur = checkEmail;
    document.getElementById("department").onblur = checkDepartment;
    document.getElementById("check").onblur = checkWord;
}
//校验用户名
function checkUsername(){
    //获取用户名的值
    var username = document.getElementById("username").value;
    var flag = username != "";
    if(flag){
        //提示绿色对勾
        message_u.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色用户名有误
        message_u.innerHTML = "请输入用户名";
    }
    return flag;
}
//校验密码
function checkPassword(){
    var password = document.getElementById("password").value;
    var flag = password != "";
    if(flag){
        //提示绿色对勾
        message_p.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色有误
        message_p.innerHTML = "请输入密码";
    }
    return flag;
}
//确认密码
function checkConpassword(){
    var conpassword = document.getElementById("conpassword").value;
    var password = document.getElementById("password").value;
    var flag = conpassword == password;
    if(flag){
        //提示绿色对勾
        message_conp.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色有误
        message_conp.innerHTML = "请和上一行密码保持一致";
    }
    return flag;
}
//姓名
function checkName(){
    var name = document.getElementById("name").value;
    var flag = name != "";
    if(flag){
        //提示绿色对勾
        message_n.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色有误
        message_n.innerHTML = "请输入姓名";
    }
    return flag;
}
//手机号码
function checkPhone(){
    var phone = document.getElementById("phone").value;
    var reg_phone = /^[1][3,4,5,7,8][0-9]{9}$/;
    var flag = reg_phone.test(phone);
    var message_phone = document.getElementById("message_phone");
    if(flag){
        //提示绿色对勾
        message_phone.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色有误
        message_phone.innerHTML = "手机号码格式不正确";
    }
    return flag;
}
//邮箱
function checkEmail(){
    var email = document.getElementById("email").value;
    var reg_email = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    var flag = reg_email.test(email);
    var message_e = document.getElementById("message_e");
    if(flag){
        //提示绿色对勾
        message_e.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色有误
        message_e.innerHTML = "邮箱格式不正确";
    }
    return flag;
}
//所在单位
function checkDepartment(){
    var department = document.getElementById("department").value;
    var flag = department != "";
    if(flag){
        //提示绿色对勾
        message_d.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
    }else{
        //提示红色有误
        message_d.innerHTML = "请输入所在单位";
    }
    return flag;
}
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