function showLoginModel() {
	changeCode(); // 刷新验证吗
	$('#login_Modal').modal('show');

}
function showRegisterModel() {
	changeCode(); // 刷新验证吗
	$('#register_Modal').modal('show');

}
function login() {

	$("#a_register_result").html("注册");
	$('#login_Modal').modal('hide');

	// 获取参数
	var use_phone = $("#input_login_phone").val();
	var use_password = $("#input_login_password").val();

	$("#div_header_spinner").attr("class", "show");

	// alert(use_phone + ";" + use_password);
	// $("#a_login_result").html("正在登录。。。");
	$("#a_login_result").attr("onclick", "javascript:void(0);");

	// 后台登录
	$.ajax({
		type : "post",
		url : "../api/user/login",
		async : true,
		data : "use_phone=" + use_phone + "&use_password=" + use_password,
		success : function(userJson) {
			loginResponse(userJson);
		}
	});

}
function loginResponse(userJson) {

	$("#div_header_spinner").attr("class", "hide");
	// alert(userJson);

	if (userJson == null || userJson == "") {
		$("#a_login_result").html("登录失败,重新登录");
		$("#a_login_result").attr("onclick", "javascript:showLoginModel();");
		return;
	}

	if (userJson == "手机号不存在" || userJson == "密码错误") {
		$("#a_login_result").html(userJson + ",重新登录");
		$("#a_login_result").attr("onclick", "javascript:showLoginModel();");
		// alert("登录失败");
	} else {
		var user = JSON.parse(userJson);
		$("#a_login_result").html("欢迎你：<strong>" + user.use_name + "<strong></a><a onclick=\"javascript:logout();\"style=\"text-color:blue\" href=\"#\">注销");
		$("#img_logined_icon").attr("src", "../user/icon/a0.png");
		$("#a_user_myinfo").attr("href", "myinfo");
		$("#span_user_notifications").attr("class",
				"badge badge-sm up bg-danger count");
	}
}
function register() {

	$("#a_login_result").html("登录");
	$('#register_Modal').modal('hide');
	// 获取参数
	var use_phone = $("#input_register_phone").val();
	var use_password = $("#input_register_password").val();
	var use_repassword = $("#input_register_repassword").val();
	var captcha = $("#input_register_captcha").val();
	if (use_password != use_repassword) {
		alert("两次密码不一致");
		return;
	}

	$("#div_header_spinner").attr("class", "show");
	// alert(use_phone + ";" + use_password);
	// $("#a_register_result").html("正在注册。。。");
	$("#a_register_result").attr("onclick", "javascript:void(0);");

	// 后台同步方式验证验证码
	$.ajax({
		type : "post",
		url : "../code/captcha",
		async : false,
		data : "captcha=" + captcha,
		success : function(captchaJson) {
			if (captchaJson != "ok") {
				alert("验证码不匹配");
				changeCode(); // 刷新验证吗
				$("#div_header_spinner").attr("class", "hide");
				return;
			}
			// 后台注册
			$.ajax({
				type : "post",
				url : "../api/user/register",
				async : true,
				data : "use_phone=" + use_phone + "&use_password="
						+ use_password,
				success : function(userJson) {
					registerResponse(userJson);
				}
			});
		}
	});

}

function registerResponse(userJson) {
	$("#div_header_spinner").attr("class", "hide");
	// alert(userJson);
	if (userJson == null || userJson == "") {
		$("#a_register_result").html("注册失败,重新注册");
		$("#a_register_result").attr("onclick",
				"javascript:showRegisterModel();");
		return;
	}
	if (userJson == "注册失败" || userJson == "该手机号已经注册过") {

		$("#a_register_result").html(userJson + ",重新注册");
		$("#a_register_result").attr("onclick",
				"javascript:showRegisterModel();");
	} else {
		$("#a_register_result").html("注册成功");
		$("#a_register_result").attr("onclick",
				"javascript:showRegisterModel();");
		showLoginModel();
	}
}

function logout(){
	// 后台注册
	$.ajax({
		type : "post",
		url : "../api/user/logout",
		async : false,		
		success : function() {
			window.location.href="../index/index";
		}
	});
}


/* 验证码部分 */
$(function() { // 生成验证码
	$('#kaptchaImage').click(
			function() {
				$(this).hide().attr(
						'src',
						'../code/captcha-image?'
								+ Math.floor(Math.random() * 100)).fadeIn();
			});
});

window.onbeforeunload = function() {
	// 关闭窗口时自动退出
	if (event.clientX > 360 && event.clientY < 0 || event.altKey) {
		alert(parent.document.location);
	}
};

function changeCode() { // 刷新
	$('#kaptchaImage').hide().attr('src',
			'../code/captcha-image?' + Math.floor(Math.random() * 100))
			.fadeIn();
	event.cancelBubble = true;
}
/* 验证码部分 */