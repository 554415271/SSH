package com.FengLin.ssh.entity;

import java.util.List;

import net.sf.json.JSONArray;

public class UserAndHobby {

	private User user;
	private Users_Hobby users_Hobby;
	private UserAlbum userAlbum;
	private List<UserAlbum> userAlbums;
	private List<String> hobbyList = null;
	private JSONArray listArray;
	private int sum;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public JSONArray getListArray() {
		return listArray;
	}

	public void setListArray(JSONArray listArray) {
		this.listArray = listArray;
	}

	public UserAlbum getUserAlbum() {
		return userAlbum;
	}

	public void setUserAlbum(UserAlbum userAlbum) {
		this.userAlbum = userAlbum;
	}

	public List<UserAlbum> getUserAlbums() {
		return userAlbums;
	}

	public void setUserAlbums(List<UserAlbum> userAlbums) {
		this.userAlbums = userAlbums;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Users_Hobby getUsers_Hobby() {
		return users_Hobby;
	}

	public void setUsers_Hobby(Users_Hobby users_Hobby) {
		this.users_Hobby = users_Hobby;
	}

	public List<String> getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(List<String> hobbyList) {
		this.hobbyList = hobbyList;
	}

	public UserAndHobby() {
		super();
	}

}
