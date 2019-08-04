$(document).ready(function(){
	getDataOfPictureByPage(1);
});

function getDataOfPictureByPage(pageNow){
	$.ajax({
		type:"POST",
		url:"../api/event/getDataOfPictureByPage",
		data:"pageNow="+pageNow,
		success:function(msg){
			renderPage(msg);
		}
	});
}

function clear(dom){
	dom.html("");
}

function renderPage(msg){
	clear($("#container"));
	var showHtml = $("#container").html();
	var picturePageList = JSON.parse(msg);
	item = "";
	for(var i in picturePageList){
		var eventId = picturePageList[i].eve_id;
		var src = "../user/picture/"+picturePageList[i].eve_pictureurl;
		var question = picturePageList[i].eve_question;
		var description = picturePageList[i].eve_description;
		var userId = picturePageList[i].use_id;
		var pictureTime = picturePageList[i].eve_time;
		var timeForUs = "上传时间"
		if(pictureTime!=null)
			timeForUs = pictureTime.substr(0,10);
		var positiveCount = picturePageList[i].eve_positivecount;
		if(question==null)
			question = "暂时没有问题哦";
		if(description==null)
			description = "暂时没有描述哦";
		if(positiveCount==null||positiveCount==0)
			positiveCount = 0;
		if(i%4==0)
			item+="<div class=\"row\">";
		item+="<div class=\"col-md-3\"><div><div><div><img src="+src+" class=\"img-responsive img-rounded\" alt=\"这是鸟类的另一个家\" style=\"width:100%;\"></div>";
		item+="<div class=\"bg-info\"><p>上传者提问:<span>"+question+
			"</span></p><p>图片描述:<span>"+description+"</span></p>" +"<p>鸟数量估计:<span>"+picturePageList[i].eve_count+"</span></p>"+
					"<p>上传时间:"+timeForUs+
							"<span style=\"float:right\" class=\"glyphicon glyphicon-thumbs-up binding-click\" aria-hidden=\"true\" onclick=\"bindingClick(this)\">"+positiveCount+"</span>" +
									"<span class=\"event-id\" style=\"display:none\">"+eventId+"</span></p></div>";
		item+="</div></div></div>";
		if(i%4==3)
			item+="</div>";
		showHtml += item;
		item = "";
		
	}
	$("#container").html(showHtml);
}

function bindingClick(dom){
	$.ajax({
		type:"POST",
		url:"../api/event/addPicturePositiveCount",
		data:"eventId="+$(dom).next(".event-id").text(),
		success:function(msg){
			//alert(msg);
			$(dom).text(parseInt($(dom).text())+1);
		}
	});
}

function preRow(){
	var requestPage = new Number($("#pageNow").text());
	if(requestPage<=1)
		return;
	requestPage = requestPage-1;
	$("#pageNow").text(requestPage);
	getDataOfPictureByPage(requestPage);
	
}

function nextRow(){
	var requestPage = new Number($("#pageNow").text());
	requestPage = requestPage+1;
	$("#pageNow").text(requestPage);
	getDataOfPictureByPage(requestPage);
}
