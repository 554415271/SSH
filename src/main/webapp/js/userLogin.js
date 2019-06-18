$(function() {
	$('[data-toggle="popover"]').popover()
})

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

$(document).ready(function() {
 
	//用户输入是否为空.
	function loginNotNull(name,password) {
		if ((name == null || name == "") && (password == null || password == "")){
			var html="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入用户名和密码！";
			$("#usernameError").html(html);
			$("#passwordError").empty();
			username.focus();
			return false;
		}
		if (name == null || name == "") {
			var html="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入用户名！";
			$("#usernameError").html(html);
			$("#passwordError").empty();
			username.focus();
			return false;
		}
		if (password == null || password == "") {
			var html="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入密码！";
			$("#passwordError").html(html);
			$("#usernameError").empty();
			password.focus();
			return false;
		}
		return true;
	}

	//用户登录校验.
	$("#login_submit").click(function() {
		
		var name = $.trim($("#username").val());
		var password = $.trim($("#password").val());
		loginNotNull(name,password);
		var postdata = {
			"user.username" : name,
			"user.password" : hex_md5(password),
		}
		if (name != null && name != "" && password != null && password != "") {
			$.ajax({
				url : "user_login.action",
				type : "GET",
				dataType : "json",
				data : postdata,
				success : function(data) {
					if (data == 1) {
						$("#passwordError").empty();
						var html="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录成功！";
						$("#usernameError").html(html);
						window.location.href = "user_success.jsp";
					} else if (data == -1) {
						var html="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名不存在！";
						$("#passwordError").empty();
						$("#usernameError").html(html);
					} else if (data == -2) {
						var html="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入的密码不正确！";
						$("#usernameError").empty();
						$("#passwordError").html(html);
					} else {
						var html="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录失败！";
						$("#usernameError").html(html);
					}
					/*var dataObj = eval("(" + data + ")");*/
				},
				error : function(result) {
					alert("错误");
				}
			})
		}
	})
})