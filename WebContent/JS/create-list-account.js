$(document).ready(function(){
	$("#file").on("change",function(e){
		var files = $(this)[0].files;
		if(files.length >= 2){
			alert("Chon 1 file");
		}
		else{
			var filename = e.target.value.split('\\').pop();
			$("#label-span").text(filename);
		}
	});
});

