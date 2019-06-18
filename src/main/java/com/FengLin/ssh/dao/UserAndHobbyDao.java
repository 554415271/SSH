package com.FengLin.ssh.dao;

import java.util.List;

import com.FengLin.ssh.entity.User;
import com.FengLin.ssh.entity.UserAndHobby;

public interface UserAndHobbyDao {

	// 用户登录验证
	public User findByUsername(String username);

	// 用户是否重复验证
	public boolean saveByUsername(String username);

	// 查询所有用户信息
	public List<User> findAll();

	// 通过用户id查询用户信息
	public User findById(Integer uid);

	// 删除用户
	public boolean delete(User user);

	// 修改用户
	public boolean update(UserAndHobby userAndHobby);

	// 添加“时光相册”图片
	public boolean addImage(UserAndHobby userAndHobby);

	// 添加用户
	public void add(UserAndHobby userAndHobby);

	// 搜索智能框提示
	public List<String> searchBox();
}
