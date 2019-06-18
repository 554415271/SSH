package com.FengLin.ssh.entity;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usersAlbum", schema = "user")
public class UserAlbum {
	private Integer aid;
	private File image; // 图片文件
	private String imageContentType; // 图片种类
	private String imageFileName; // 图片名
	private String imageTitle; // 图片标题
	private String imageDesc; // 描述

	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Id
	@GeneratedValue()
	@Column(name = "aid", nullable = false, length = 11, unique = true)
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Transient
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	@Transient
	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	@Column(name = "image")
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public String getImageDesc() {
		return imageDesc;
	}

	public void setImageDesc(String imageDesc) {
		this.imageDesc = imageDesc;
	}

	public UserAlbum() {
		super();
	}
}
