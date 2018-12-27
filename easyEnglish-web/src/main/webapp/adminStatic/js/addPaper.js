$(document).ready(function() {
	var sn = 0;
	var passage=0;
	function type1(){
		return "<div class='row'>\
				<div class='col-md-6'>\
					<div class='form-group col-sm-12'>\
						<label for='question' class='col-sm-2 control-label'>题目</label>\
						<div class='col-sm-10'>\
							<input class='form-control' id='question' type='text' name='questions["+sn+"].question'\
								placeholder='输入题目'>\
						</div>\
					</div>\
					<div class='form-group col-sm-12'>\
						<label for='answer' class='col-sm-2 control-label'>正确答案</label>\
						<div class='col-sm-10'>\
							<input class='form-control' id='answer' type='text' name='questions["+sn+"].answer'\
								placeholder='输入答案'>\
						</div>\
					</div>\
					<div class='form-group col-sm-12'>\
						<label for='anno' class='col-sm-2 control-label'>答案解析</label>\
						<div class='col-sm-10'>\
							<input class='form-control' id='anno' type='text' name='questions["+sn+"].anno'\
								placeholder='输入答案解析'>\
						</div>\
					</div>\
					<div class='form-group col-sm-12'>\
						<label for='score' class='col-sm-2 control-label'>分值</label>\
						<div class='col-sm-10'>\
							<input type='number' min='1' class='form-control' id='score'\
							name='questions["+sn+"].score' min='1'>\
						</div>\
					</div>\
				</div>\
				<div class='col-md-6'>\
					<div class='form-group col-sm-12' id='divOption'>\
						<div class='col-sm-2'>\
							<input class='form-control' id='answer' type='text' name='questions["+sn+"].options[0].optionName'\
								placeholder='选项'>\
						</div>\
						<div class='col-sm-10'>\
							<input class='form-control' id='detail' type='text' name='questions["+sn+"].options[0].details'\
								placeholder='输入选项内容'>\
						</div>\
					</div>\
					<div class='form-group col-sm-12' id='divOption'>\
						<div class='col-sm-2'>\
							<input class='form-control' id='option' type='text' name='questions["+sn+"].options[1].optionName'\
								placeholder='选项'>\
						</div>\
						<div class='col-sm-10'>\
							<input class='form-control' id='detail' type='text' name='questions["+sn+"].options[1].details'\
								placeholder='输入选项内容'>\
						</div>\
					</div>\
					<div class='form-group col-sm-12'>\
						<button type='button' id='addOption' class='btn btn-info btn-sm col-sm-3' >添加选项</button>\
					</div>\
				</div></div>";
	}
	$("#addtype1").click(function() {
		var question = $("<div class='panel panel-info' id='question'></div>");
		question.append("<div class='panel-heading'>\
					<strong class='panel-title'> 添加选择题 </strong>\
				</div>\
				<input type='hidden' name='questions["+sn+"].type' value='1'>");
		var panelbody=$("<div class='panel-body'></div>");
		panelbody.append(type1());
		question.append(panelbody);
		$("#show").append(question);
		sn=sn+1;
	});
	 $(document).on("click", "#addOption",function(event) {
		 length=$(this).parent().parent().children("#divOption").length;
		 console.log(length);
		 console.log(sn);
		$(this).parent().before("<div class='form-group col-sm-12' id='divOption'>\
						<div class='col-sm-2'>\
							<input class='form-control' id='option' type='text' name='questions["+(sn-1)+"].options["+length+"].optionName'\
								placeholder='选项'>\
						</div>\
						<div class='col-sm-10'>\
							<input class='form-control' id='detail' type='text' name='questions["+(sn-1)+"].options["+length+"].details'\
								placeholder='输入选项内容'>\
						</div>\
					</div>");
	});
	 
	 $("#addReading").click(function(){
		 var panel=$("<div class='panel panel-info' id='passage"+passage+"'></div>");
		 panel.append("<div class='panel-heading'>\
					<strong class='panel-title'> 添加阅读题 </strong>\
				</div>");
		 var panelbody=$("<div class='panel-body'><\div>");
		 panelbody.append("<textarea class='form-control' rows='16' placeholder='输入文章' name='passages["+passage+"]'></textarea>"
						+ "<h2>添加选择题</h2><input type='hidden' name='questions["+sn+"].type' value='0'>" +
								"<input type='hidden' name='questions["+sn+"].passage' value='"+passage+"'>"
						+ type1()
						+ "<div class='col-sm-12'>\
						<button type='button' class='btn btn-info btn-sm col-sm-2'\
							id='addType0'>添加选择题</button>\
					</div>");
		 panel.append(panelbody);
		 $("#show").append(panel);
		 sn=sn+1;
		 passage=passage+1;
	 });
	 
	 $(document).on("click", "#addType0",function(envent){
		 var pa=$(this).parent().parent().parent().attr('id').substring(7);
		 console.log(pa);
		 $(this).parent().before("<h2>添加选择题</h2><input type='hidden' value='0' name='questions["+sn+"].type'>" +
		 		"<input type='hidden' name='questions["+sn+"].passage' value='"+pa+"'>"+type1());
		 sn=sn+1;
	 })
});