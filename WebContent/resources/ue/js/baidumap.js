$(document).ready(function(){
	loadMap();
});

function loadMap(){
	initData();
	//地图类型和缩略图
	var mapType1 = new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]});
	var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT});

	var overView = new BMap.OverviewMapControl();
	var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
	//初始化地图
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 5);
	map.enableScrollWheelZoom();
	
	map.addControl(mapType1);          //2D图，卫星图
	map.addControl(mapType2);          //左上角，默认地图控件
	map.setCurrentCity("北京");        //由于有3D图，需要设置城市哦
	map.addControl(overView);          //添加默认缩略地图控件
	map.addControl(overViewOpen);      //右下角，打开
	map.setMapStyle("grayscale");
	//定位
	var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(res){
		if(this.getStatus()== BMAP_STATUS_SUCCESS){
			var lng = res.point.lng;
			var lat = res.point.lat;
			$("#mylng").text(lng);
			$("#mylat").text(lat);
			//alert(lng+","+lat);
			bindingClick();
			var geoc = new BMap.Geocoder();
			
			geoc.getLocation(res.point,function(loc){
				var addComp = loc.addressComponents;
				$("#mylocation").text(addComp.province + ", " + addComp.city + ", " + addComp.district);
			});
		}
		else{
			$("#mylocation").text("定位失败了，浏览器可能不支持定位");
		}
	},{enableHighAccuracy: true})
		
	function bindingClick(){
		$("#location-but").click(function(){
			var mlng = $("#mylng").text();
			var mlat = $("#mylat").text();
			if(mlng==null||mlat==null){
				alert("定位失败了，请尝试开启浏览器定位功能");
				return ;
			}
			var mLocPoint = new BMap.Point(mlng,mlat);
			map.centerAndZoom(mLocPoint, 17);
		});
	}
	
	getAllEventAndMarkThem();
	function getAllEventAndMarkThem(){
		$.ajax({
			type:"POST",
			url:"../api/map/getAllEvent",
			success:function(msg){
				var allEvent =  JSON.parse(msg);
				var markers = [];
				var pt = null;
				for(var i in allEvent){
					if(allEvent[i].eve_longitude!=null&&allEvent[i].eve_latitude!=null&&(allEvent[i].eve_longitude!=0&&allEvent[i].eve_latitude!=0)){
						pt = new BMap.Point(allEvent[i].eve_longitude,allEvent[i].eve_latitude);
						
						var mk = new BMap.Marker(pt);
						
						markers.push(mk);
						addClick(mk,allEvent[i]);
					}
					
				}
				
				var markerClusterer = new BMapLib.MarkerClusterer(map, {markers:markers});
			}
		});
	}
//	var MAX = 10000;
//	var markers = [];
//	var pt = null;
//	var i = 0;
//	for (; i < MAX; i++) {
//	   pt = new BMap.Point(Math.random() * 40 + 85, Math.random() * 30 + 21);
//	   markers.push(new BMap.Marker(pt));
//	}
//	//最简单的用法，生成一个marker数组，然后调用markerClusterer类即可。
//	var markerClusterer = new BMapLib.MarkerClusterer(map, {markers:markers});
}

function initData(){
	$.ajax({
		type:"POST",
		url:"../api/map/userCount",
		success:function(msg){
			$("#userCount").text(msg);
		}
	});
	
	$.ajax({
		type:"POST",
		url:"../api/map/eventCount",
		success:function(msg){
			$("#eventCount").text(msg);
		}
	});
	$.ajax({
		type:"POST",
		url:"../api/map/countBirds",
		success:function(msg){
			$("#countBirds").text(msg);
		}
	});
	$.ajax({
		type:"POST",
		url:"../api/map/commentCount",
		success:function(msg){
			$("#commentCount").text(msg);
		}
	});
}

function addClick(marker,event){
	marker.addEventListener("click",showDetail);
	function showDetail(){
		if(event.eve_datatype==0)
			showText(event)
		else if(event.eve_datatype==1)
			showPicture(event)
		else
			showAudio(event);
	}
}

