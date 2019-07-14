<%--
  Created by IntelliJ IDEA.
  User: Cierlly
  Date: 7/12/2019
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Live2D SampleApp1</title>
    </meta>

    <meta name="viewport" content="width=device-width, initial-scale=0.5, minimum-scale=1.0, maximum-scale=4.0">
    </meta>

    <style>
        html, body {
            oveflow: hidden;
            height: 100%;
        }

        body {
            margin: 0px;
            padding: 0px;
        }

        /*#glcanvas {*/
            /*!**/
            /*position: absolute;*/
            /*top: 50%;*/
            /*left: 50%;*/
            /*transform: translate(-50%, -50%);*/
            /**!*/
            /*background-size: 150%;*/
            /*background-position: 50% 50%;*/
            /*background-image: url(asserts/image/back_class_normal.png);*/
        /*}*/

        button {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 14px;
            color: #ffffff;
            padding: 10px 20px;
            -moz-border-radius: 30px;
            -webkit-border-radius: 30px;
            border-radius: 30px;
            -moz-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5),
            inset 0px 0px 1px rgba(255, 255, 255, 0.7);
            -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5),
            inset 0px 0px 1px rgba(255, 255, 255, 0.7);
            box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5),
            inset 0px 0px 1px rgba(255, 255, 255, 0.7);
            text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.4),
            0px 1px 0px rgba(255, 255, 255, 0.3);
        }

        button.active {
            background: linear-gradient(
                    to bottom,
                    #3498db,
                    #2980b9);
            background: -moz-linear-gradient(
                    top,
                    #3498db 0%,
                    #2980b9);
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#3498db),
                    to(#2980b9));
            border: 1px solid #2980b9;
        }

        button.inactive {
            background: linear-gradient(
                    to bottom,
                    #e74c3c,
                    #c0392b);
            background: -moz-linear-gradient(
                    top,
                    #e74c3c 0%,
                    #c0392b);
            background: -webkit-gradient(
                    linear, left top, left bottom,
                    from(#e74c3c),
                    to(#c0392b));
            border: 1px solid #c0392b;
        }
    </style>

</head>
    <body onload="sampleApp1()">

    <p>
        <button id="btnChange" class="active">Change Model</button>
    </p>

    <div>
        <canvas id="glcanvas" width="680" height="940">
        </canvas>
    </div>



        <!-- Live2D Library -->
        <script src="lib/live2d.min.js"></script>

        <!-- Live2D Framework -->
        <script src="asserts/framework/Live2DFramework.js"></script>

        <!-- User's Script -->
        <script src="src/utils/MatrixStack.js"></script>
        <script src="src/utils/ModelSettingJson.js"></script>
        <script src="src/PlatformManager.js"></script>
        <script src="src/LAppDefine.js"></script>
        <script src="src/LAppModel.js"></script>
        <script src="src/LAppLive2DManager.js"></script>
        <script src="src/SampleApp1.js"></script>

    </body>
</html>
