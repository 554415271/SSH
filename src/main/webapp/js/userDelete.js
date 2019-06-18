$(function() {
	$('[data-toggle="popover"]').popover()
})

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

//删除用户
function delect(obj) {
	var uid=obj.parentNode.getAttribute("id").substr(6);
	var username=$("#username" + obj.parentNode.getAttribute("id").substr(6)).text();
	$("#delete" + uid).click(function() {
		var postdata = {
			"user.uid" : uid,
		}
		var flag = confirm("确定要删除  " + username + "  的信息吗？");
		if (flag) {
			$.ajax({
				url : "user_delete.action",
				type : "POST",
				data : postdata,
				dataType : "json",
				success : function(data) {
					if (data == 1) {
						getUserInfo();
					} else if (data == -1) {
						alert("删除操作错误！");
					} else {
						alert("删除操作错误！");
					}
				},
				error : function(result) {
					alert("程序错误！");
				}
			})
		}
	})
}

//查询所有用户信息
function getUserInfo() {
	$("#userFindAll_tbody").empty();
	$.ajax({
		url : "user_findAll.action",
		type : "POST",
		dataType : "json",
		success : function(data) {
			for (var i = 0; i < data.length; i++) {
				var tr = document.createElement("tr");
				for (var j = 0; j < 6; j++) {
					var td = document.createElement("td");
					if (j == 0) {
						td.id="username"+ data[i].user.uid;
						var textNode = document
								.createTextNode(data[i].user.username);
						td.appendChild(textNode);
					}
					if (j == 1) {
						td.id="password"+ data[i].user.uid;
						var textNode = document
								.createTextNode(data[i].user.password);
						td.appendChild(textNode);
					}
					if (j == 2) {
						td.id="hobbyList"+ data[i].user.uid;
						var textNode = document
								.createTextNode(data[i].hobbyList);
						td.appendChild(textNode);
					}
					if (j == 3) {
						td.id="selfIntroduction"+ data[i].user.uid;
						var textNode = document
								.createTextNode(data[i].user.selfIntroduction);
						td.appendChild(textNode);
					}
					if (j == 4) {
						var a = document.createElement("a");
						a.id = "delete" + data[i].user.uid;
						td.appendChild(a);
					}
					if (j == 5) {
						td.id = "parentNodeUpdate" + data[i].users_Hobby.hid;
						var a = document.createElement("a");
						a.id = "update" + data[i].user.uid;
						a.href = "#userUpdate";
						a.dataset.toggle = "modal";
						td.appendChild(a);
					}
					tr.appendChild(td);
				}
				document.getElementById("userFindAll_tbody").appendChild(tr);
				$("#delete" + data[i].user.uid)
						.append("<label class=\"glyphicon glyphicon-trash\" onclick=\"delect(this)\"></label>");
				$("#update" + data[i].user.uid)
						.append("<label class=\"glyphicon glyphicon-pencil\" onclick=\"update(this)\"></label>");
			}
		},
		error : function(result) {
			alert("程序错误！");
		}
	})
}