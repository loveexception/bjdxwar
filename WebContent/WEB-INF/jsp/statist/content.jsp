<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="${base}/favicon.ico">

<title>content</title>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- 导入jquery -->
<script src="${base}/rs/js/jquery.js"></script>

<link href="//cdn.bootcss.com/tether/1.3.6/css/tether.min.css" rel="stylesheet">
<script src="//cdn.bootcss.com/tether/1.3.6/js/tether.min.js"></script>
<script src="${base}/rs/js/bootstrap.min.js"></script>
<script src="${base}/rs/js/underscore.js"></script>
<!-- Bootstrap core CSS -->
<link href="${base}/rs/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">

    var pageNumber = 1;
    var pageSize = 10;
    var base = '<%=request.getAttribute("base")%>';
    var me = '<%=session.getAttribute("me")%>';
	function user_reload() {
		$.ajax({
			url : base + "/statist/querycontent",
			data : $("#user_query_form").serialize(),
			dataType : "json",
			success : function(data) {
				var list_html = "";
				console.log(data.list);
				var tpl = _.template($("#tpl").text());
				$("#user_list tbody").html(tpl(data.list));
			}
		});
	}
	$(function() {
		user_reload();
		$("#user_query_btn").click(function() {
			user_reload();
			return false;
		});
		$("#user_add_btn").click(function() {
			$.ajax({
				url : base + "/statist/addcontent",
				data : $("#user_add_form").serialize(),
				dataType : "json",
				success : function(data) {
					if (data.ok) {
						alert("添加成功");

						user_reload();
					} else {
						alert(data.msg);
					}
				}
			});
			return false;
		});

	});
	function user_update(contentId) {
		var count = prompt("请输入数量");
		if (count) {
			$.ajax({
				url : base + "/statist/updatecontent",
				data : {
					"id" : contentId,
					"count" : count
				},
				dataType : "json",
				success : function(data) {
					if (data.ok) {
						user_reload();
						alert("修改成功");
					} else {
						alert(data.msg);
					}
				}
			});
		}
	};
	function user_delete(contentId) {
		
		if (confirm()) {
			$.ajax({
				url : base + "/statist/deletecontent",
				data : {
					"id" : contentId
				},
				dataType : "json",
				success : function(data) {
					if (data.ok) {
						user_reload();
						alert("删除成功");
					} else {
						alert(data.msg);
					}
				}
			});
		}
	};

	_.templateSettings = {
		interpolate : /\{\{\=(.+?)\}\}/g,
		evaluate : /\{\{(.+?)\}\}/g

	};
</script>
<script type="text/template" id="tpl">
        {{_.each(obj,function(content){}}
            <tr> 
                <td> {{=content.id }} </td>
                <td> {{=content.content }} </td>
                <td> {{=content.count }} </td>
                <td><button onclick='user_update({{=content.id }});'>修改</button></td>
                <td><button onclick='user_delete({{=content.id }});'>删</button></td>
            </tr>
        {{})}}
    </script>
<!-- Custom styles for this template -->
<link href="${base}/rs/exp/dashboard/dashboard.css" rel="stylesheet">
</head>

<body>
	<nav
		class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
		<button class="navbar-toggler navbar-toggler-right hidden-lg-up"
			type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<a class="navbar-brand" href="${base}/user/main">主页</a>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active" id="login_div"></li>
				<li class="nav-item"></li>
			</ul>
			<a class="btn btn-outline-success my-2 my-sm-0"
				href="${base}/user/logout">退出</a>
			<!--

        -->
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link"
						href="${base}/user/main">管理员</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${base}/person/main">用户</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${base}/topic/main">新闻</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${base}/plan/main">计划</a></li>
					<%-- <li class="nav-item"><a class="nav-link"
						href="${base}/statist/main">统计</a></li> --%>
						 <li class="nav-item"><a class="nav-link "
						 href="${base}/statist/canvas">按天统计表</a></li> 
						<li class="nav-item"><a class="nav-link  active" 
						href="${base}/statist/content">评论库</a></li>
				</ul>

			</nav>

			<main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
			<h1>文案库</h1>
			<p>
			<form class="form-inline mt-2 mt-md-0" action="#"
				id="user_query_form">
				条件<input type="text" class="form-control mr-sm-2" name="content">
				<!--每页 -->
				<input type="hidden" name="pageSize" value="100">
				<button id="user_query_btn" class="btn btn-outline-success my-2 my-sm-0">
					<span  class="md-button-label">查询</span>
				</button>
			</form>
			</p>
			<h2>列表</h2>
			<div class="table-responsive">
				<table class="table table-striped" id="user_list">
					<thead>
						<tr>
							<th>#</th>
							<th>内容</th>
							<th>数量</th>
							<th>操作</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			</main>
		</div>

		<div id="user_add" class="row">
			<nav class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">


				<form class="form-inline mt-2 mt-md-0" action="#" id="user_add_form">
					<div class="form-group">
						<input type="text" name="content" placeholder="内容">
					</div>
					<div class="form-group">
						<input type="text" name="count" placeholder="数量">
					</div>

					<!--每页 -->

					<button id="user_add_btn" class="btn btn-outline-success my-2 my-sm-0">
						<span  class="md-button-label">新增</span>
					</button>
				</form>
			</nav>
		</div>

	</div>

</body>
</html>
