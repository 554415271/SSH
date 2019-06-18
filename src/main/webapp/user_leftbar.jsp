<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<nav class="navbar navbar-default" id="navbar">
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header" align="center">
			<a class="navbar-brand" href="#">
			<label class="glyphicon glyphicon-user"><br><s:property value="#session.userAndHobbyLogin.user.username"/></label>
			</a>
		</div>
	
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1" align="center">
			<ul class="nav navbar-nav">
				<li>
					<a id="findAll_submit">
						<label class="glyphicon glyphicon-search" style="font-size: 22px;"><br><span>查询</span></label>
					</a>
				</li>
				<li>
					<a href="#userAdd" data-toggle="modal" data-whatever="@mdo" id="userAdd_a">
						<label class="glyphicon glyphicon-plus-sign" style="font-size: 22px;"><br><span>添加</span></label>
					</a>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false" id="hobby_a">
						<label class="glyphicon glyphicon-heart" style="font-size: 22px;"><br><span>爱好</span></label>
						<span class="caret"></span>
					</a>
					<!-- 隐藏爱好 -->
					<div style="display: none;" id="hobbylist"><s:property value="#session.userAndHobbyLogin.listArray"/></div>
					<ul class="dropdown-menu" id="hobbyli"></ul>
				</li>
			</ul>
			<form class="navbar-form navbar-left" style="text-align: left;">
				<div class="form-group">
					<input type="text" class="form-control" id="search_Box" onkeyup="searchBox()" placeholder="输入要搜索的内容">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>	 
				<div id="popdiv">
					<table id="content_table">
						<tbody id="content_table_body">
							<!-- 动态查询出来的数据,显示在此 -->
						</tbody>
					</table>
				</div>
			</form>
			<div class="navbar-form navbar-left dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">
					<label class="glyphicon glyphicon-th-list" style="font-size: 18px;"><br><span>功能</span></label>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="Time_album.jsp"><label class="glyphicon glyphicon-film"></label>&nbsp;&nbsp;时光相册</a></li>
				</ul>
			</div>
			<ul class="nav navbar-nav navbar-right" id="navbar-right">
				<li>
					<a id="userA" tabindex="0" class="btn btn-lg btn-danger" role="button"
					data-toggle="popover" data-trigger="focus" title="自我介绍"
					data-content="<s:property value="#session.userAndHobbyLogin.user.selfIntroduction"/>">
					<s:property value="#session.userAndHobbyLogin.user.username"/></a>
				</li>
				<li><a href="javascript:history.go(-1);">上一页</a></li>
				<li><a href="javascript:history.go(+1);">下一页</a></li>
				<li class="dropdown" id="userPic">
					<a href="#">
						<img id="touxiankuan" src="icon/zhuti__touxiangkuang.svg">
						<img id="touxian" src="headImage/<s:property value="#session.userAndHobbyLogin.user.PicFileName"/>" alt="头像">
					</a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
	</nav>
</nav>