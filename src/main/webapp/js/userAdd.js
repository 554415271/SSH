$(function() {
	$('[data-toggle="popover"]').popover()
})

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

$(document).ready(function() {

	// 用户添加操作监听事件
	$("#add_submit").click(function() {
		addUser();
	})

	$("#add_image").click(function() {
		add_image();
	})

	$("#user_register").click(function() {
		$("#user_register_Status_code").html("注册");
	})

	$("#userAdd_a").click(function() {
		$("#user_register_Status_code").html("添加");
	})
})

// 添加“时光相册”图片
function add_image() {
	var formData = new FormData();
	var auid = $.trim($("#auid").val());
	var imageTitle = $.trim($("#imageTitle").val());
	var imageDesc = $.trim($("#imageDesc").val());
	var image = document.getElementById("image").files[0];
	imageNotNull(imageTitle, image, imageDesc); 
	formData.append("user.uid", auid);
	formData.append("userAlbum.imageTitle", imageTitle);
	formData.append("userAlbum.imageDesc", imageDesc);
	formData.append("userAlbum.image", image);
	if (image != null && image != "" && imageTitle != null && imageTitle != ""
			&& imageDesc != null && imageDesc != "") {
		$.ajax({
			url : "user_addImage.action",
			type : "POST",
			data : formData,
			dataType : "json",
			processData : false,
			contentType : false,
			async : false,
			success : function(data) {
				if (data == 1) {
					$("#imageTitleError").empty();
					var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图片添加成功！";
					$("#imageTitleError").html(html);
					window.location.href = "Time_album.jsp";
				} else if (data == -1) {
					$("#imageTitleError").empty();
					var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图片添加失败！";
					$("#imageTitleError").html(html);
					window.location.href = "Time_album.jsp";
				} else {
					var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;图片添加失败！";
					$("#imageTitleError").html(html);
				}
			},
			error : function(result) {
				alert("程序错误！");
			}
		})
	}
}

// 图片添加是否为空.
function imageNotNull(imageTitle, image, imageDesc) {
	if (image == null || image == "") {
		var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择一张图片！";
		$("#imageError").html(html);
		$("#imageTitleError").empty();
		$("#imageDescError").empty();
		username.focus();
		return false;
	}
	if (imageTitle == null || imageTitle == "") {
		var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入图片标题！";
		$("#imageTitleError").html(html);
		$("#imageError").empty();
		$("#imageDescError").empty();
		username.focus();
		return false;
	}
	if (imageDesc == null || imageDesc == "") {
		var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请添加描述！";
		$("#imageDescError").html(html);
		$("#imageError").empty();
		$("#imageTitleError").empty();
		password.focus();
		return false;
	}
	return true;
}

// 用户输入是否为空.
function saveNotNull(name, password) {
	if ((name == null || name == "") && (password == null || password == "")) {
		var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入用户名和密码！";
		$("#saveUsernameError").html(html);
		$("#savePasswordError").empty();
		username.focus();
		return false;
	}
	if (name == null || name == "") {
		var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入用户名！";
		$("#saveUsernameError").html(html);
		$("#savePasswordError").empty();
		username.focus();
		return false;
	}
	if (password == null || password == "") {
		var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入密码！";
		$("#savePasswordError").html(html);
		$("#saveUsernameError").empty();
		password.focus();
		return false;
	}
	return true;
}

// 添加用户
function addUser() {
	var formData = new FormData();
	var name = $.trim($("#username_add").val());
	var password = $.trim($("#password_add").val());
	saveNotNull(name, password);
	var selfIntroduction = $.trim($("#selfIntroduction").val());
	var user_register_Status_code = $("#user_register_Status_code").text();
	var arr = [];
	$("input[name='checkbox']:checked").each(function() {
		arr.push(this.value);
	});
	var hobby = JSON.stringify(arr);
	formData.append("user.username", name);
	formData.append("user.password", password);
	formData.append("user.selfIntroduction", selfIntroduction);
	formData.append("hobby", hobby);
	formData.append("user.Pic", document.getElementById("pic").files[0]);
	formData.append("user_register_Status_code", user_register_Status_code);
	if (name != null && name != "" && password != null && password != "") {
		$.ajax({
			url : "user_save.action",
			type : "POST",
			data : formData,
			dataType : "json",
			processData : false,
			contentType : false,
			async : false,
			success : function(data) {
				if (data == 1) {
					$("#savePasswordError").empty();
					var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加成功！";
					$("#saveUsernameError").html(html);
					window.location.href = "user_success.jsp";
				} else if (data == -1) {
					$("#savePasswordError").empty();
					var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入的用户已存在！";
					$("#saveUsernameError").html(html);
				} else {
					var html = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加失败！";
					$("#saveUsernameError").html(html);
				}
			},
			error : function(result) {
				alert("程序错误！");
			}
		})
	}
}