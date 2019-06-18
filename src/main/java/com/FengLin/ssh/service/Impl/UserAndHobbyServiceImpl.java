package com.FengLin.ssh.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.FengLin.ssh.dao.UserAndHobbyDao;
import com.FengLin.ssh.entity.User;
import com.FengLin.ssh.entity.UserAndHobby;
import com.FengLin.ssh.entity.Users_Hobby;
import com.FengLin.ssh.service.UserAndHobbyService;

@Transactional
public class UserAndHobbyServiceImpl implements UserAndHobbyService {

	private UserAndHobbyDao userAndHobbyDao;

	public void setUserAndHobbyDao(UserAndHobbyDao userAndHobbyDao) {
		this.userAndHobbyDao = userAndHobbyDao;
	}

	@Override
	public User login(String username) {
		return userAndHobbyDao.findByUsername(username);
	}

	@Override
	public boolean duplicate_checking(String username) {
		return userAndHobbyDao.saveByUsername(username);
	}

	@Override
	public Users_Hobby arrayToHobby(Users_Hobby users_Hobby, String hobbyObjects) {
		switch (hobbyObjects) {
		case "电影":
			users_Hobby.setFilm(hobbyObjects);
			break;
		case "音乐":
			users_Hobby.setMusic(hobbyObjects);
			break;
		case "打FJ":
			users_Hobby.setFight_FJ(hobbyObjects);
			break;
		case "运动":
			users_Hobby.setMotion(hobbyObjects);
			break;
		case "看片":
			users_Hobby.setSee_film(hobbyObjects);
			break;
		case "看书":
			users_Hobby.setRead_a_Book(hobbyObjects);
			break;
		case "绘画":
			users_Hobby.setPainting(hobbyObjects);
			break;
		case "收藏":
			users_Hobby.setCollection(hobbyObjects);
			break;
		default:
			break;
		}
		return users_Hobby;
	}

	@Override
	public List<String> filtrateHobby(User user) {

		List<String> lists = new ArrayList<String>();
		if (user.getUsers_Hobby().getFilm() != null) {
			lists.add(user.getUsers_Hobby().getFilm());
		}
		if (user.getUsers_Hobby().getMusic() != null) {
			lists.add(user.getUsers_Hobby().getMusic());
		}
		if (user.getUsers_Hobby().getFight_FJ() != null) {
			lists.add(user.getUsers_Hobby().getFight_FJ());
		}
		if (user.getUsers_Hobby().getMotion() != null) {
			lists.add(user.getUsers_Hobby().getMotion());
		}
		if (user.getUsers_Hobby().getSee_film() != null) {
			lists.add(user.getUsers_Hobby().getSee_film());
		}
		if (user.getUsers_Hobby().getRead_a_Book() != null) {
			lists.add(user.getUsers_Hobby().getRead_a_Book());
		}
		if (user.getUsers_Hobby().getPainting() != null) {
			lists.add(user.getUsers_Hobby().getPainting());
		}
		if (user.getUsers_Hobby().getCollection() != null) {
			lists.add(user.getUsers_Hobby().getCollection());
		}
		return lists;
	}

	@Override
	public List<UserAndHobby> findAll() {
		List<User> list = userAndHobbyDao.findAll();
		List<UserAndHobby> lists = new ArrayList<UserAndHobby>();
		for (User user : list) {
			UserAndHobby userAndHobby = new UserAndHobby();
			List<String> listing = filtrateHobby(user);
			userAndHobby.setUser(user);
			userAndHobby.setUsers_Hobby(user.getUsers_Hobby());
			userAndHobby.setHobbyList(listing);
			lists.add(userAndHobby);
		}
		return lists;
	}

	@Override
	public UserAndHobby findById(Integer uid) {
		UserAndHobby userAndHobby = new UserAndHobby();
		User user = userAndHobbyDao.findById(uid);
		userAndHobby.setUser(user);
		userAndHobby.setUsers_Hobby(user.getUsers_Hobby());
		userAndHobby.setUserAlbums(user.getUserAlbum());
		return userAndHobby;
	}

	@Override
	public boolean delete(User user) {
		return userAndHobbyDao.delete(user);
	}

	@Override
	public boolean update(UserAndHobby userAndHobby) {
		return userAndHobbyDao.update(userAndHobby);
	}

	@Override
	public void add(UserAndHobby userAndHobby) {
		userAndHobbyDao.add(userAndHobby);
	}

	@Override
	public List<String> searchBox() {
		return userAndHobbyDao.searchBox();
	}

	@Override
	public boolean addImage(UserAndHobby userAndHobby) {
		return userAndHobbyDao.addImage(userAndHobby);
	}

}
