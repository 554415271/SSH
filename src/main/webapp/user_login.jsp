<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">用户登录</h4>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Name</label>
						<label id="usernameError" style="color: red;"></label>
						<s:textfield class="form-control" id="username"
							placeholder="Name should be a valid string!" />
					</div>
					<div class="form-group">
						<label for="message-text" class="control-label">Password</label><label
							id="passwordError" style="color: red;"></label>
						<s:textfield class="form-control" id="password"
							placeholder="The password should be a string between 6 and 12 bits of numbers and letters!" />
					</div>
					<div class="form-group" style="text-align: center;">
						<input type="button" class="btn btn-default" id="login_submit" value="登&nbsp;&nbsp;录" />
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