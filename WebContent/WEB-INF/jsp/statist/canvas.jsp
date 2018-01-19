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

<title>statist</title>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- 导入jquery -->
<script src="${base}/rs/js/jquery.js"></script>

<link href="//cdn.bootcss.com/tether/1.3.6/css/tether.min.css" rel="stylesheet">
<script src="//cdn.bootcss.com/tether/1.3.6/js/tether.min.js"></script>
<script src="${base}/rs/js/bootstrap.min.js"></script>
<script src="${base}/rs/js/underscore.js"></script>
<script src="${base}/rs/js/Chart.js"></script> 


<!-- Bootstrap core CSS -->
<link href="${base}/rs/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">

    var pageNumber = 1;
    var pageSize = 50;
    var base = '<%=request.getAttribute("base")%>';
    var me = '<%=session.getAttribute("me")%>';
    function user_reload1() {
    	$.ajax({
    		url : base + "/statist/querycomment",
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
    	user_reload1();


    });
   function statisInfo (me){
		console.log(me);
		var day=$(me).parents("tr").attr("data");
		window.location.href = "${base}/statist/main?ymd="+day;

	   
   }
    _.templateSettings = {
    		interpolate : /\{\{\=(.+?)\}\}/g,
    		evaluate : /\{\{(.+?)\}\}/g

    	};
</script>
    <script type="text/template" id="tpl">
        {{_.each(obj,function(statist){}}
            <tr data="{{=statist.ymd }}" > 
                <td> {{=statist.ymd }} </td>
                <td> {{=statist.pageview }} </td>
				<td> {{=statist.userview }}</td>
				
            </tr>
        {{})}}
    </script>
<!-- Custom styles for this template -->
<link href="${base}/rs/exp/dashboard/dashboard.css" rel="stylesheet">
</head>
<!-- <td><button  class="statist_info" onclick="statisInfo(this)" >查看</button></td> -->
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
					<li class="nav-item"><a class="nav-link active"
						href="${base}/statist/canvas">按天统计表</a></li>
						<li class="nav-item"><a class="nav-link"
						href="${base}/statist/content">评论库</a></li>
				</ul>

			</nav>

			<main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
			<h2>列表</h2>
			<div class="table-responsive">
				<table class="table table-striped" id="user_list">
					<thead>
						<tr>
							<th>时间</th>
							<th>总阅读数</th>
							<th>总评论数</th>
							<!-- <th>操作</th> -->
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			
			
			

			</main>
		</div>


	</div>

</body>
</html>
