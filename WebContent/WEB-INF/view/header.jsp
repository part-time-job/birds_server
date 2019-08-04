<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ include file="/WEB-INF/view/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>头部分</title>


<script src="<c:url value="/resources/ue/js/header.js" />"></script>

</head>
<body>

	<header class="site-header">
	<div class="top-header">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-6">
					<div class="top-header-left">
						<a href="#" id="a_register_result"
							onclick="javascript:showRegisterModel();"> 注册</a><a
							onclick="javascript:showLoginModel();" id="a_login_result"
							href="#"> 登录 </a> <a id="a_user_myinfo" href="#"
							target="mainframe"> <img style="width: 30px; heigth: 30px"
							id="img_logined_icon"
							src="<c:url value="/resources/ue/images/user_default.png" />"
							class="img-circle"> <!-- <span id="span_user_notifications"
							class="badge badge-sm up bg-danger count hide">2</span> -->
						</a>
					</div>
					<!-- /.top-header-left -->
				</div>
				<!-- /.col-md-6 -->
				<div class="col-md-6 col-sm-6">
					<div class="social-icons">
						<ul>
							<li><a href="#" class="fa fa-facebook"></a></li>
							<li><a href="#" class="fa fa-dribbble"></a></li>
							<li><a href="#" class="fa fa-twitter"></a></li>
							<li><a href="#" class="fa fa-linkedin"></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<!-- /.social-icons -->
				</div>
				<!-- /.col-md-6 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.top-header -->
	<div class="text-center">
		<div class="text-center wrapper hide" id="div_header_spinner">
			<i class="fa fa-spinner fa fa-spin fa fa-large"></i>
		</div>
	</div>
	<div class="main-header">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-8">
					<div class="logo">
						<h1>
							<a href="#">鸟类监测互动平台</a>
						</h1>
					</div>
					<!-- /.logo -->
				</div>
				<!-- /.col-md-4 -->
				<div class="col-md-8 col-sm-6 col-xs-4">
					<div class="main-menu">
						<a href="#" class="toggle-menu"> <i class="fa fa-bars"
							style="margin: 15px auto"></i>
						</a>
						<ul class="menu">
							<li class="article"><a href="indexmap" target="mainframe">地图</a></li>
							<li class="article"><a href="myinfo" target="mainframe">我的资料</a></li>
							<li class="article"><a href="aboutme" target="mainframe">关于我们</a></li>
						</ul>
					</div>
					<!-- /.main-menu -->
				</div>
				<!-- /.col-md-8 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.main-header -->
	<div class="main-nav">
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-sm-6">
					<div class="list-menu">
						<ul>
							<li class="article"><a href="picture" target="mainframe">图片</a></li>
							<li class="article"><a href="audio" target="mainframe">音频</a></li>
							<li class="article"><a href="puretext" target="mainframe">纯文本</a></li>
							<li class="article"><a href="contact" target="mainframe">联系方式</a></li>
						</ul>
					</div>
					<!-- /.list-menu -->
				</div>
				<!-- /.col-md-6 -->
				<div class="col-md-2 col-sm-2">
					<div class="list-menu">
						<ul>
							<li class="article">
								<select class="form-control" style = "width:100%" id="data_type_select">
								  <option value="all">全部</option>
								  <option value="bird">鸟</option>
								  <option value="cicada">禅</option>
								</select>
							</li>
						</ul>
					</div>
				</div>
				<!-- /.col-md-6 -->
				<div class="col-md-4 col-sm-4">
					<div class="notification">
						<span>请爱护那些鸟类，就像爱护我们自己</span>
					</div>
				</div>
				<!-- /.col-md-6 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.main-nav --> </header>

	<!-- Modal -->
	<div id="login_Modal" class="modal fade" tabindex="-1" role="dialog"
		style="background: white; height: 70%; width: 35%; margin: auto auto;"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h4 id="myModalLabel">登录窗口</h4>
		</div>
		<div class="modal-body"
			style="background: url('../resources/ue/images/login_bg.jpg')">
			<section id="content" class="m-t-lg wrapper-md animated fadeInDown">
			<!-- <form id="loginform" role="form"> --><!-- data-toggle="validator" -->
			<div class="container aside-xl">

				<div class="form-group">
					<input placeholder="手机号" id="input_login_phone" value="13601509203"
						class="form-control rounded input-lg text-center no-border">
				</div>
				<div class="form-group">
					<input type="password" placeholder="密码" id="input_login_password"
						value="123456"
						class="form-control rounded input-lg text-center no-border">
				</div>
				<a onclick="javascript:login();"
					class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded">
					<i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">登录</span>
				</a>
			</div>
			</section>
			<!-- </form> -->
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" data-dismiss="modal"
				aria-hidden="true">关闭</button>
		</div>
	</div>
	<!-- Modal -->
	<div id="register_Modal" class="modal fade" tabindex="-1" role="dialog"
		style="background: white; height: 80%; width: 35%; margin: auto auto;"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h4 id="myModalLabel">注册窗口</h4>
		</div>
		<div class="modal-body"
			style="background: url('../resources/ue/images/login_bg.jpg')">
			<section id="content" class="m-t-lg wrapper-md animated fadeInDown">
			<!-- <form id="loginform" role="form"> --><!-- data-toggle="validator" -->
			<div class="container aside-xl">

				<div class="form-group">
					<input placeholder="手机号" id="input_register_phone"
						class="form-control rounded input-lg text-center no-border">
				</div>
				<div class="form-group">
					<input type="password" placeholder="密码"
						id="input_register_password"
						class="form-control rounded input-lg text-center no-border">
				</div>
				<div class="form-group">
					<input type="password" placeholder="确认密码"
						id="input_register_repassword"
						class="form-control rounded input-lg text-center no-border">
				</div>
				<div class="form-group">
					<span><input type="password" placeholder="验证码"
						style="margin-left: 3%; width: 32%" id="input_register_captcha"></span>
					<img src="../code/captcha-image" id="kaptchaImage"
						style="margin-top: -2px" /> <a href="#" onclick="changeCode()">看不清?换一张</a>
				</div>
				<a onclick="javascript:register();"
					class="btn btn-lg btn-warning lt b-white b-2x btn-block btn-rounded">
					<i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">注册</span>
				</a>
			</div>
			</section>
			<!-- </form> -->
		</div>
		<div class="modal-footer">
			<button class="btn btn-primary" data-dismiss="modal"
				aria-hidden="true">关闭</button>
		</div>
	</div>

</body>
</html>