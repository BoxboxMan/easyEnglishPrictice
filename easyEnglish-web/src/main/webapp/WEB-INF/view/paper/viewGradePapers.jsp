<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="../adminStatic/js/viewGradePapers.js"></script>
</script>
<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">已完成的试卷</h3>
		</div>
		<div class="panel-body">
			<table class="table table-bordered">
				<thead>
					<tr align="center">
						<th style="text-align: center;">试卷名</th>
						<th style="text-align: center;">完成人数</th>
						<th style="text-align: center;">平均分</th>
						<th style="text-align: center;">未评卷数</th>
					</tr>
				</thead>
				<tbody id="t"></tbody>
			</table>
		</div>
	</div>

</div>