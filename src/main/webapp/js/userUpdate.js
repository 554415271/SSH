$(function() {
	$('[data-toggle="popover"]').popover()
})

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

//返回要修改用户的信息
function update(obj){
	var uid=obj.parentNode.getAttribute("id").substr(6);
	var hid=obj.parentNode.parentNode.getAttribute("id").substr(16);
	$("#update" + uid).click(function() {
		$("#usernameUpdate").val($("#username" + uid).text());
		$("#passwordUpdate").val($("#password" + uid).text());
		$("#selfIntroductionUpdate").val($("#selfIntroduction" + uid).text());
		$("#uid").html(uid);
		$("#hid").html(hid);
	})
}

$(document).ready(function() {
	
	//用户修改操作监听事件
	$("#update_submit").click(function() {
		updateUser();
	})
	
	//修改用户
	function updateUser() {
		var uid = $("#uid").text();
		var hid = $("#hid").text();
		var name = $.trim($("#usernameUpdate").val());
		var password = $.trim($("#passwordUpdate").val());
		var selfIntroduction = $.trim($("#selfIntroductionUpdate").val());
		var arr = [];
		$("input[name='checkbox']:checked").each(function() {
			arr.push(this.value);
		});
		var hobby = JSON.stringify(arr);
		var postdata = {
			"user.uid" : uid,
			"users_Hobby.hid" : hid,
			"user.username" : name,
			"user.password" : password,
			"user.selfIntroduction" : selfIntroduction,
			"hobby" : hobby,
		}
		$.ajax({
			url : "user_update.action",
			type : "POST",
			data : postdata,
			dataType : "json",
			success : function(data) {
				if (data == 1) {
					window.location.reload();
					opener.location.reload();
				} else if (data == -1) {
					alert("修改操作错误！");
				} else {
					alert("修改操作错误！");
				}
			},
			error : function(result) {
				alert("程序错误！");
			}
		})
	}
})