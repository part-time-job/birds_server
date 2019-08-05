<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include.jsp"%>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
	#allmap{width:100%;height:100%;}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=fEfESYIoHQBydZsNRVqRaRRX"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/MarkerClusterer/1.2/src/MarkerClusterer_min.js"></script>
<script src="../resources/ue/js/baidumap.js"></script>
<script type="text/javascript"> 
function showImg(){ 
document.getElementById("wxImg").style.display='block'; 
} 
function hideImg(){ 
document.getElementById("wxImg").style.display='none'; 
} 
</script> 
<title>鸟类互动监测平台</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h2>已有<u><span id="userCount"></span></u>位用户加入我们，累计<u><span id="eventCount"></span></u>次上传，<u><span id="commentCount"></span></u>次互动，约有<u><span id="countBirds"></span></u>只鸟(或蝉)被发现！</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-md-9">
			<div id="allmap">
				<div id="loadMap">
					
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="row">
				<div>
					<h3>推测您的位置:</h3><h3 id="mylocation"></h3>
					<button id="location-but" type="button" class="btn btn-default">定位到我</button>
					<span id="mylng" style="display:none"></span><span id="mylat" style="display:none"></span>
					<h4>快下载app参与进来<a href="../user/app-android/mybirds-v1.3.apk" onMouseOut="hideImg()" onmouseover="showImg()"><u>android下载</u></a>
					<div id="wxImg" style="display:none;height:50px;back-ground:#f00;position:absolute;"><img src="APP扫我下载.png"/></div> </h4>
					<h4><span class="glyphicon glyphicon-hand-left" aria-hidden="true"></span>点击地图红色标记查看详情</h4>
				</div>
			</div>
			<div class="row">
				<div id="show">
					<div id="mainData">
					</div>
					<div id="extraData">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>