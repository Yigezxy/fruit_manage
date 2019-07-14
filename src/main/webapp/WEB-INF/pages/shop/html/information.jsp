<%--
  Created by IntelliJ IDEA.
  User: Cierlly
  Date: 7/13/2019
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="../../../../res/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="../../../../res/layui/css/layui.css">
    <script type="text/javascript" src="../../../../res/layui/layui.js"></script>
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
            <div class="login"><a href="login.html">登录</a></div>
            <div class="sp-cart"><a href="shopcart.html">购物车</a><span>2</span></div>
        </div>
    </div>
</div>



<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="#" title="水果商城">
                    <img src="../../../../res/static/img/logo.png">
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


<div class="content content-nav-base information-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="/shopper/shop/commdity" >所有商品</a>
                    <a href="buytoday.html">今日团购</a>
                    <a href="/shopper/shop/information" class="active">母婴资讯</a>
                    <a href="/shopper/shop/about">关于我们</a>
                </div>
            </div>
        </div>
    </div>
    <div class="info-list-box">
        <div class="info-list w1200">
            <div class="item-box layui-clear" id="list-cont">
                <div class="item">
                    <div class="img">
                        <img src="../../../../res/static/img/new1.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>周岁内的宝宝感冒时应该吃什么水果?</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">雪梨可以在宝宝感冒咳嗽时或喉咙比较上火时熬成水给宝宝喝，这样能帮助宝宝下火，同时还能止咳化痰，缓解宝宝的咳嗽症状。草莓富含比较丰富的维生素物质，妈妈们可以把草莓炸成汁给宝宝喝，这样其中的营养成分会被宝宝完全吸收。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../../../res/static/img/yingtao.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>烟台大樱桃新鲜上市！</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">大樱桃以其色泽鲜艳、晶莹剔透、香甜可口、营养丰富，被誉为“果中珍品”，具有极高的营养价值和商业价值。“北方春果第一枝”就是烟台大樱桃的代名词。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../../../res/static/img/mihoutao.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>“水果之王”猕猴桃欲购从速</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">猕猴桃的果肉中含有大量的维生素C和维生素E，其中每100g鲜果中含维生素C100—420mg，是苹果的80倍。这两种维生素均具有很强的抗氧化作用，因而使得猕猴桃不仅能够预防动脉硬化、糖尿病、肝功能障碍等疾病</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../../../res/static/img/lizhi.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>广州荔枝“三杰”，满额包邮，顺丰隔日达，给您最鲜的美味</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">广州荔枝有“三杰”：笔村糯米糍、罗岗桂味、增城挂绿，是最为独特美味的品种。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../../../res/static/img/xiangjiao.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>变黑的香蕉还能不能食用?</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">香蕉皮变黑其实是香蕉炭疽病的表现这种菌并不会对人体产生任何作用。这种症状只有在香蕉成熟时才会表现出来，表皮出现黑点说明香蕉已完全成熟，此时口感和风味最好。，</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../../../res/static/img/sheguo.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>英国进口蛇果限时供应</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">英国北威尔斯巴德西岛在近年发现得到新品种，比普通的果树更健康，除了虫害以外，并不会患病，被媒体称为世界上最罕有的苹果</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/fengli.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>台湾凤梨，甜美来袭</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">凤梨味甘、微酸，性微寒，有清热解暑、生津止渴、利小便的功效，可用于伤暑、身热烦渴、腹中痞闷、消化不良、小便不利、头昏眼花等症。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/qingmang.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>大青芒，吃更爽！</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">青芒果含有营养素及维生素C、矿物质等，除了具有防癌的功效外，同时也具有防止动脉硬化及高血压的食疗作用。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/putao.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>葡萄皮为啥是宝呢？</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">葡萄皮中的白藜芦醇能够帮助人体降低血脂，增强免疫力。鞣酸能够抗过敏、延缓衰老，还具有增强免疫和预防心脑血管疾病的功效。花青素能强抗氧化性、抗突变、保护心血管等等。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/new1.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>周岁内的宝宝感冒时应该吃什么水果?</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">雪梨可以在宝宝感冒咳嗽时或喉咙比较上火时熬成水给宝宝喝，这样能帮助宝宝下火，同时还能止咳化痰，缓解宝宝的咳嗽症状。草莓富含比较丰富的维生素物质，妈妈们可以把草莓炸成汁给宝宝喝，这样其中的营养成分会被宝宝完全吸收。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/yingtao.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>烟台大樱桃新鲜上市！</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">大樱桃以其色泽鲜艳、晶莹剔透、香甜可口、营养丰富，被誉为“果中珍品”，具有极高的营养价值和商业价值。“北方春果第一枝”就是烟台大樱桃的代名词。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/mihoutao.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>“水果之王”猕猴桃欲购从速</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">猕猴桃的果肉中含有大量的维生素C和维生素E，其中每100g鲜果中含维生素C100—420mg，是苹果的80倍。这两种维生素均具有很强的抗氧化作用，因而使得猕猴桃不仅能够预防动脉硬化、糖尿病、肝功能障碍等疾病</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/sheguo.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>英国进口蛇果限时供应</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">英国北威尔斯巴德西岛在近年发现得到新品种，比普通的果树更健康，除了虫害以外，并不会患病，被媒体称为世界上最罕有的苹果</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/fengli.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>台湾凤梨，甜美来袭</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">凤梨味甘、微酸，性微寒，有清热解暑、生津止渴、利小便的功效，可用于伤暑、身热烦渴、腹中痞闷、消化不良、小便不利、头昏眼花等症。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/qingmang.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>大青芒，吃更爽！</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">青芒果含有营养素及维生素C、矿物质等，除了具有防癌的功效外，同时也具有防止动脉硬化及高血压的食疗作用。</p>
                    </div>
                </div>
                <div class="item">
                    <div class="img">
                        <img src="../../res/static/img/putao.jpg" alt="">
                    </div>
                    <div class="text">
                        <h4>葡萄皮为啥是宝呢？</h4>
                        <p class="data">2019-7-13 16:33:26</p>
                        <p class="info-cont">葡萄皮中的白藜芦醇能够帮助人体降低血脂，增强免疫力。鞣酸能够抗过敏、延缓衰老，还具有增强免疫和预防心脑血管疾病的功效。花青素能强抗氧化性、抗突变、保护心血管等等。</p>
                    </div>
                </div>
            </div>
            <div id="demo0" style="text-align: center;"></div>
        </div>
    </div>
</div>
<!-- 模版引擎导入 -->
<!-- <script type="text/html" id="demo">
  {{# layui.each(d.listCont,function(index,item){}}
  <div class="item">
    <div class="img">
      <img src="../../res/img/new1.jpg" alt="">
    </div>
    <div class="text">
      <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
      <p class="data">2016-12-24 16:33:26</p>
      <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
    </div>
  </div>
  {{# })}}
</script> -->
<script>
    layui.config({
        base: '../../res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm','laypage'],function(){
        var
            mm = layui.mm,laypage = layui.laypage;
        laypage.render({
            elem: 'demo0'
            ,count: 100 //数据总数
        });
        // 模版引擎导入
        // var html = demo.innerHTML;
        // var listCont = document.getElementById('list-cont');
        //  mm.request({
        //    url: '../../json/information.json',
        //    success : function(res){
        //      console.log(res)
        //      listCont.innerHTML = mm.renderHtml(html,res)
        //    },
        //    error: function(res){
        //      console.log(res);
        //    }
        //  })
    });

</script>


</body>
</html>
