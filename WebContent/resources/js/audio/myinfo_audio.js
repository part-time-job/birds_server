var pageNow = 0;
var pageNum = 2;
function getAudios(page) {
	$("#div_audio_spinner").attr("class","text-center wrapper hide");
	$.ajax({
		url : "../audio/getPageNum",
		type : 'post',
		success : function(arg) {
			pageNum = arg;
			$("#span_count_page").text(pageNum);
		}
	});
	if (page == 5) {
		pageNow = pageNum;
		$("#span_current_page").text(pageNow);
	} else if (page == 4) {
		pageNow = 1;
		$("#span_current_page").text(pageNow);
	} else if (page == -1) {
		pageNow = pageNow - 1;
		if (pageNow == 0) {
			pageNow = 1;
			alert("已经是第一页了");
			return;
		}
		$("#span_current_page").text(pageNow);
	} else if (page == 1) {

		pageNow = pageNow + 1;
		if (pageNow > pageNum) {
			pageNow = pageNum;
			alert("已经是最后一页");
			return;
		}
		// alert("now" + pageNow + "num:" + pageNum);
		$("#span_current_page").text(pageNow);
	}
	$("#span_current_page").text(pageNow);
	var ul = $("#ul_myinfo_audios");
	ul.html("");
	/* 当前页的音频 */
	$.ajax({
		url : "../audio/myAudio",
		type : 'post',
		data : "pageNow=" + pageNow,
		success : function(arg) {
			var audios = JSON.parse(arg);

			var ul_html = "";
			for (var i = 0; i < audios.length; i++) {
				ul_html += fillUl(audios[i]);
			}
			ul.html(ul_html);
		}
	});
	/* 音频排行榜前10 */
	/*var ul_topList = $("#topList");

	ul_topList.html("");
	$.ajax({
		url : "../audio/getAudioTopTen",
		type : 'post',
		success : function(arg) {
			var audios = JSON.parse(arg);
			var topList_html = "";
			for (var i = 0; i < audios.length; i++) {
				topList_html += fillList(audios[i], i);
			}
			ul_topList.html(topList_html);
		}
	});*/
}
/*此方法在这里不被使用*/
function fillList(audio, i) {
	var li_html = "";
	i += 1;
	li_html += "<li  class='list-group-item clearfix'>";
	li_html += "<a href='#' class='pull-left thumb-sm m-r'> <h4>" + i
			+ "</h4></a> ";

	li_html += "<div class='clear text-ellipsis'>";
	li_html += "<audio preload=\"none\" style=\"width: 50%\" src='../user/audio/" + audio.eve_audiourl
			+ "' id='ap' controls='controls'>";
	li_html += "Your browser does not support the audio element.</audio>";
//	alert(audio.eve_time);
	li_html += "<span style=\"nowrap;text-overflow:ellipsis;\">" + audio.eve_description +"&nbsp"+ audio.eve_time + "</span>";
	li_html += "</div>";

	li_html += "<div class='pull-right m-l'>";

	li_html += "<i>" + " <span>点赞数:" + audio.eve_positivecount + "</span>";
	li_html += "</i>";
	li_html += "&nbsp;&nbsp";
//	li_html += "<a href='../audio/getDetail?eve_id="+audio.eve_id+"'>";
	li_html += "<span><a href='audioDetail?eve_id="+audio.eve_id+"' target='mainframe'>查看详情</a></span>";
//	li_html += "</a>";
	li_html += "</div>";
	li_html += "</div>";
	li_html += "</li>";
	return li_html;
}

function fillUl(audio) {
	var li_html = "";
	li_html += "<li class='list-group-item'>";

	li_html += "<div style='background:#BDBDA9' ><div class='pull-right m-l'>";
	li_html += "<a href='#'>";
	li_html += "<i>" + " <span style='font-color:white'>点赞数:" + audio.eve_positivecount + "</span>";
	li_html += "</i>";
	li_html += "</a>";

	li_html += "</div>";

	li_html += "<div class='clear text-ellipsis'>";

	li_html += "<img class=\"img-circle\" height='40px' width='40px' id='myPlayer"+audio.eve_id+"' src='../resources/images/play.jpg' onclick='palyOrPause("+audio.eve_id+");' /><audio  id='ap"+audio.eve_id+"' preload=\"none\" src='../user/audio/" + audio.eve_audiourl
	//li_html += "<i height='20px' width='20px' id='myPlayer"+audio.eve_id+"' class='glyphicon glyphicon-play-circle' onclick='palyOrPause("+audio.eve_id+");'></i><audio  id='ap"+audio.eve_id+"' preload=\"none\" style=\"width: 30%\" src='" + audio.eve_audiourl
			+ "'>";//controls='controls'
	li_html += "Your browser does not support the audio element.</audio>";

	li_html += "<span ><font color='black' size='5'> &nbsp;&nbsp" + audio.eve_description + "&nbsp" + audio.eve_time +" </font></span>";

	li_html += "</div>";
	li_html += "</div>";

	li_html += "</li>";
	return li_html;

}

var playingIcon;
var playingAudio;
var isPlaying = false;
function palyOrPause(id){
	var playControl = document.getElementById("ap" + id);
	var playIcon = $("#myPlayer" + id);
	playIcon.attr("src", "");
	if(playingAudio == null){
		playControl.play();
		isPlaying = true;
		playingAudio = playControl;
		playingIcon = playIcon;
		playingIcon.attr("src","../resources/images/pause.jpg");
	}else{
		playingAudio.pause();
		playingIcon.attr("src","../resources/images/play.jpg");
		if(playingAudio != playControl){
			playControl.play();
			isPlaying = true;
			playIcon.attr("src","../resources/images/pause.jpg");
			playingAudio= playControl;
			playingIcon = playIcon;
		}else{
			if(isPlaying){
				playControl.pause();
				isPlaying = false;
				playIcon.attr("src","../resources/images/play.jpg");
			}else{
				playControl.play();
				isPlaying = true;
				playIcon.attr("src","../resources/images/pause.jpg");
			}
		}
	}
//	var playControl = document.getElementById("ap" + id);
//	var playIcon = $("#myPlayer" + id);
//	
//	playIcon.attr("src", "");
//	if(isPlaying){
//		isPlaying = false;
//		playControl.pause();
//		playIcon.attr("src","../resources/images/play.jpg");
//	}else{
//		isPlaying = true;
//		playControl.play();
//		playIcon.attr("src","../resources/images/pause.jpg");
//	}
}

/*function palyOrPause(id){
	var playControl = document.getElementById("ap" + id);
	var playIcon = $("#myPlayer" + id);
	
	playIcon.attr("class", "");
	if(isPlaying){
		isPlaying = false;
		playControl.pause();
		playIcon.attr("class","glyphicon glyphicon-play-circle");
	}else{
		isPlaying = true;
		playControl.play();
		playIcon.attr("class","glyphicon glyphicon-pause");
	}
}*/

function good(id) {
	var goodcount = $("#" + id + "");
	$.ajax({
		url : "../audio/addGood",
		type : 'post',
		data : "eve_id=" + id,
		success : function(arg) {

		}
	});
	if (goodcount.length == 1) {
		goodcount.text(parseInt(goodcount.text()) + 1);
	} else {
		for (good in goodcount) {
			good.text(parseInt(good.text()) + 1);
		}
	}
}