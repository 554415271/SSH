package com.FengLin.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_hobby", schema = "user")
public class Users_Hobby {

	private Integer hid;
	private String film; // 电影
	private String music; // 音乐
	private String fight_FJ; // 打FJ
	private String motion; // 运动
	private String see_film; // 看片
	private String read_a_Book; // 看书
	private String painting; // 绘画
	private String collection; // 收藏

	@Id
	@GeneratedValue
	@Column(name = "hid", nullable = false, length = 32, unique = true)
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getFight_FJ() {
		return fight_FJ;
	}

	public void setFight_FJ(String fight_FJ) {
		this.fight_FJ = fight_FJ;
	}

	public String getMotion() {
		return motion;
	}

	public void setMotion(String motion) {
		this.motion = motion;
	}

	public String getSee_film() {
		return see_film;
	}

	public void setSee_film(String see_film) {
		this.see_film = see_film;
	}

	public String getRead_a_Book() {
		return read_a_Book;
	}

	public void setRead_a_Book(String read_a_Book) {
		this.read_a_Book = read_a_Book;
	}

	public String getPainting() {
		return painting;
	}

	public void setPainting(String painting) {
		this.painting = painting;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public Users_Hobby(Integer hid, String film, String music, String fight_FJ, String motion, String see_film,
			String read_a_Book, String painting, String collection) {
		super();
		this.hid = hid;
		this.film = film;
		this.music = music;
		this.fight_FJ = fight_FJ;
		this.motion = motion;
		this.see_film = see_film;
		this.read_a_Book = read_a_Book;
		this.painting = painting;
		this.collection = collection;
	}

	public Users_Hobby() {
		super();
	}

	@Override
	public String toString() {
		return "Users_Hobby [hid=" + hid + ", film=" + film + ", music=" + music + ", fight_FJ=" + fight_FJ
				+ ", motion=" + motion + ", see_film=" + see_film + ", read_a_Book=" + read_a_Book + ", painting="
				+ painting + ", collection=" + collection + "]";
	}

}
