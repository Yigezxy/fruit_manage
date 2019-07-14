<%--
  Created by IntelliJ IDEA.
  User: Cierlly
  Date: 7/13/2019
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${request.getContextPath()}/res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="${request.getContextPath()}/res/layui/css/layui.css">
    <script type="text/javascript" src="${request.getContextPath()}/res/layui/layui.js"></script>
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
                    <img src="${request.getContextPath()}/res/static/img/logo.png">
                </a>
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


<div class="content content-nav-base commodity-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="${request.getContextPath()}/shopper/shop/commdity" class="active">所有商品</a>
                    <a href="buytoday.html">今日团购</a>
                    <a href="/shopper/shop/information">水果资讯</a>
                    <a href="about">关于我们</a>
                </div>
            </div>
        </div>
    </div>
    <div class="commod-cont-wrap">
        <div class="commod-cont w1200 layui-clear">
            <div class="left-nav">
                <div class="title">所有分类</div>
                <div class="list-box">
                    <dl>
                        <dt>水果列表</dt>
                        <%--<dd><a href="javascript:;">进口奶粉</a></dd>--%>
                        <%--<dd><a href="javascript:;">宝宝辅食</a></dd>--%>
                        <%--<dd><a href="javascript:;">营养品</a></dd>--%>

                        <c:forEach items="${typeList}" var="java">
                            <%--&lt;%&ndash;<dd><a href="${pageContext.request.contextPath}/shopper/productFindByPid.action?pid=${pro.pid}">&ndash;%&gt;--%>
                            <dd><a href="${pageContext.request.contextPath}/shopper/productFindByPid.action?pid=${java}">
                                水果：${java}
                            </a></dd>
                        </c:forEach>
                        <%--<c:forEach items="${nlist}" var="nl">--%>
                            <%--${nl}--%>
                        <%--</c:forEach>--%>
                    </dl>
                    <%--<dl>--%>
                        <%--<dt>儿童用品</dt>--%>
                        <%--<dd><a href="javascript:;">纸尿裤</a></dd>--%>
                        <%--<dd><a href="javascript:;">婴儿湿巾</a></dd>--%>
                        <%--<dd><a href="javascript:;">婴儿车</a></dd>--%>
                        <%--<dd><a href="javascript:;">婴儿床</a></dd>--%>
                        <%--<dd><a href="javascript:;">儿童安全座椅</a></dd>--%>
                    <%--</dl>--%>
                    <%--<dl>--%>
                        <%--<dt>儿童早教</dt>--%>
                        <%--<dd><a href="javascript:;">儿童玩具</a></dd>--%>
                        <%--<dd><a href="javascript:;">早教书籍</a></dd>--%>
                        <%--<dd><a href="javascript:;">孕产育儿书</a></dd>--%>
                    <%--</dl>--%>
                    <%--<dl>--%>
                        <%--<dt>儿童服饰</dt>--%>
                        <%--<dd><a href="javascript:;">童装</a></dd>--%>
                        <%--<dd><a href="javascript:;">童鞋</a></dd>--%>
                        <%--<dd><a href="javascript:;">宝宝配饰</a></dd>--%>
                    <%--</dl>--%>
                    <%--<dl>--%>
                        <%--<dt>孕妈专区</dt>--%>
                        <%--<dd><a href="javascript:;">孕妇装</a></dd>--%>
                        <%--<dd><a href="javascript:;">孕妇护肤</a></dd>--%>
                        <%--<dd><a href="javascript:;">孕妇用品</a></dd>--%>
                    <%--</dl>--%>
                </div>
            </div>
            <div class="right-cont-wrap">
                <div class="right-cont">
                    <div class="sort layui-clear">
                        <a class="active" href="javascript:;" event = 'volume'>销量</a>
                        <a href="javascript:;" event = 'price'>价格</a>
                        <a href="javascript:;" event = 'newprod'>新品</a>
                        <a href="javascript:;" event = 'collection'>收藏</a>
                    </div>
                    <div class="prod-number">
                        <span>200个</span>
                    </div>
                    .
                    <div class="cont-list layui-clear" id="list-cont">

                        <c:forEach items="${fruitlist}" var="fruit">
                            <%--&lt;%&ndash;<dd><a href="${pageContext.request.contextPath}/shopper/productFindByPid.action?pid=${pro.pid}">&ndash;%&gt;--%>
                            <%--<dd><a href="${pageContext.request.contextPath}/shopper/productFindByPid.action?pid=${java}">--%>
                                <%--水果：${java}--%>
                            <%--</a></dd>--%>
                            <div class="item">
                                <div class="img">
                                    <a href="${request.getContextPath()}/shopper/details?fruitid=${fruit.getFruitId()}"><img src="${request.getContextPath()}/res/static/img/paging_img1.jpg"></a>
                                </div>
                                <div class="text">
                                    <p class="title">${fruit.getName()}</p>
                                    <p class="price">
                                        <span class="pri">￥${fruit.getPrice()} per 500g</span>
                                        <span class="nub">地址:${fruit.getLocality()}</span>
                                    </p>
                                </div>
                            </div>
                        </c:forEach>


                        <%--<div class="item">--%>
                            <%--<div class="img">--%>
                                <%--<a href="javascript:;"><img src="${request.getContextPath()}/res/static/img/paging_img2.jpg"></a>--%>
                            <%--</div>--%>
                            <%--<div class="text">--%>
                                <%--<p class="title">森系小清新四件套</p>--%>
                                <%--<p class="price">--%>
                                    <%--<span class="pri">￥200</span>--%>
                                    <%--<span class="nub">1266付款</span>--%>
                                <%--</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <!-- 模版引擎导入 -->
                    <!-- <script type="text/html" id="demo">
                      {{# layui.each(d.menu.milk.content,function(index,item){}}
                        <div class="item">
                          <div class="img">
                            <a href="javascript:;"><img src="{{item.img}}"></a>
                          </div>
                          <div class="text">
                            <p class="title"></p>
                            <p class="price">
                              <span class="pri">{{item.pri}}</span>
                              <span class="nub">{{item.nub}}</span>
                            </p>
                          </div>
                        </div>
                      {{# }); }}
                    </script> -->
                    <div id="demo0" style="text-align: center;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>

    layui.config({
        base: '${request.getContextPath()}/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','laypage','jquery'],function(){
        var laypage = layui.laypage,$ = layui.$,
            mm = layui.mm;
        laypage.render({
            elem: 'demo0'
            ,count: 100 //数据总数
        });


        // 模版引擎导入
        //  var html = demo.innerHTML;
        //  var listCont = document.getElementById('list-cont');
        //  // console.log(layui.router("#/about.html"))
        // mm.request({
        //     url: '../json/commodity.json',
        //     success : function(res){
        //       console.log(res)
        //       listCont.innerHTML = mm.renderHtml(html,res)
        //     },
        //     error: function(res){
        //       console.log(res);
        //     }
        //   })

        $('.sort a').on('click',function(){
            $(this).addClass('active').siblings().removeClass('active');
        })
        $('.list-box dt').on('click',function(){
            if($(this).attr('off')){
                $(this).removeClass('active').siblings('dd').show()
                $(this).attr('off','')
            }else{
                $(this).addClass('active').siblings('dd').hide()
                $(this).attr('off',true)
            }
        })

    });
</script>


</body>
</html>
