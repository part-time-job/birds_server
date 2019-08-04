<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<title>这是纯文本</title>

<script src="<c:url value="/resources/ue/js/puretext.js" />"></script>

</head>
<body onload="initDatas()">
	<div class="content-section">
		<div class="container" style="background: #fff">
			<section id="content"> <section class="vbox"> <section
				class="scrollable"> <section class="hbox stretch">
			<aside class="bg-white"> <section class="vbox"> <!-- <header class="header bg-light lt">
                    					<li class="active"><a href="#activity" data-toggle="tab">最新列表</a></li>
                      <ul class="nav nav-tabs nav-white">
                        <li class="active"><a href="#activity" data-toggle="tab">Activity</a></li>
                        <li class=""><a href="#events" data-toggle="tab">Events</a></li>
                        <li class=""><a href="#interaction" data-toggle="tab">Interaction</a></li>
                      </ul>
                    </header> --> <section class="scrollable">
			<div class="tab-content">
				<div class="tab-pane active" id="activity">
					<div class="text-center wrapper" id="div_puretext_spinner">
						<i class="fa fa-spinner fa fa-spin fa fa-large"></i>
					</div>
					<ul
						class="list-group no-radius m-b-none m-t-n-xxs list-group-lg no-border"
						id="ul_myinfo_puretexts">

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
				<div class="tab-pane" id="events">
					<div class="text-center wrapper">
						<i class="fa fa-spinner fa fa-spin fa fa-large"></i>
					</div>
				</div>
				<div class="tab-pane" id="interaction">
					<div class="text-center wrapper">
						<i class="fa fa-spinner fa fa-spin fa fa-large"></i>
					</div>
				</div>
			</div>
			</section> </section> </aside> <aside class="col-lg-3 b-l"> <section class="vbox">
			<section class="scrollable padder-v">
			<div class="panel">
				<h4 class="font-thin padder">
					<a href="puredetail" target="mainframe">你可能会喜欢</a>
				</h4>
				<ul class="list-group" id="ul_top10_events">


				</ul>
			</div>
			<div class="panel clearfix">
				<div class="panel-body">
					<a href="#" class="thumb pull-left m-r"> <img
						src="<c:url value="/resources/images/a0.png" />"
						class="img-circle">
					</a>
					<div class="clear">
						<a href="#" class="text-info">@Mike Mcalidek <i
							class="fa fa-twitter"></i></a> <small class="block text-muted">2,415
							followers / 225 tweets</small> <a href="#"
							class="btn btn-xs btn-success m-t-xs">Follow</a>
					</div>
				</div>
			</div>
			</section> </section> </aside> </section> </section> </section> <a href="#" class="hide nav-off-screen-block"
				data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
			</section>
		</div>
	</div>
</body>
</html>