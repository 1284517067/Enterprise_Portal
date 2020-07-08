<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="bean.*" %>
<jsp:useBean id="UserBean" type="bean.UserBean" class="bean.UserBean"></jsp:useBean>
<%UserBean u = (UserBean)session.getAttribute("usr"); %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员控制台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
 
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
 <!-- Bootstrap字体图标 --> 
 <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> 
  <link rel="stylesheet" href="assets/css/jquery.mCustomScrollbar.min.css" />
  <link rel="stylesheet" href="assets/css/custom.css">
  </head>
  </head>
  
  <body>
 	<div class="container-fluid">
 	
 	<!-- 页头 -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="SkipServlet?skip=OfficalwWebSide">品牌Logo</a>
    </div>
 	  
  <div class="collapse navbar-collapse justify-content-end">
  		 <p class="navbar-text navbar-right text-white">您好！<%=u.getUserType() %> ：<%=u.getName() %></p>
 	 	 <button class="btn btn-dark" onclick=signout()><span class="fa fa-sign-out"></span> 退出登录</button>
 	 	 </div>
  

  </div>
</nav>
   	<!-- 页头结束 -->
 
    <!-- 导航栏 -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
   	
   	
   	<ul class="navbar-nav navbar-pills col-sm-4" >
   		<li class="nav-item">
   		<!-- 新闻展示 -->
   		<a class="nav-link " href="SkipServlet?skip=Activity" id="newsshow">最新活动</a> 
   		</li>
   		<li class="nav-item">
   		<!-- 产品介绍 -->
   		<a class="nav-link " href="SkipServlet?skip=Products" id="newsshow">产品</a> 
   		</li>
   		<li class="nav-item">
   		<!-- 企业介绍 -->
   		<a class="nav-link " href="SkipServlet?skip=Introduce" id="newsshow">企业介绍</a> 
   		</li>
   		<li class="nav-item">
   		<!-- 客户留言 -->
   		<a class="nav-link " href="SkipServlet?skip=Message" id="newsshow">在线留言</a> 
   		</li>
   		<li class="nav-item">
   		<!-- 技术支持 -->
   		<a class="nav-link " href="SkipServlet?skip=Support" id="newsshow">技术支持</a> 
   		</li>
   	</ul>
   </nav>
   <!-- 导航栏结束 -->
 
 <br>
 	<!-- 侧边栏 -->
 	<div class="row">
 	<div class="col-sm-2">
 		<div id="collapse">
 		<div class="card bg-secondary text-white">
 			<div class="card-header">
 				<a class="card-link text-white" data-toggle="collapse" href="#newsC">新闻管理</a>
 			</div>
 			<div id="newsC" class="collapse" data-parent="#collapse">
 				<div class="card-body">
 					<a class="card-link text-white small" href="NewsServlet?type=add">添加</a>
 				</div>
 				<div class="card-body">
 					<a class="card-link text-white small" href="NewsServlet?type=update1">修改</a>
 				</div>	
 				<div class="card-body">
 					<a class="card-link text-white small" href="NewsServlet?type=delete">删除</a>
 				</div>
 			</div>
 		</div>
 		<div class="card bg-secondary text-white">
 			<div class="card-header">
 				<a class="collapsed card-link text-white" data-toggle="collapse" href="#PC">产品管理</a>
 			</div>
 			<div id="PC" class="collapse" data-parent="#collapse">
 				<div class="card-body">
 					<a class="card-link text-white small" href="ProductServlet?type=add">添加</a>
 				</div>
 				<div class="card-body">
 					<a class="card-link text-white small" href="ProductServlet?type=update">修改</a>
 				</div>	
 				<div class="card-body">
 					<a class="card-link text-white small" href="ProductServlet?type=delete">删除</a>
 				</div>
 			</div>
 		</div>
 		<div class="card bg-secondary text-white">
 			<div class="card-header">
 				<a class="collapsed card-link text-white" data-toggle="collapse" href="#PTC">产品类型管理</a>
 			</div>
 			<div id="PTC" class="collapse" data-parent="#collapse">
 				<div class="card-body">
 					<a class="card-link text-white small" href="TypeServlet?type=add">添加</a>
 				</div>
 				<div class="card-body">
 					<a class="card-link text-white small" href="TypeServlet?type=update">修改</a>
 				</div>	
 				<div class="card-body">
 					<a class="card-link text-white small" href="TypeServlet?type=delete">删除</a>
 				</div>
 			</div>
 		</div>
 		
 		
 		
 		</div>
 
 	</div>
 	<!-- 侧边栏结束 -->
 	<!-- 欢迎页面 -->
 	<div class="col-sm-10">
 	<br><br><br><br>
 	<h3 class="text-center">欢迎使用本后台管理页面</h3>
 	</div>
 	<!-- 欢迎页面结束 -->
 	
 	<!-- 页尾  -->
	<br>
	<div class="container">
	<nav class="footer navbar navbar-expand-sm bg-dark navbar-dark fixed-bottom" style="margin:0 auto;margin-left:auto;margin-right:auto;">
	<table class="col-sm-10 offset-sm-2" >
	<tr>
		<th class="text-muted">支持与服务</th>
		<th class="text-muted">账户管理</th>
		<th class="text-muted">快速入口</th>
		<th class="text-muted">资源与社区</th>
	</tr>
	<tr>
		<td class="small"><a class="text-muted">联系我们</a></td>
		<td class="small"><a href="SkipServlet?skip=AdminControlTable" class="text-muted">管理员控制台</a></td>
		<td class="small"><a class="text-muted">敬请期待</a></td>
		<td class="small"><a class="text-muted">帮助文档</a></td>
	</tr>
	<tr>
		<td class="small"><a class="text-muted">支持计划</a></td>
		<td class="small"><a class="text-muted">账号管理</a></td>
		<td></td>
		<td class="small"><a class="text-muted">社区</a></td>
	</tr>	
	<tr>
		<td class="small"><a class="text-muted">咨询与设计</a></td>
		
	</tr>
	
	</table>
	</nav> 
	</div>

	<!-- 页尾结束 -->
 	</div>
  </body>
  <script>
   
</script>
<script type="text/javascript">
function signout()
{
	alert("您已退出登录");
	window.location.href="SkipServlet?skip=logout"

	
}
</script>
</html>
