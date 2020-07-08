<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
	String preURL = request.getRequestURL().toString();
	session.setAttribute("preURL", preURL);
 %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set target="${pageContext.request}"
         property="characterEncoding" value="UTF-8"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
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
<!--jQuery校验  -->

<link rel="stylesheet" href="https://cdn.staticfile.org/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css">

<script src="https://cdn.staticfile.org/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdn.staticfile.org/bootstrap-validator/0.5.3/js/language/zh_CN.min.js"></script>

<style type="text/css">
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
        height: auto;
        background-color: #f5f5f5;
}
span.error {
    display:block;
    /*float:left;*/
    font-size:11px;
    text-align:left;
    margin-left:5px;
    padding-left:5px;
    width:50px;
    color:red;
}
</style>
  </head>
  
  <body>
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
    <div class="container-fluid">
    <!-- 页头 -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark" role="navigation">
  	<div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="SkipServlet?skip=OfficalwWebSide">品牌Logo</a>
    </div>
    <div class="navbar-right">
   <a class="btn btn-dark" href="register.jsp"><span class="fa fa-user-plus"></span> 注册</a>
   <a class="btn btn-dark" href="login.jsp"><span class="fa fa-sign-in"></span> 登录</a>
   </div>
 	</div>
	</nav>
   	<!-- 页头结束 -->
   	
   	<!-- 导航栏 -->
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
   	
     <ul class="navbar-nav navbar-pills col-sm-4" >
   		<li class="nav-item">
   		<!-- 新闻展示 -->
   		<a class="nav-link active" href="SkipServlet?skip=Activity" id="newsshow">最新活动</a> 
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
  <br>
   
   <!-- 登录栏 -->
   
   <div class="card col-sm-3 offset-sm-8">
   <div class="card-body">
   <form class="" action="LoginServlet" method="post" id="login" name="login">
   <input type="hidden" name="method" value="login">
   <div class="form-group">
   		<label for="username">用户名：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-user"></span></span>
   		<input type="text" class="form-control" name="username" id="username">
   		</div>
   		</div>
   
   <div class="form-froup">
   		<label for="pwd">密码：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-address-card"></span></span>
   		<input type="password" class="form-control" name="pwd" id="pwd">
   		</div>
   		</div>
   		<br>
   		<a href="" class="small" style="float:right">忘记密码</a>
   		
   		<br>
   	<button class="btn btn-primary" type="submit">登录</button>
   </form>
   </div>
   </div>
     <!-- 登录栏结束 -->
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
<script type="text/javascript">
function signout()
{
	alert("您已退出登录");
	window.location.href="SkipServlet?skip=logout"

	
}
</script>
  
</html>
