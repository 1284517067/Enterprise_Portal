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
    
    <title>注册</title>
    
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
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>

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
   	<h1 class="text-center">用户注册</h1>
    <br>
   	<!-- 注册表单 -->
   	<form action="RegisterServlet" name="register" id="register" method="post" class="col-sm-6 offset-sm-3" onsubmit="return FormValidation()"">
   		<div class="form-group">
   		<label for="username">用户名：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-user"></span></span>
   		<input type="text" class="form-control" name="usr" id="usr" onblur="checkName()">
   		</div>
   		</div>
   		
   		<div class="form-group">
   		<label for="name">昵称：</label>
   		<div class="input-group"> 
   		<span class="input-group-text"><span class="fa fa-user-secret"></span></span>
   		<input type="text" class="form-control" name="name" id="name">
   		</div>
   		</div>
   		
   		<div class="form-group">
   		<label for="tel">电话号码：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-phone"></span></span>
   		<input type="text" class="form-control" name="tel" id="tel">
   		</div>
   		</div>
   		
   		
   		<div class="form-froup">
   		<label for="pwd">密码：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-address-card"></span></span>
   		<input type="password" class="form-control" name="pwd" id="pwd">
   		</div>
   		</div>
   		
   		<div class="form-group">
   		<label for="cpwd">请再输入一次密码：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-address-card-o"></span></span>
   		<input type="password" class="form-control" name="cpwd" id="cpwd">
   		</div>
   		</div>
   		
   		
   		<div class="form-group">
   		<label for="email">电子邮箱：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-envelope"></span></span>
   		<input type="email" class="form-control" name="email" id="email">
   		</div>
   		</div>
   		
   		<div class="form-group">
   		<label for="type">邀请码（选填）：</label>
   		<div class="input-group">
   		<span class="input-group-text"><span class="fa fa-bug"></span></span>
   		<input type="text" class="form-control" name="type" id="type">
   		</div>
   		</div>
   		
   		<div class="form-check">
   		<label class="form-check-label">
   		<input type="checkbox" class="form-check-input fa fa-check-square" id="agree" name="agree">同意<a href="">服务</a>与<a href="">隐私政策</a>
   		</label>
   		</div>
   		<button type="submit" class="btn btn-primary" onclick=return validate()) >注册</button>
   		
   	</form>
   	<br>
   	<br>
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
   <style>
.carousel-item img{
width: 100%;
height:50%;
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
        height: auto;
        
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
<script type="text/javascript">
$().ready(function()
{
	validate();
})
function validate(){

	$("#register").validate({
	
	errorElement:'span',
           errorPlacement: function(error, element) {
           error.appendTo(element.parent());
           },
	rules:{
		usr:{
			required:true,
			minlength:6,
			maxlength:20
		},
		name:{
			required:true,
			minlength:2,
			maxlength:15
		},
		pwd:{
			required:true,
			minlength:6,
			maxlength:20
		},
		cpwd:{
			required:true,
			minlength:6,
			maxlength:20,
			equalTo:"#pwd"
		},
		tel:{
			required:true,
			minlength:11,
			maxlength:11
		},
		email:{
			required:true,
			email:true
		},
		agree:"required"
	},
	messages:{
		usr:{
			required:"请输入用户名",
			minlength:"用户名长度不能小于6位",
			maxlength:"用户名长度不能大于20位"
		},
		name:{
			required:"请输入昵称",
			minlength:"昵称长度不能小于2位",
			maxlength:"昵称长度不能大于15位"
		},
		pwd:{
			required:"请输入密码",
			minlength:"密码长度不能小于6位",
			maxlength:"密码长度不能大于20位"
		},
		cpwd:{
			required:"请确认密码",
			minlength:"密码长度不能小于6位",
			maxlength:"密码长度不能大于20位",
			equalTo:"两次密码输入不一致"
		},
		tel:{
			required:"请输入电话号码",
			minlength:"请输入正确的电话号码",
			maxlength:"请输入正确的电话号码"
		},
		email:"请输入正确的邮箱",
		agree:""
	}
	})
}


function signout()
{
	alert("您已退出登录");
	window.location.href="SkipServlet?skip=logout"

	
}

</script>
</html>