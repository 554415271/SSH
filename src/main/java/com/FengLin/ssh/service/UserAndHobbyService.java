package com.FengLin.ssh.service;

import java.util.List;

import com.FengLin.ssh.entity.User;
import com.FengLin.ssh.entity.UserAndHobby;
import com.FengLin.ssh.entity.Users_Hobby;

public interface UserAndHobbyService {

	public User login(String username);

	public boolean duplicate_checking(String username);

	public Users_Hobby arrayToHobby(Users_Hobby users_Hobby, String hobbyObjects);

	public List<String> filtrateHobby(User user);

	public List<UserAndHobby> findAll();

	public UserAndHobby findById(Integer uid);

	public boolean delete(User user);

	public boolean update(UserAndHobby userAndHobby);

	public void add(UserAndHobby userAndHobby);

	// 搜索智能框提示
	public List<String> searchBox();

	// 添加“时光相册”图片
	public boolean addImage(UserAndHobby userAndHobby);
}
