$(function() {
	$('[data-toggle="popover"]').popover()
})

function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

//搜索智能框提示
function searchBox() {
	var searchBox = $.trim($("#search_Box").val());
	var postdata = {
			"searchBox" : searchBox,
		}
	$.ajax({
		url : "user_searchBox.action",
		type : "POST",
		data : postdata,
		dataType : "json",
		success : function(data) {
			$("#content_table_body").empty();
			setLocation();
			for (var i = 0; i < data.length; i++) {
				var tr = document.createElement("tr");
				var td = document.createElement("td");
				td.setAttribute("border", "0");
                td.setAttribute("bgcolor", "#FFFAFA");
                td.onmouseover = function () {
                    this.className = 'mouseOver';
                };
                td.onmouseout = function () {
                    this.className = 'mouseOut';
                };
                td.onmousedown=function(){
                    //当鼠标点击一个关联数据的时候,被选中的数据 自动填充到输入框里面
                    document.getElementById("search_Box").value=this.innerHTML;
                    //清除div边框
                    document.getElementById("popdiv").style.border="none";
                };
				var textNode = document.createTextNode(data[i]);
				td.appendChild(textNode);
				tr.appendChild(td);
				document.getElementById("content_table_body").appendChild(tr);
			}
		},
		error : function(result) {
			alert("程序错误！");
		}
	}) 
}

function setLocation() {
    //关联信息的显示位置
    var content = document.getElementById("search_Box");
    var width = content.offsetWidth;//输入框的宽度
    var left = content["offsetLeft"];//距离左边框的距离
    var top = content["offsetTop"] + content.offsetHeight;//距离顶部
    //获取显示数据div
    var popdiv = document.getElementById("popdiv");
    popdiv.style.border = "black 1px solid";
    popdiv.style.left = left + "px";
    popdiv.style.top = top + "px";
    popdiv.style.width = width + "px";
    document.getElementById("content_table").style.width = width + "px";
}