<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的资料</title>

<script src="../resources/ue/js/myinfo.js"></script>
<script src="../resources/ue/js/myinfo_puretext.js"></script>
<script type="text/javascript" src="../resources/js/audio/myinfo_audio.js"></script>
</head>
<body onload="initmyinfo()">

	<!-- /.aside -->
	<section id="content"> <section class="vbox"> <section
		class="scrollable"> <section class="hbox stretch">
	<aside class="aside-lg bg-light lter b-r"> <section
		class="vbox"> <section class="scrollable">
	<div class="wrapper">
		<div class="text-center wrapper" id="div_user_myinfo_spinner">
			<i class="fa fa-spinner fa fa-spin fa fa-large"></i>
		</div>
		<div class="text-center m-b m-t">
			<a href="#" class="thumb-lg"> <img id="img_use_icon"
				src="../user/icon/a0.png" class="img-circle">
			</a>
			<div>
				<div class="h3 m-t-xs m-b-xs" id="div_user_name"
					contentEditable=false>八哥，神人也</div>
				<small class="text-muted" id="small_user_position"><i
					class="fa fa-map-marker"></i> 常州, 江苏</small> <small class="text-muted"
					id="small_user_positivecount"><i class="fa fa-map-marker"></i>200</small>
			</div>
		</div>
		<div class="panel wrapper">
			<div class="row text-center">
				<div class="col-xs-6">
					<a href="#"> <small class="text-muted">我的动态</small> <span
						id="span_use_events_num" class="m-b-xs h4 block">100</span>
					</a>
				</div>
				<div class="col-xs-6">
					<a href="#"> <small class="text-muted">累计评论</small><span
						class="m-b-xs h4 block" id="span_use_comments_num">50</span>
					</a>
				</div>
			</div>
		</div>
		<div class="btn-group btn-group-justified m-b">
			<a class="btn btn-success btn-rounded" data-toggle="button"
				id="a_user_edit" onclick="startedit()"> <span class="text">
					<i class="fa fa-eye"></i> 编辑
			</span> <span class="text-active"> <i class="fa fa-eye"> 取消</i>
			</span>
			</a> <a class="btn btn-dark btn-rounded" id="a_user_save"
				onclick="endedit()"> <i class="fa fa-comment-o"></i> 保存
			</a>
		</div>
		<div>
			<small class="text-uc text-xs text-muted">性别</small>
			<p style='text-indent: 2em;' id="p_user_sex" contentEditable=false>男</p>
			<small class="text-uc text-xs text-muted">生日</small>
			<p style='text-indent: 2em;' id="p_user_birthday"
				contentEditable=false>2016-03-25</p>
			<small class="text-uc text-xs text-muted">手机号</small>
			<p style='text-indent: 2em;' id="p_user_phone" contentEditable=false>1362810117</p>
			<small class="text-uc text-xs text-muted">邮箱</small>
			<p style='text-indent: 2em;' id="p_user_mail" contentEditable=false>123@qq.com</p>
			<small class="text-uc text-xs text-muted">个人简介</small>
			<p style='text-indent: 2em;' id="p_user_introduction"
				contentEditable=false>我是河海大学常州校区学生</p>
			<small class="text-uc text-xs text-muted">备注</small>
			<p style='text-indent: 2em;' id="p_user_remark" contentEditable=false>猿类，电脑爱好者，屌丝</p>
			<div class="line"></div>
			<small class="text-uc text-xs text-muted">我的收藏</small>
			<p class="m-t-sm" id="p_user_collection">
				<a href="#" class="btn btn-rounded btn-twitter btn-icon"><i
					class="fa fa-twitter"></i></a> <a href="#"
					class="btn btn-rounded btn-facebook btn-icon"><i
					class="fa fa-facebook"></i></a> <a href="#"
					class="btn btn-rounded btn-gplus btn-icon"><i
					class="fa fa-google-plus"></i></a>
			</p>
		</div>
	</div>
	</section> </section> </aside> <aside class="bg-white"> <section class="vbox"> <header
		class="header bg-light lt">
	<ul class="nav nav-tabs nav-white">
		<li class="active"><a href="#div_myinfo_pictures"
			data-toggle="tab" onclick="loadPictures()">我的图片</a></li>
		<li class=""><a href="#div_myinfo_audios" data-toggle="tab"
			onclick="loadAudios()">我的音频</a></li>
		<li class=""><a href="#div_myinfo_puretexts" data-toggle="tab"
			onclick="loadPuretexts()">我的文本</a></li>
	</ul>
	</header> <section class="scrollable">
	<div class="tab-content">
		<div class="tab-pane active" id="div_myinfo_pictures">
			<ul id="ul_myinfo_pictures"
				class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">
				<li class="list-group-item"><a href="#"
					class="thumb-sm pull-left m-r-sm"> <img
						src="../user/icon/a0.png" class="img-circle">
				</a> <a href="#" class="clear"> <small class="pull-right">3
							分钟之前</small> <strong class="block">八哥</strong> <small>我是河海大学常州校区学生我是河海大学常州校区学生我是河海大学常州校区学生</small>
				</a></li>

			</ul>
		</div>
		<div style="background:#3CC457" class="tab-pane" id="div_myinfo_audios">
			<div id="div_audio_spinner" class="text-center wrapper">
				<i class="fa fa-spinner fa fa-spin fa fa-large"></i>
			</div>
			<ul id="ul_myinfo_audios" style="bgcolor:black"
				class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border list-group list-group-lg no-radius no-border no-bg m-t-n-xxs m-b-none auto">
				<!-- 这里放audio信息 -->
				
			</ul>
			<ul class="pager">
				<li><a onclick="getAudios(4);" href="#">首页</a></li>
				<li><a onclick="getAudios(-1);" href="#">上一页</a></li>
				<li><a href="#"><span id="span_current_page">1</span> /<span
						id="span_count_page">1</span></a></li>
				<li><a onclick="getAudios(1)" href="#">下一页</a></li>
				<li><a onclick="getAudios(5)" href="#">末页</a></li>
			</ul>
		</div>
		<div class="tab-pane" id="div_myinfo_puretexts"
			id="div_puretext_spinner">
			<div class="text-center wrapper" id="div_myinfo_puretexts_spinner">
				<i class="fa fa-spinner fa fa-spin fa fa-large"></i>
			</div>
			<ul id="ul_myinfo_puretexts"
				class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border">
				<!-- 这里放文本信息 -->

			</ul>
			<ul class="pager">
				<li><a onclick="javascript:first();" href="#">首页</a></li>
				<li><a onclick="javascript:previous();" href="#">上一页</a></li>
				<li><a href="#"><span id="span_current_page">1</span> /<span
						id="span_count_page">1</span></a></li>
				<li><a onclick="javascript:next();" href="#">下一页</a></li>
				<li><a onclick="javascript:last();" href="#">最页</a></li>
			</ul>
		</div>
	</div>
	</section> </section> </aside> <aside class="col-lg-3 b-l"> <section class="vbox">
	<section class="scrollable padder-v">
	<div class="panel">
		<h4 class="font-thin padder">与我相关</h4>
		<ul class="list-group">
			<li class="list-group-item">
				<p>
					我觉得 <a href="#" class="text-info">八哥</a> 是一个屌丝
				</p> <small class="block text-muted"><i class="fa fa-clock-o"></i>
					2 分钟之前</small>
			</li>

		</ul>
	</div>
</body>
</html>