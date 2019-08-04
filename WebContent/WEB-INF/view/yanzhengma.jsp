<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/view/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		$(function() { //生成验证码         
			$('#kaptchaImage').click(
					function() {
						$(this).hide().attr(
								'src',
								'../code/captcha-image?'
										+ Math.floor(Math.random() * 100))
								.fadeIn();
					});
		});

		window.onbeforeunload = function() {
			//关闭窗口时自动退出  
			if (event.clientX > 360 && event.clientY < 0 || event.altKey) {
				alert(parent.document.location);
			}
		};

		function changeCode() { //刷新
			$('#kaptchaImage').hide().attr('src',
					'../code/captcha-image?' + Math.floor(Math.random() * 100))
					.fadeIn();
			event.cancelBubble = true;
		}
	</script>

	<div class="form-group">
		<label>验证码 </label> <input name="j_code" type="text" id="kaptcha"
			maxlength="4" class="form-control" /> <br /> <img
			src="../code/captcha-image" id="kaptchaImage"
			style="margin-bottom: -3px" /> <a href="#" onclick="changeCode()">看不清?换一张</a>
	</div>
</body>
</html>