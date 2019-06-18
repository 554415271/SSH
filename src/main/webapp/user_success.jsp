<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>用户管理界面</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/user.css" type="text/css">
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="//apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">
 
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userFindAll.js"></script>
<!-- 引入添加或注册用户操作的JS函数 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userAdd.js"></script>
<!-- 引入修改用户操作的JS函数 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userUpdate.js"></script>
<!-- 引入删除用户操作的JS函数 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userDelete.js"></script>
<!-- 引入搜索智能框提示的JS函数 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/searchBox.js"></script>

</head>
<body>
	<jsp:include page="user_leftbar.jsp"></jsp:include>
	<div class="row">
		<div class="col-xs-2 col-sm-2">
			<div class="col-sm-12" id="success_leftBar">wo<br><br><br><br></div> 
			<div class="col-sm-12" id="success_leftBar">ni<br><br><br><br></div>
		</div>
		<div class="col-xs-6 col-sm-8"> 
			 <!--  用户信息表 -->
			 <jsp:include page="userInfoTable.jsp"></jsp:include> 
		</div>
		<!-- Optional: clear the XS cols if their content doesn't match in height -->
		<div class="clearfix visible-xs-block"></div>
		<div class="col-xs-2 col-sm-2" id="success_leftBar"><br><br><br><br></div>
	</div>
	<!-- <div class="row">
		<div class="col-xs-12 col-sm-2 col-md-8"> 
			.col-md-8
		</div>
		<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
	</div> --> 
	<jsp:include page="user_add.jsp"></jsp:include> 
	<jsp:include page="user_update.jsp"></jsp:include>
</body> 
</html>