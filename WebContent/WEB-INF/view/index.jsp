<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>鸟类监测互动平台</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div id="mainDiv">
				<iframe id="mainframe" frameborder="0" width="100%" height="800px"
					scrolling="no" src="indexmap" name="mainframe"></iframe>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>