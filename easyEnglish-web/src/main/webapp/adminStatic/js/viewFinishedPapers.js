$(function(){
	$.get("getStudentPapers.action", {} , function(data , json){
		$.each(data, function(){
			var tr = document.createElement("tr");
			tr.align="center";
			$("<td/>").html("<a href='http://localhost:8080/easyEnglish-web/paper/getStudentPaper.html?studentPaperId="+this.id+"'>"+this.paperName+"</a>").appendTo(tr);
			$("<td/>").html(this.endTime).appendTo(tr);
			$("<td/>").html(this.score).appendTo(tr);
			$("tbody").append(tr);
		})
	})
})