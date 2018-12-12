$(function(){
	$.get("getFinishedPapers.html", {} , function(data , json){
		$.each(data, function(){
			var tr = document.createElement("tr");
			tr.align="center";
			$("<td/>").html(this.paperName).appendTo(tr);
			$("<td/>").html(this.endTime).appendTo(tr);
			$("<td/>").html(this.score).appendTo(tr);
			$("tbody").append(tr);
		})
	})
})