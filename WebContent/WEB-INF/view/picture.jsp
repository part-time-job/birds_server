<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ include file="/WEB-INF/view/include.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>这是图片</title>
<script src="../resources/ue/js/picture.js"></script>
</head>
<body>
	<div class="content-section">
		<div id="container" class="container">
		</div>
		
		<div class="row">
				<ul class="pager">
					<li><a onclick="preRow();" href="#">上一页</a></li>
					<li><a href="#"><span id="pageNow">1</span></a></li>
					<li><a onclick="nextRow();" href="#">下一页</a></li>
				</ul>
		</div>
	</div>
	
	
	
	
</body>
</html>