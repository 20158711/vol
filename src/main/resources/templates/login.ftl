﻿<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">


	<title>登录页</title>

	<link href="${request.contextPath}/static/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/plugins/material-design-iconic-font-2.2.0/css/material-design-iconic-font.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/plugins/checkbix/css/checkbix.min.css" rel="stylesheet"/>
	<link href="${request.contextPath}/static/css/login.css" rel="stylesheet"/>
	<style>
        .fg-line button{
			padding:0;
			width:100%;
			text-align: center;
			color:#fff;
			border:none;
			height:30px;
			line-height:30px;
			display:block;
            background: #29a176;
            background:
                    linear-gradient(-135deg, transparent 15px, #29a176 0)
                    top right,
                    linear-gradient(-45deg, transparent 15px, #29a176 0)
                    bottom right;
            background-size: 100% 50%;
            background-repeat: no-repeat;
		}	</style>
	<script>
		function sub() {
            var loginName = $("#loginName").val();
            var password = $("#password").val();
            if (loginName == null || loginName == "") {
                alert("请输入登录账户")
            } else if (password == null || password == "") {
                alert("请输入登录密码")
            } else {
                $.ajax({
					url:"${request.contextPath}/userLogin",
					type:"post",
					dataType:"json",
					data:{loginName:loginName,password:password},
					success:function (result) {
					   if(result.status!=200){
                           alert(result.message)
					   }else {
					       alert(result.message)
                           location.href ="${request.contextPath}/index";
					   }
                    }
				})

            }
        }

	</script>
	<script>
		function teamLogin() {
			var loginName=$("#loginName").val();
			var password=$("#password").val();
            if (loginName == null || loginName == "") {
                alert("请输入登录账户")
            } else if (password == null || password == "") {
                alert("请输入登录密码")
            } else {
                $.ajax({
                    url:"${request.contextPath}/teamLogin",
                    type:"post",
                    dataType:"json",
                    data:{loginName:loginName,password:password},
                    success:function (result) {
                        if(result.status!=200){
                            alert(result.message)
                        }else {
                            alert(result.message)
                            location.href ="${request.contextPath}/teamIndex";
                        }
                    }
                })

            }
			
        }
	</script>
</head>
<body>
<div id="login-window">
	<div class="input-group m-b-20">
		<span class="input-group-addon"><#--<i class="zmdi zmdi-account"></i>--></span>
		<div class="fg-line" style="align-content: center">
			<center>志愿服务平台</center>
		</div>
	</div>
	<div class="input-group m-b-20">
		<span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
		<div class="fg-line">
			<input id="loginName" type="text" class="form-control" name="loginName" placeholder="帐号" required autofocus >
		</div>
	</div>
	<div class="input-group m-b-20">
		<span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
		<div class="fg-line">
			<input id="password" type="password" class="form-control" name="password" placeholder="密码" required >
		</div>
	</div>
	<div class="clearfix">
	</div>
	<#--<center><button onclick="sub()">login</button></center>-->
<#--    <a  id="login-bt" onclick="sub()" &lt;#&ndash;href="javascript:;" &ndash;&gt;class="waves-effect waves-button waves-float"><i  class="zmdi zmdi-arrow-forward"></i></a>-->
    <div class="input-group m-b-20">
        <span class="input-group-addon"><#--<i class="zmdi zmdi-account"></i>--></span>
        <div style="align-content: center">
            <center><button onclick="sub()">个人</button>&nbsp;&nbsp;
				<button onclick="teamLogin()">团队</button>&nbsp;&nbsp;
				<a href="${request.contextPath}/toRegister"><button>注册</button></a></center>
		</div>
	</div>
    <script src="${request.contextPath}/static/plugins/jquery.1.12.4.min.js"></script>
    <script src="${request.contextPath}/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
    <script src="${request.contextPath}/static/plugins/waves-0.7.5/waves.min.js"></script>
    <script src="${request.contextPath}/static/plugins/checkbix/js/checkbix.min.js"></script>
	<script src="${request.contextPath}/static/js/login.js"></script>

</body>
</html>