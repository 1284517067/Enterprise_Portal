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
    
    <title>首页</title>
    
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
  </head>
  
  <body class="bg-dark">
 
   <%
  		String mess = (String)session.getAttribute("message");
  		if("".equals(mess)||mess==null)
  		{
  		}
  		else{
   %>
   <script type="text/javascript">alert("<%=mess%>")</script>
  	<%
  	
  			session.setAttribute("message", "");
  			} %>
  <div class="container-fluid ">
 
   <!-- 页头 -->
	<nav class="navbar navbar-expand-sm  navbar-dark" role="navigation">
 	 <div class="container-fluid">
      <div class="navbar-header ">
      <a class="navbar-brand" href="SkipServlet?skip=OfficalwWebSide">品牌Logo</a>
    </div>
  <% if(session.getAttribute("usr") == null ){ %>
 	  <div class="navbar-right">
  	 <a class="btn btn-dark " href="SkipServlet?skip=register"  id="logout"><span class="fa fa-user-plus"></span> 注册</a>
     <a class="btn btn-dark " href="SkipServlet?skip=login"  id="logout"><span class="fa fa-sign-in"></span> 登录</a>
 	  </div>
	<% } 
         else 
      {%> 
      	 <div class="collapse navbar-collapse justify-content-end">
  		 <p class="navbar-text navbar-right text-white">您好！<%=u.getUserType() %> ：<%=u.getName() %></p>
 	 	 &nbsp&nbsp&nbsp
 	 	 <button class="btn btn-dark" onclick=signout() id="logout"><span class="fa fa-sign-out"></span> 退出登录</button>
 	 	 </div>
<%} %>


 	 </div>
	</nav>
   	<!-- 页头结束 -->
 
    <!-- 导航栏 -->
    <nav class="navbar navbar-expand-sm  navbar-dark">
   	
   	
   	<ul class="navbar-nav navbar-pills col-sm-4" >
   		<li class="nav-item">
   		<!-- 新闻展示 -->
   		<a class="nav-link" href="SkipServlet?skip=Activity" id="newsshow">最新活动</a> 
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
  <div id="bg">
   <!-- 轮播界面 -->
   <div id="demo" class="carousel slide" data-ride="carousel">
   
   <!-- 指示符 -->
   <ul class="carousel-indicators">
   	<li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
   </ul>
   
   <!-- 轮播图片 -->
   <div class="carousel-inner">
    <div class="carousel-item active">
      <a><img id="img" src="1.png"></a>
    </div>
    <div class="carousel-item">
      <a><img id="img" src="2.png"></a>
    </div>
    <div class="carousel-item">
      <a><img id="img" src="4.png"></a>
    </div>
  </div>

	<!-- 左右切换按钮 -->
	  <a class="carousel-control-prev" href="#demo" data-slide="prev">
	    <span class="carousel-control-prev-icon"></span>
	  </a>
	  <a class="carousel-control-next" href="#demo" data-slide="next">
	    <span class="carousel-control-next-icon"></span>
	  </a>
   </div>

   <!-- 轮播框结束 -->
   
   <br>
   <br>
   <!-- 次级导航栏 -->
   <nav class="navbar navbar-expand-sm " >
	  <div class="container-fluid ">
	  <ul class="nav navbar-nav justify-content-center " style="margin:0 auto;">
	  <li class="nav-item ">
	  	<a class="nav-link" >
	  		<div class="card  text-white mx-auto" id="card">
	  		<div class="card-body">
	  		<h6 class="card-title">免费套餐</h6>
	  		<p class="card-text">核心产品免费试用</p>
	  		</div>
	  		</div>
	  	</a>
	  </li>
	    <li class="nav-item">
	  	<a class="nav-link" >
	  		<div class="card  text-white" id="card">
	  		<div class="card-body">
	  		<h6 class="card-title">售前咨询</h6>
	  		<p class="card-text">为您提供一对一服务</p>
	  		</div>
	  		</div>
	  	</a>
	  </li>
	
	   <li class="nav-item">
	  	<a class="nav-link" >
	  		<div class="card  text-white" id="card">
	  		<div class="card-body">
	  		<h6 class="card-title">短信服务</h6>
	  		<p class="card-text">免费试用100条</p>
	  		</div>
	  		</div>
	  	</a>
	  </li>
	  
	   <li class="nav-item">
	  	<a class="nav-link" >
	  		<div class="card  text-white" id="card">
	  		<div class="card-body">
	  		<h6 class="card-title">售后服务</h6>
	  		<p class="card-text">为您提供贴心的售后服务</p>
	  		</div>
	  		</div>
	  	</a>
	  </li>
	  <li class="nav-item">
	  	<a class="nav-link" >
	  		<div class="card  text-white" id="card">
	  		<div class="card-body">
	  		<h6 class="card-title">送货上门</h6>
	  		<p class="card-text">为您提供免费的送货上门服务</p>
	  		</div>
	  		</div>
	  	</a>
	  </li>
	  </ul>
	  </div>
	  </nav>
	  </div>
	<!-- 次级导航栏结束 -->
	  
	<!-- 页尾  -->
	
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
  <style>
  #card{
  	background-color: rgba(0,0,0,0);
  }
   #demo{
  	width:100%;
  	height:50%;
  }
  
  #logout{
  	background-color: rgba(0,0,0,0);
  }
  
 #bg {
 background-image:url('6.jpg');
background-size:100%,100%;
 background-repeat:repeat-x;
 }
.carousel-item img{
width: 100%;
height:auto;
}
.container-fluid{
 padding-right: 0px;
  padding-left: 0px; 
  }

    html {
    position: relative;
    min-height: 100%;
    }
    body {
        margin-bottom: 60px;
    }
    .footer {
        position: absolute;
        bottom: 0;  width: 100%;
        /* Set the fixed height of the footer here */
        height: 60px;
        
}

</style>
  <script type="text/javascript">
function signout()
{
	alert("您已退出登录");
	window.location.href="SkipServlet?skip=logout"

	
}
</script>
</html>
