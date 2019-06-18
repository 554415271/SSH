package com.FengLin.ssh.entity;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users", schema = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer uid;
	private String username;
	private String password;
	private String selfIntroduction; // 自我介绍
	private File Pic; // 上传图片文件
	private String PicContentType; // 上传图片种类
	private String PicFileName; // 上传图片文件名

	private List<UserAlbum> userAlbum;
	private Users_Hobby users_Hobby;

	@Id
	@GeneratedValue()
	@Column(name = "uid", nullable = false, length = 11, unique = true)
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "username", nullable = false, length = 10)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 12)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public List<UserAlbum> getUserAlbum() {
		return userAlbum;
	}

	public void setUserAlbum(List<UserAlbum> userAlbum) {
		this.userAlbum = userAlbum;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hid")
	public Users_Hobby getUsers_Hobby() {
		return users_Hobby;
	}

	public void setUsers_Hobby(Users_Hobby users_Hobby) {
		this.users_Hobby = users_Hobby;
	}

	@Transient
	public File getPic() {
		return Pic;
	}

	public void setPic(File pic) {
		Pic = pic;
	}

	@Transient
	public String getPicContentType() {
		return PicContentType;
	}

	public void setPicContentType(String picContentType) {
		PicContentType = picContentType;
	}

	@Column(name = "pic", nullable = true)
	public String getPicFileName() {
		return PicFileName;
	}

	public void setPicFileName(String picFileName) {
		PicFileName = picFileName;
	}

	@Column(name = "selfIntroduction", nullable = true, length = 60)
	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public User() {
		super();
	}

}
