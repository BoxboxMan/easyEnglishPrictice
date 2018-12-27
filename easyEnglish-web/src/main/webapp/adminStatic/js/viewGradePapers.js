$(function(){
	$.get("getGradePapers.action", {} , function(data , json){
		$.each(data, function(){
			var tr = document.createElement("tr");
			tr.align="center";
			$("<td/>").html(this.paperName).appendTo(tr);
			$("<td/>").html(this.totalStudents).appendTo(tr);
			$("<td/>").html(this.average).appendTo(tr);
			$("<td/>").html("<a href='http://localhost:8080/easyEnglish-web/paper/gradePaper.html?paperId="+this.id+"'>"+this.toGrade+"</a>").appendTo(tr);
			$("#t").append(tr);
		})
	})
})	