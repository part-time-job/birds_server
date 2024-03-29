var current_page = 1;

/**
 * 初始化数据
 */
function initDatas() {
	// 加载首页
	first();
}

function fillIntoPage(eventsJson) {

	// 将进度条隐藏起来
	$("#div_myinfo_puretexts_spinner")
			.attr("class", "text-center wrapper hide");
	// 更新总页数
	countPage();

	var ul_list_news = $("#ul_myinfo_puretexts");
	ul_list_news.html("");

	// alert(eventsJson);
	var events = JSON.parse(eventsJson);
	// alert(events.length);

	var lis = "";
	for ( var i in events) {

		var li_item = "";

		li_item += "<li class=\"list-group-item\">";
		li_item += "	<a href=\"#\"	class=\"thumb-sm pull-left m-r-sm\"> ";
		li_item += "		<img src=\"" + "../user/icon/a0.png\""
				+ "class=\"img-circle\">";
		li_item += "	</a> ";
		li_item += "	<a href=\"#\" class=\"clear\">";
		li_item += "		<small class=\"pull-right\"><i class=\"glyphicon glyphicon-calendar\"> "
				+ events[i].eve_time
						.substring(0, events[i].eve_time.length - 5)
				+ "</i>"
				+ "</small>";
		li_item += "		<p><strong class=\"block\">" + events[i].eve_question
				+ "</strong></p> ";
		li_item += "		<small>";
		li_item += "		<p style='text-indent: 2em;'>" + events[i].eve_puretext
				+ "</p>";
		li_item += "		</small>";
		li_item += "		<div>";

		li_item += "			<p>";
		li_item += "	  			<span class=\"pull-center\">";
		li_item += "					<i class=\"glyphicon glyphicon-comment\"> "
				+ events[i].eve_positivecount + "";
		li_item += "					</i>";
		li_item += "				</span>";
		li_item += "	  			<span class=\"pull-right\">";
		li_item += "					<i class=\"glyphicon glyphicon-thumbs-up\"> "
				+ events[i].eve_positivecount + "";
		li_item += "					</i>";
		li_item += "				</span>";
		li_item += "			</p>";
		li_item += "		</div>";

		li_item += "	</a>";
		li_item += "</li>";

		lis += li_item;
	}

	ul_list_news.html(lis);
}

function countPage() {
	$.ajax({
		type : "post",
		url : "../api/event/puretext/myinfocountPage",
		async : true,
		success : function(count_page) {
			// alert(count_page);
			if (current_page == -1) {
				current_page = count_page;
			}
			$("#span_count_page").html(count_page);
			$("#span_current_page").html(current_page);
		}
	});
}

function first() {
	current_page = 1;
	$.ajax({
		type : "post",
		url : "../api/event/puretext/myinfofirst",
		async : true,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}

function previous() {
	var currentPage = $("#span_current_page").text();
	current_page = currentPage - 1;
	if (current_page <= 0) {
		alert("不能再少了");
		current_page = 1;
		return;
	}
	$.ajax({
		type : "post",
		url : "../api/event/puretext/myinfoprevious",
		async : true,
		data : "currentPage=" + currentPage,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}

function next() {
	var currentPage = new Number($("#span_current_page").text());
	current_page = currentPage + 1;
	var count_page = new Number($("#span_count_page").html().trim());
	if (current_page > count_page) {
		alert("不能再多了");
		current_page = currentPage - 1;
		return;
	}
	$.ajax({
		type : "post",
		url : "../api/event/puretext/myinfonext",
		async : true,
		data : "currentPage=" + currentPage,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}

function last() {
	current_page = -1;
	$.ajax({
		type : "post",
		url : "../api/event/puretext/myinfolast",
		async : true,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}
