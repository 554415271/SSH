<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>用户登录界面</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/user.css" type="text/css">
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
 
<script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/js/md5.js"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userLogin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userAdd.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="jumbotron">
		<h1>SSH练习之用户管理!</h1>
		<p>这是wo在大二期间无聊时候练习所写。</p>
		<p>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal" data-whatever="@mdo"> 
				用户登录
			</button>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#userAdd" data-whatever="@mdo" id="user_register">注册
			</button>
		</p>
	</div>
	<jsp:include page="user_add.jsp"></jsp:include>
	<jsp:include page="user_login.jsp"></jsp:include>  
</body>
</html>