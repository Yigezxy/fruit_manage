<%--
  Created by IntelliJ IDEA.
  User: Cierlly
  Date: 7/13/2019
  Time: 8:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="" />
    <link href="${request.getContextPath()}/user/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
    <link href="${request.getContextPath()}/user/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900" rel="stylesheet">
</head>
<body>
<div class="signupform">
    <h1>Welcome To Our Fruit Shop <a href="${request.getContextPath()}/shopper/login">登录</a></h1>

    <div class="container">

        <div class="agile_info">
            <div class="w3l_form">
                <div class="left_grid_info">
                    <h3>Welcome !</h3>
                    <h4>Here is our fruit store, wholesalers from all over the country are welcome to buy our products!</h4>
                    <p>This is a very beautiful online mall. If you are a wholesaler, please register to buy our products. Our business philosophy is green, safe and healthy, so that everyone can eat the cleanest fruit.</p>
                    <ul class="social_section_1info">
                        <li><a href="#" class="w3_facebook"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#" class="w3_twitter"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#" class="w3_instagram"><i class="fa fa-instagram"></i></a></li>
                        <li><a href="#" class="w3_google"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#" class="w3_pinterest"><i class="fa fa-pinterest"></i></a></li>
                        <li><a href="#" class="w3_vimeo"><i class="fa fa-vimeo"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="w3_info">
                <h2>Create An Account</h2>
                <p>Welcome to buy, you will get a lot of money.This is our way of doing business.</p>
                <!--/html/register-->
                <form id="registerform" action="../html/register"   method="post" onsubmit="submit()">
                    <div class="input-group">
                        <span><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input type="text" name="username" placeholder="Username" required="">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-user" aria-hidden="true"></i></span>
                        <input type="text" name="phonenumber" placeholder="Phonenumber" required="">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-envelope" aria-hidden="true"></i></span>
                        <input id ="eml" type="email" name="email" placeholder="Email" required="">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                        <input id="pwd1" type="Password" name="password" placeholder="Password" required="">
                    </div>
                    <div class="input-group">
                        <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                        <input id="pwd2"  type="Password" name="repassword" placeholder="Confirm Password" onkeyup="validate()" required=""><span id="hint"></span>
                    </div>
                    <input type="checkbox" value="remember-me" /> <h4>Send me latest updates </h4>
                    <button id="submit" class="btn btn-danger btn-block" type="submit">Create Account</button >
                </form>
                <div>${registerInfo}</div>
            </div>
            <div class="clear"></div>
        </div>

    </div>
    <div class="footer">

        <p>Copyright &copy; 2019.山东科技大学 <a href="#" title="水果商城">水果商城</a> - Collect from <a href="#" title="注册" target="_blank">注册</a></p>
    </div>
</div>
<script>
    function validate() {
        var pwd1 = document.getElementById("pwd1").value;
        var pwd2 = document.getElementById("pwd2").value;
        <!-- 对比两次输入的密码 -->
        if (pwd1 == pwd2) {
            document.getElementById("hint").innerHTML = "<font color='green'>两次密码相同</font>";
            document.getElementById("submit").disabled = false;
        }
        else {
            document.getElementById("hint").innerHTML = "<font color='red'>两次密码不相同</font>";
            document.getElementById("submit").disabled = true;
        }
    }
    function submit() {
        var repassword = document.getElementById("hint").value;
        var ems = document.getElementById("eml").value;
        alert("进入函数")
        if(repassword =="两次密码相同" && ems.length!=0)
        {
            //alert("去注册");
            $.ajax({
                type:"post",
                url:"/html/register",
                data:$("#registerform").serialize(),
                dataType:"json",
                success:function(){
                    alert("成功提交")
                }
            })
        }
        else
        {
            alert("输入信息有误！")
        }
    }
</script>
</body>
</html>
