<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%! int i = 1;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>时光相册</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/user.css" type="text/css">
<link href="${pageContext.request.contextPath }/css/bootstrap.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/bootstrap/3.2.0/css/bootstrap.min.css">

<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/userFindAll.js"></script>
<!-- 引入添加或注册用户操作的JS函数 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/userAdd.js"></script>

</head>
<body style="background-color: #e8e8e8;">
	<jsp:include page="user_leftbar.jsp"></jsp:include>
	<div class="masonry">
		<s:iterator value="#session.userAndHobbyLogin.user.userAlbum">
			<div class="Ta_item">
				<div class="row">
				  <div class="col-sm-12 col-md-12">
				    <div class="thumbnail">
				      <img src="Time_album/<s:property value="imageFileName"/>">
				      <div class="caption">
				        <h3><s:property value="imageTitle"/></h3>
				        <p><s:property value="imageDesc"/></p>
				        <p>
					        <a href="#" class="btn btn-primary" role="button">修改</a> 
					        <a href="#" class="btn btn-default" role="button">删除</a>
				        </p>
				      </div>
				    </div>
				  </div>
				</div>
			</div>
		</s:iterator>
		<div class="Ta_item">
			<a href="#add_pictures" data-toggle="modal" data-whatever="@mdo">
				<img src="img/add_pictures.svg" id="add_pictures_a">
		    </a>
	    </div>
	</div>
	<div id="Album_left">
	<div id="Album_Carousel" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators" id="image_Indicators">
			<li data-target="#album_Carousel" data-slide-to="0"
				class="active"></li>
			<s:iterator value="#session.userAndHobbyLogin.user.userAlbum">
				<li data-target="#album_Carousel" data-slide-to=<%=i %>></li><%i++; %>
	        </s:iterator>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="img/Time.jpg" class="center-block">
				<div class="carousel-caption">时光相册</div>
			</div>
			<s:iterator value="#session.userAndHobbyLogin.user.userAlbum">
			<div class="item">
				<img src="Time_album/<s:property value="imageFileName"/>" class="center-block">
				<div class="carousel-caption"><s:property value="imageTitle"/></div>
			</div>
			</s:iterator>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#album_Carousel"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#album_Carousel"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	</div>
	<div id="Album_right"></div>
	<jsp:include page="add_pictures.jsp"></jsp:include> 
</body>
</html>