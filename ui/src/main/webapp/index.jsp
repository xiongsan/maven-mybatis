<%@ page language="java" pageEncoding="utf-8" %>
<% response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "No-cache");
    response.setDateHeader("Expires", -1);
    response.setHeader("Cache-Control", "No-store"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="pragram" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache, must-revalidate">
    <meta http-equiv="expires" content="0">
    <title>登录</title>
    <link rel="stylesheet" href="/css/pages/kscc.css" type="text/css"/>
    <link rel="shortcut icon" type="image/x-icon" href="/img/storz.ico"/>
    <script src="/js/jquery.js"></script>
    <script type="application/javascript" src="/js/lib/enclosure.js"></script>
    <link rel="stylesheet" href="/css/lib/bootstrap-3.3.5/css/bootstrap.min.css"
          type="text/css"/>
    <link rel="stylesheet"
          href="/css/lib/bootstrap-3.3.5/css/bootstrap-responsive.css"
          type="text/css"/>
    <style>
        .Center-Container {
            height: 100%;
            width: 100%;
            position: relative;
            background: url('/img/loginBg.jpg');
            background-size: cover;
        }

        .Absolute-Center {
            width: 50%;
            height: 50%;
            overflow: auto;
            margin: auto;
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
        }

        .input {
            width: 280px;
            margin: 0 auto;
            border-radius: 15px;
            background: #7d91c2;
            color: #fff;
            padding-left: 50px;
        }

        input::-webkit-input-placeholder { /* WebKit browsers */
            color: #D5E7E4 !important;
        }

        input:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
            color: #D5E7E4 !important;
        }

        input::-moz-placeholder { /* Mozilla Firefox 19+ */
            color: #D5E7E4 !important;
        }

        input:-ms-input-placeholder { /* Internet Explorer 10+ */
            color: #D5E7E4 !important;
        }
    </style>
</head>
<body>
<input type="hidden" value="06a5bb21-b8f0-4dfd-8004-4b4e17d4f81c">
<div class="Center-Container">
    <div class="Absolute-Center">
        <form method="post" id="userInfo" style="width:97%;height:100%;text-align:center;">
            <div class="loginbox">
                <div class="clearfix">
                    <div style="text-align:center;margin-top:50px;">
                        <input class="form-control input" type="text" name="name" placeholder="登录账号" value=""
                               data-validate="required:请填写账号"
                               style="background:url('/img/username.png') 5% center no-repeat #7d91c2">
                    </div>
                    <div style="text-align:center;margin-top:15px;">
                        <input type="password" class="form-control input" name="password" placeholder="登录密码"
                               data-validate="required:请填写密码"
                               style="background:url('/img/password.png') 5% center no-repeat #7d91c2"/>
                    </div>
                    <div style="text-align:center;margin-top:15px;">
                        <input type="button" class="form-control input loginImgInput" name="login"
                               onclick="submitForm()" value="登   录"/>
                    </div>
                </div>
            </div>
        </form>
    </div>
    </form>
</div>
</div>

<script type="text/javascript">
    $(function () {
        $(document).keypress(function (e) {
            var e = event || window.event || arguments.callee.caller.arguments[0];
            if (e && e.keyCode === 13) {
                submitForm();
            }
        })
    })
    function submitForm() {
//       $.ajax({
//           url:"${pageContext.request.contextPath }/loginController/validateCode",
//           data:{"code":$('#code').val()},
//           dataType:"text",
//           success:function(message){
//               if(message!=='success'){
//                $("#codeMessage").text("验证码错误");
//                return
//                }
        $.ajax({
            url:'/toLogin?name=zhangsan&age=4*',
            type:"post",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"loginName":$("input[name='name']").val(), "password":$("input[name='password']").val()}),
            success:function(e){
                if(e.status==='1'){
                    $("form").attr({
                        "action": '/home',
                        "target": "_self"
                    });
                    $("form").submit();
                }
                else{
                    //非法请求e为空
                    if(e){
                        alert(e.tips)
                    }
                }
            },
            error:function(){

            },
            complete:function (xhr, textStatus) {
                if (xhr.getResponseHeader("xxsClean") === "1") {
                    alert('不安全的请求')
                }
                else if (xhr.getResponseHeader("sessionstatus") === "timeOut") {
                    if (xhr.getResponseHeader("loginPath")) {
                        console.log("会话过期，请重新登陆!");
                        window.top.location.replace(xhr.getResponseHeader("loginPath"));
                    }
                }
            }
        })
    }
</script>
</body>
</html>