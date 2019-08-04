var user = null;

/**
 * 初始化数据
 */
function initmyinfo() {
	$.ajax({
		type : "post",
		url : "../api/user/myinfo",
		async : true,
		success : function(userJson) {
			fillULs(userJson);
		}
	});
	// loadPictures();
}

function loadPictures() {
	alert("1231");
}
function loadAudios() {
	alert("1232");
}
function loadPuretexts() {
	// 加载首页
	alert("1233");
	initDatas();
}

function startedit() {
	$("#a_user_edit").attr("onclick", "canceledit()");
	seteditable("true");
}
function canceledit() {
	$("#a_user_edit").attr("onclick", "startedit()");
	seteditable("false");
}

function endedit() {
	$("#div_user_myinfo_spinner").attr("class", "text-center wrapper");
	$("#a_user_edit").attr("onclick", "startedit()");
	seteditable("false");

	var user_name = $("#div_user_name").html();
	var user_sex = $("#p_user_sex").html();
	var user_birthday = $("#p_user_birthday").html();
	var user_phone = $("#p_user_phone").html();
	var user_mail = $("#p_user_mail").html();
	var user_introduction = $("#p_user_introduction").html();
	var user_remark = $("#p_user_remark").html();

	user.use_name = user_name;
	user.use_sex = user_sex;
	user.use_birthday = user_birthday;
	user.use_phone = user_phone;
	user.use_mail = user_mail;
	user.use_introduction = user_introduction;
	user.use_remark = user_remark;

	alert(user);
	// fillIntoPage(user)
	$.ajax({
		type : "post",
		url : "../api/user/save",
		async : true,
		data : "user=" + JSON.stringify(user),
		success : function(userJson) {
			fillULs(userJson);
		}
	});
}

function seteditable(iseditable) {
	$("#div_user_name").attr("contentEditable", iseditable);
	$("#p_user_sex").attr("contentEditable", iseditable);
	$("#p_user_birthday").attr("contentEditable", iseditable);
	$("#p_user_phone").attr("contentEditable", iseditable);
	$("#p_user_mail").attr("contentEditable", iseditable);
	$("#p_user_introduction").attr("contentEditable", iseditable);
	$("#p_user_remark").attr("contentEditable", iseditable);
}

function fillULs(userJson) {
	$("#div_user_myinfo_spinner").attr("class", "text-center wrapper hide");
	if ("请先登录" == userJson || "保存失败" == userJson || "输入不合法" == userJson) {
		alert(userJson);
		return;
	}
	user = JSON.parse(userJson);
	// $("#img_use_icon").html();
	$("#div_user_name").html(user.use_name);
	$("#small_user_positivecount").html(user.use_positivecount);
	// $("#span_use_events_num").html("100");
	// $("#span_use_comments_num").html("200");
	$("#p_user_sex").html(user.use_sex);
	$("#p_user_birthday").html(user.use_birthday);
	$("#p_user_phone").html(user.use_phone);
	$("#p_user_mail").html(user.use_mail);
	$("#p_user_introduction").html(user.use_introduction);
	$("#p_user_remark").html(user.use_remark);

}
