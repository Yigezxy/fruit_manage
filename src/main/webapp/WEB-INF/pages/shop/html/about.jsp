<%--
  Created by IntelliJ IDEA.
  User: Cierlly
  Date: 7/13/2019
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../../res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="../../res/layui/css/layui.css">
    <script type="text/javascript" src="../../res/layui/layui.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="#">首页</a>
        </p>
        <div class="sn-quick-menu">
            <div class="login"><a href="${request.getContextPath()}/shopper/login">登录</a></div>
            <div class="login"><a href="${request.getContextPath()}/register/html/register">注册</a></div>
            <div class="sp-cart"><a  href="${request.getContextPath()}/shopper/shopcar">购物车</a><span>2</span></div>
        </div>
    </div>
</div>

<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="#" title="母婴商城">
                    <img src="../../res/static/img/logo.png">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="" class="layui-form" novalidate>
                    <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>


<div class="content content-nav-base about-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="commdity">所有商品</a>
                    <a href="buytoday.html">今日团购</a>
                    <a href="/shopper/shop/information">母婴资讯</a>
                    <a href="about"  class="active">关于我们</a>
                </div>
            </div>
        </div>
    </div>
    <div class="banner-box">
        <div class="banner"></div>
    </div>
    <div class="brief-content layui-clear w1200">
        <div class="img-box">
            <img src="../../res/static/img/us_img1.jpg">
            <img class="top" src="../../res/static/img/us_img2.jpg">
        </div>
        <div class="text">
            <p>我们的水果产业是全世界最大的水果销售产业，以向DD出售桃子起家，后来勇敢的开展“程序员买水果价格翻倍计划”，广受程序员的欢迎，在2015年创建了自己的独立的品牌。公司临近山东科技大学，2年的品牌沉淀和运营经验让我们在行业中获得良好的口碑和市场份额。2019年市值到达1万亿美金，并决定在不远的将来将前往百万亿市场</p>
        </div>
    </div>
    <div class="banner-text">
        <div class="w1200">
            <p>将水果与二次元联系起来！我们朝着正确的方向前进！发展粉丝经济，聘用蔡徐坤做形象大使。开启水果娘计划，通过直播宣传自己的产品。坚持做绿色生态水果，所有水果农药残留都正好达到国家最低标准。采用非常成功的粉丝经济+宣传绿色生态的方式，让成功更加容易！让企业发展更加迅速。</p>
        </div>
    </div>
    <div class="after-sale w1200">
        <h4>配送售后</h4>
        <div class="item-box">
            <div class="item item1">
                <div class="img-box">
                    <img src="../../res/static/img/us_icon1.png">
                </div>
                <p>坚决不能退换货</p>
            </div>
            <div class="item item2">
                <div class="img-box">
                    <img src="../../res/static/img/us_icon2.png">
                </div>
                <p>全场满9999元顺丰包邮</p>
            </div>
            <div class="item item3">
                <div class="img-box">
                    <img src="../../res/static/img/us_icon3.png">
                </div>
                <p>没有客服服务</p>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    layui.config({
        base: '../../res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm'],function(){
        var
            mm = layui.mm;



    });
</script>
</body>
</html>