function showDetailOnPage(eventId){
	$.ajax({
		type:"POST",
		url:"../api/map/getEventById",
		data:"eventId="+eventId,
		success:function(msg){
			var event = JSON.parse(msg);
			if(event.eve_datatype==0){
				showText(event);
			}
			else if(event.eve_datatype==1){
				showPicture(event);
			}else{
				showAudio(event);
			}
		}
	});
}

function clearDom(dom){
	$(dom).html("");
}
function showText(event){
	clearDom($("#mainData"));
	clearDom($("#extraData"));
	
	var question = event.eve_question;
	var description = event.eve_description;
	var userId = event.use_id;
	var pictureTime = event.eve_time;
	var timeForUs = "上传时间未知";
	if(pictureTime!=null)
		timeForUs = pictureTime.substr(0,10);
	if(question==null)
		question = "暂时没有问题哦";
	if(description==null)
		description = "暂时没有描述哦";
	
	//var src = "../user/picture/"+event.eve_pictureurl;
	var mainData = "<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">文本信息</h4></div><div class=\"panel-body\">"+event.eve_puretext+"</div></div>";
	var extraData = "<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">上传者提问</h4></div><div class=\"panel-body\">"+question+"</div></div>"
					+"<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">描述信息</h4></div><div class=\"panel-body\">"+description+"</div><div class=\"panel-body\">"+timeForUs+"</div></div>"
					+"<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">鸟数量估计</h4></div><div class=\"panel-body\">"+event.eve_count+"</div></div>";
	$("#mainData").html(mainData);
	$("#extraData").html(extraData);
	
}

function showPicture(event){
	clearDom($("#mainData"));
	clearDom($("#extraData"));
	
	var question = event.eve_question;
	var description = event.eve_description;
	var userId = event.use_id;
	var pictureTime = event.eve_time;
	var timeForUs = "上传时间未知";
	if(pictureTime!=null)
		timeForUs = pictureTime.substr(0,10);
	if(question==null)
		question = "暂时没有问题哦";
	if(description==null)
		description = "暂时没有描述哦";
	
	var src = "../user/picture/"+event.eve_pictureurl;
	var mainData = "<img src="+src+" alt=\"picture\" class=\"img-rounded\">";
	var extraData = "<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">上传者提问</h4></div><div class=\"panel-body\">"+question+"</div></div>"
					+"<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">描述信息</h4></div><div class=\"panel-body\">"+description+"</div><div class=\"panel-body\">"+timeForUs+"</div></div>"
					+"<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">鸟数量估计</h4></div><div class=\"panel-body\">"+event.eve_count+"</div></div>";
	$("#mainData").html(mainData);
	$("#extraData").html(extraData);
}

function showAudio(event){
	clearDom($("#mainData"));
	clearDom($("#extraData"));
	
	var question = event.eve_question;
	var description = event.eve_description;
	var userId = event.use_id;
	var pictureTime = event.eve_time;
	var timeForUs = "上传时间未知";
	if(pictureTime!=null)
		timeForUs = pictureTime.substr(0,10);
	if(question==null)
		question = "暂时没有问题哦";
	if(description==null)
		description = "暂时没有描述哦";
	var src = "../user/audio/"+event.eve_audiourl;
	var mainData = "<audio src="+src+" controls=\"controls\"></audio>";
	var extraData = "<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">上传者提问</h4></div><div class=\"panel-body\">"+question+"</div></div>"
		+"<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">描述信息</h4></div><div class=\"panel-body\">"+description+"</div><div class=\"panel-body\">"+timeForUs+"</div></div>"
		+"<div class=\"panel panel-default\"><div class=\"panel-heading\"><h4 class=\"panel-title\">鸟数量估计</h4></div><div class=\"panel-body\">"+event.eve_count+"</div></div>";
	$("#mainData").html(mainData);
	$("#extraData").html(extraData);
	
}
