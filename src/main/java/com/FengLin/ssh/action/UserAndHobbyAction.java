package com.FengLin.ssh.action;

import java.io.IOException;
import java.util.List;

import com.FengLin.ssh.entity.UserAndHobby;

public interface UserAndHobbyAction {
	// 查询所有用户信息
	public void queryAll();

	// 查询所有用户信息
	public void findAll();

	// 用户登录
	public void login();

	// 区分普通用户和登录用户
	public void refreshUserLogin(UserAndHobby userAndHobby);

	// 删除用户
	public void delete();

	/*
	 * 根据用户上传过来的图片重新命名图片名
	 * 
	 * @ 规则：新图片名=用户上传图片名+"·"+上传时间（年、月、日）+"·"+上传时间（秒）。
	 */
	public String newImage(String image);

	// 添加用户
	public void save() throws IOException;

	// 修改用户信息
	public void update();

	// 搜索智能框提示
	public void searchBox();

	// 搜索智能框提示---->筛选
	public List<String> getData(List<String> datas, String keyword);

	// 添加“时光相册”图片
	public void addImage();
}
