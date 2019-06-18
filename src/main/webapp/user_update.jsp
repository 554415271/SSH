<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<div class="modal fade" id="userUpdate" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">修改用户</h4>
			</div>
			<div class="modal-body">
				<form>
			<div class="form-group">
				<div id="uid" style="display: none;"></div>
				<div id="hid" style="display: none;"></div>
				<label for="exampleInputName2">Name</label>
				<input type="text" id="usernameUpdate" class="form-control" value=""/>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label>
				<input type="text" id="passwordUpdate" class="form-control" value=""/>
			</div>
			<div class="form-group">
				<label for="exampleInputName2">Self Introduction</label>
				<textarea id="selfIntroductionUpdate" class="form-control" rows="3" maxlength="50">
				</textarea>
			</div>
			<div class="checkbox" style="text-align: center;">
				<label> 
				<input type="checkbox" id="users_Hobby_film" name="checkbox" value="电影"/>电影
				</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<label> 
				<input type="checkbox" id="users_Hobby_music" name="checkbox" value="音乐"/>音乐
				</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<label>
				<input type="checkbox" id="users_Hobby_music" name="checkbox" value="打FJ"/>打FJ
				</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<label> 
				<input type="checkbox" id="users_Hobby_music" name="checkbox" value="运动" />运动
				</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<label> 
				<input type="checkbox" id="users_Hobby_music" name="checkbox" value="看片"/>看片
				</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<label> 
				<input type="checkbox" id="users_Hobby_music" name="checkbox" value="看书"/>看书
				</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<label> 
				<input type="checkbox" id="users_Hobby_music" name="checkbox" value="绘画"/>绘画
				</label>&nbsp;&nbsp;&nbsp;&nbsp;
				<label> 
				<input type="checkbox" id="users_Hobby_music" name="checkbox" value="收藏"/>收藏
				</label>
			</div>
			<br>
			<div style="text-align: center;">
				<input type="submit" id="update_submit" class="btn btn-default" value="修&nbsp;&nbsp;改"/>
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
