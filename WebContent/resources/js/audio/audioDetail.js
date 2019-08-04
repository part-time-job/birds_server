




function getAudioDetail(){
	$.ajax({
		url : "../audio/getAudioDetail",
		type : 'post',
		success : function(arg) {
			fillAudio(JSON.parse(arg));
		}
	});
}

function fillAudio(audioEvent){
	$("#audioUrl").attr("src", audioEvent.eve_audiourl);
}