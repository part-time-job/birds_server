<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ include file="/WEB-INF/view/include.jsp"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<title>这是音频</title>
<script type="text/javascript" src="../resources/js/audio/audio.js"></script>

<style>
.previous {
	background: blue
}

.hidden {
	display: none;
}
</style>

</head>
<body onload="getAudios(1);">
	<div class="hidden" id="palyer">
		<audio src="../resources/1.mp3" id="ap" controls="controls">
		Your browser does not support the audio element. </audio>
		<!-- <embed height="11" width="11" autostart=true src="../resources/1.mp3" /> -->
	</div>
	<div class="content-section">
		<div class="container">
			<div class="row">
				<section id="content"> <section class="vbox"> <section
					class="w-f-md"> <section
					class="hbox stretch bg-black dker"> <!-- side content -->
					<aside class="col-sm-7 no-padder" id="sidebar"> <section
						class="vbox animated fadeInUp"> <section
						class="scrollable">
					<div  class="m-t-n-xxs item pos-rlt">
						<img style="width: 100%" src="../resources/images/m43.jpg" />
					</div>
					<ul style="width: 100%" id="ul_audio"
						class=" list-group list-group-lg no-radius no-border no-bg m-t-n-xxs m-b-none auto">
					</ul>
					</section> </section> </aside>
					<!-- / side content -->
					
				<section class="col-sm-5 no-padder bg"> <section
					class="vbox"> <section class="scrollable hover">
				<ul id="topList" style="width: 100%"
					class="list-group list-group-lg no-bg auto m-b-none m-t-n-xxs">

				</ul>
				</section> </section> </section> </section> </section> </section> </section>
			</div>
			<div class="row">
				<ul class="pager">
					<li><a onclick="getAudios(4);" href="#">首页</a></li>
					<li><a onclick="getAudios(-1);" href="#">上一页</a></li>
					<li><a href="#"><span id="span_current_page">1</span> /<span
							id="span_count_page">1</span></a></li>
					<li><a onclick="getAudios(1)" href="#">下一页</a></li>
					<li><a onclick="getAudios(5)" href="#">最页</a></li>
				</ul>
				<!-- <ul class="pager">
					<li class="previous"><a onclick="getAudios(-1)" href="#">&larr;
							上一页</a></li>
					<li class="next"><a onclick="getAudios(1)" href="#">下一页
							&rarr;</a></li>
				</ul> -->
			</div>
		</div>
	</div>
</body>
</html>