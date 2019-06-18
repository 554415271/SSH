<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
 
<div class="modal fade" id="userAdd" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">添加用户</h4>
			</div>
			<div class="modal-body">
				<form enctype="multipart/form-data">
				<div class="form-group">
					<!-- 隐藏添加用户状态值，判定当前操作为注册or添加 -->
					<div style="display: none;" id="user_register_Status_code"></div>
					
					<label for="recipient-name" class="control-label">Name</label>
					<label id="saveUsernameError" style="color: red;"></label>
					<s:textfield id="username_add" class="form-control" placeholder="请输入姓名" />
				</div>
				<div class="form-group">
					<label for="message-text" class="control-label">Password</label>
					<label id="savePasswordError" style="color: red;"></label>
					<s:textfield id="password_add" class="form-control" placeholder="请输入密码" />
				</div>
				<div class="form-group">
					<label for="message-text" class="control-label">Self Introduction</label>
					<textarea id="selfIntroduction" class="form-control" rows="3" maxlength="50" placeholder="在此输入不大于50个字符的自我介绍"></textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">头像</label>
					<input type="file" class="form-control" id="pic" name="user.Pic"/> 
				</div>
				<div class="checkbox" style="text-align: center;">
					<label> 
					<input type="checkbox" name="checkbox" value="电影"/>电影
					</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label> 
					<input type="checkbox" name="checkbox" value="音乐"/>音乐
					</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label>
					<input type="checkbox" name="checkbox" value="打FJ"/>打FJ
					</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label> 
					<input type="checkbox" name="checkbox" value="运动" />运动
					</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label> 
					<input type="checkbox" name="checkbox" value="看片"/>看片
					</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label> 
					<input type="checkbox" name="checkbox" value="看书"/>看书
					</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label> 
					<input type="checkbox" name="checkbox" value="绘画"/>绘画
					</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label> 
					<input type="checkbox" name="checkbox" value="收藏"/>收藏
					</label>
				</div>
				<br>
				<div class="form-group" style="text-align: center;">
					<input type="button" class="btn btn-default" id="add_submit" value="添&nbsp;&nbsp;加"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="btn btn-default" value="重&nbsp;&nbsp;置"/>
				</div>
		    	</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Send message</button>
			</div>
		</div>
	</div>
</div>