<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
 
<div class="modal fade" id="add_pictures" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">时光图片</h4>
			</div>
			<div class="modal-body">
				<form enctype="multipart/form-data">
					<div class="form-group">
					    <!-- 隐藏auid，用于保持用户与上传图片的关联。 -->
						<input type="text" id="auid" style="display: none;"  
							value="<s:property value="#session.userAndHobbyLogin.user.uid"/>"/> 
						
						<label for="exampleInputPassword1">图片标题</label>
						<label id="imageTitleError" style="color: red;"></label>
						<input type="text" class="form-control" id="imageTitle"/>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">时光图片</label>
						<label id="imageError" style="color: red;"></label>
						<input type="file" class="form-control" id="image"/>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">描述</label>
						<label id="imageDescError" style="color: red;"></label>
						<textarea id="imageDesc" class="form-control" rows="3" maxlength="50" placeholder="在此输入不大于50个字符的图片描述"></textarea>
					</div>
					<div class="form-group" style="text-align: center;">
						<input type="button" class="btn btn-default" id="add_image" value="添&nbsp;&nbsp;加" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" class="btn btn-default" value="重&nbsp;&nbsp;置" />
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