
var current_page = 1;

/**
 * 初始化数据
 */
function initDatas(){	
	// 加载首页
	first();
	
	loadTop10();
}
function loadTop10(){
	
	$.ajax({
		type : "post",
		url : "../api/event/puretext/top",
		async : true,
		success : function(eventsJson) {
			fillIntoPageTop(eventsJson);
		}
	});
}
function fillIntoPageTop(eventsJson){	
	var ul_list_news = $("#ul_top10_events");
	ul_list_news.html("");	
	var events = JSON.parse(eventsJson);
	var lis = "";	
	for ( var j in events) {
		var i = events.length - j - 1;
		var li_item = "";	
      
        li_item +="<a href=\"#\" class=\"list-group-item clearfix\">";
		li_item +=" <span class=\"pull-right h1 text-muted m-l\">"+(1+new Number(i))+"</span>";	
		li_item +="	<span class=\"pull-left thumb-sm avatar m-r\">";	
		li_item +="	 <img src=\""+"../user/icon/a0.png"+"\" alt=\"...\">";	
		li_item +="	</span>";	
		li_item +="	<span class=\"clear\">";	
		li_item +="	<strong>"+events[i].eve_question+"</strong>";	
		li_item +="	<small class=\"text-muted clear text-ellipsis\" style=\"nowrap;text-overflow:ellipsis;\"> "+events[i].eve_puretext +"</small>";
		li_item +=" </span>";
		
		li_item +="	  			<span class=\"pull-center\">";
		li_item +="					<i class=\"glyphicon glyphicon-comment\"> "+events[i].eve_positivecount+"";
		li_item +="					</i>";
		li_item +="				</span>";
		li_item +="	  			<span class=\"pull-right\">";
		li_item +="					<i class=\"glyphicon glyphicon-thumbs-up\"> "+events[i].eve_positivecount+"";
		li_item +="					</i>";
		li_item +="				</span>";
		
		li_item +=" </a>";
		
		lis += li_item;
	}
	
	ul_list_news.html(lis);
}
function fillIntoPage(eventsJson){	
	
	// 将进度条隐藏起来	
	$("#div_puretext_spinner").attr("class","text-center wrapper hide");
	// 更新总页数
	countPage();
	
	var ul_list_news = $("#ul_myinfo_puretexts");
	ul_list_news.html("");	
	
	//alert(eventsJson);
	var events = JSON.parse(eventsJson);
	//alert(events.length);
	
	var lis = "";
	var str = "";
//	for(var i=0;i< 20;i++){
//		str += "我今天很开心;";
//	}
	for ( var i in events) {
		
		
		var li_item = "";	
		
		li_item +="<li class=\"list-group-item\">";
		li_item +="	<a href=\"#\"	class=\"thumb-sm pull-left m-r-sm\"> ";	
		li_item +="		<img src=\""+"../user/icon/a0.png\""+"class=\"img-circle\">";	
		li_item +="	</a> ";	
		li_item +="	<a href=\"#\" class=\"clear\">";	
		li_item +="		<small class=\"pull-right\"><i class=\"glyphicon glyphicon-calendar\"> "+events[i].eve_time.substring(0,events[i].eve_time.length - 5)+"</i>"+"</small>";	
		li_item +="		<p><strong class=\"block\">"+events[i].eve_question + "</strong></p> ";	
		li_item +="		<small>";	
		li_item +="		<p style='text-indent: 2em;'>"+str+"</p>";
		li_item +="		</small>";		  
		li_item +="		<div>";		  
		
		li_item +="			<p>";
		li_item +="	  			<span class=\"pull-center\">";
		li_item +="					<i class=\"glyphicon glyphicon-comment\"> "+events[i].eve_positivecount+"";
		li_item +="					</i>";
		li_item +="				</span>";
		li_item +="	  			<span class=\"pull-right\">";
		li_item +="					<i class=\"glyphicon glyphicon-thumbs-up\"> "+events[i].eve_positivecount+"";
		li_item +="					</i>";
		li_item +="				</span>";
		li_item +="			</p>";
		li_item +="		</div>";
		
		li_item +="	</a>";
		li_item +="</li>";
		
		lis += li_item;
	}
	
	ul_list_news.html(lis);
}

function countPage(){
	$.ajax({
		type : "post",
		url : "../api/event/puretext/countPage",
		async : true,
		success : function(count_page) {
			//alert(count_page);
			if(current_page == -1){
				current_page = count_page;
			}
			$("#span_count_page").html(count_page);
			$("#span_current_page").html(current_page);
		}
	});
}

function first(){
	current_page = 1;
	$.ajax({
		type : "post",
		url : "../api/event/puretext/first",
		async : true,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}

function previous(){
	var currentPage = $("#span_current_page").text();
	current_page = currentPage - 1;
	if(current_page <= 0){
		alert("不能再少了");
		current_page = 1;
		return ;
	}
	$.ajax({
		type : "post",
		url : "../api/event/puretext/previous",
		async : true,
		data : "currentPage=" + currentPage,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}

function next(){
	var currentPage = new Number($("#span_current_page").text());
	current_page = currentPage + 1;
	var count_page = new Number($("#span_count_page").html().trim());
	if(current_page > count_page){
		alert("不能再多了");
		current_page = currentPage - 1;
		return ;
	}
	$.ajax({
		type : "post",
		url : "../api/event/puretext/next",
		async : true,
		data : "currentPage=" + currentPage,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}

function last(){
	current_page = -1;
	$.ajax({
		type : "post",
		url : "../api/event/puretext/last",
		async : true,
		success : function(eventsJson) {
			fillIntoPage(eventsJson);
		}
	});
}
