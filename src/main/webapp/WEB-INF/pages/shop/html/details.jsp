<%--
  Created by IntelliJ IDEA.
  User: Cierlly
  Date: 7/13/2019
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="../res/layui/css/layui.css">
    <script type="text/javascript" src="../res/layui/layui.js"></script>
    <script type="text/javascript" src="../../../../js/jquery-1.4.4.min.js"></script>
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
                    <img src="../res/static/img/logo.png">
                </a>
                <div>欢迎您，用户：${userInfo}</div>
                <div>欢迎您，用户：${userInfo}</div>
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


<div class="content content-nav-base datails-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="/shopper/shop/commdity" class="active">所有商品</a>
                    <a href="buytoday.html">今日团购</a>
                    <a href="/shopper/shop/information">母婴资讯</a>
                    <a href="/shopper/shop/about">关于我们</a>
                    <a href="#">您好！用户：${session.userInfo}</a>
                </div>
            </div>
        </div>
    </div>
    <div class="data-cont-wrap w1200">
        <div class="crumb">
            <a href="javascript:;">首页</a>
            <span>></span>
            <a href="javascript:;">所有商品</a>
            <span>></span>
            <a href="javascript:;">产品详情</a>
        </div>
        <div class="product-intro layui-clear">
            <div class="preview-wrap">
                <a href="javascript:;"><img src="../res/static/img/details_img1.jpg"></a>
            </div>
            <div class="itemInfo-wrap">
                <div class="itemInfo">
                    <div class="title">
                        <h4>${onefruit.getName()} </h4>
                        <span><i class="layui-icon layui-icon-rate-solid"></i>收藏</span>
                    </div>
                    <div class="summary">
                        <p class="reference"><span>参考价</span> <del>￥280.00</del></p>
                        <p class="activity"><span>活动价</span><strong class="price"><i>￥</i>${onefruit.getPrice()}</strong></p>
                        <p class="address-box"><span>送&nbsp;&nbsp;&nbsp;&nbsp;至</span><strong class="address">江西&nbsp;&nbsp;南昌&nbsp;&nbsp;东湖区</strong></p>
                    </div>
                    <div class="choose-attrs">
                        <div class="color layui-clear"><span class="title">颜&nbsp;&nbsp;&nbsp;&nbsp;色</span> <div class="color-cont"><span class="btn">白色</span> <span class="btn active">粉丝</span></div></div>
                        <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont"><span class="cut btn">-</span><input id = "num"onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="" name="" value="1"><span class="add btn">+</span></div></div>
                    </div>
                    <div class="choose-btns">
                        <button class="layui-btn layui-btn-primary purchase-btn">立刻购买</button>
                        <button class="layui-btn  layui-btn-danger car-btn" onclick="addshoplist()"><i class="layui-icon layui-icon-cart-simple"></i>加入购物车</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-clear">
            <div class="aside">
                <h4>热销推荐</h4>
                <div class="item-list">
                    <div class="item">
                        <img src="../res/static/img/details_img2.jpg">
                        <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
                    </div>
                    <div class="item">
                        <img src="../res/static/img/details_img2.jpg">
                        <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
                    </div>
                    <div class="item">
                        <img src="../res/static/img/details_img2.jpg">
                        <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
                    </div>
                    <div class="item">
                        <img src="../res/static/img/details_img2.jpg">
                        <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
                    </div>
                    <div class="item">
                        <img src="../res/static/img/details_img2.jpg">
                        <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
                    </div>
                    <div class="item">
                        <img src="../res/static/img/details_img2.jpg">
                        <p><span>可爱宝宝粉色连体秋裤</span><span class="pric">￥99.00</span></p>
                    </div>
                </div>
            </div>
            <div class="detail">
                <h4>详情</h4>
                <div class="item">
                    <img src="../res/static/img/details_imgbig.jpg">
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    layui.config({
        base: '../res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','jquery'],function(){
        var mm = layui.mm,$ = layui.$;
        var cur = $('.number-cont input').val();
        $('.number-cont .btn').on('click',function(){
            if($(this).hasClass('add')){
                cur++;

            }else{
                if(cur > 1){
                    cur--;
                }
            }
            $('.number-cont input').val(cur)
        })

    });
</script>
<script type="text/javascript">
    function addshoplist() {

        var shopperid = "${sessionScope.shopper.id}" ;
        var fruitid = "${onefruit.getFruitId()}";
        var num = $("#num").val();
        $.post("${pageContext.request.contextPath }/shopper/addlist.action",
            {"shopperid":shopperid,"fruitid":fruitid,"num":num},function(data){
             alert("other"+data.message)
            },"json")
        alert("成功加入购物车");
    }

</script>

</body>

</html>
