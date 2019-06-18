package com.FengLin.ssh.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.FengLin.ssh.dao.UserAndHobbyDao;
import com.FengLin.ssh.entity.User;
import com.FengLin.ssh.entity.UserAndHobby;

public class UserAndHobbyDaoImpl extends HibernateDaoSupport implements UserAndHobbyDao {

	@Override
	public User findByUsername(String username) {
		String hql = "from User where username=?";
		Query query = this.currentSession().createQuery(hql);
		query.setString(0, username);
		@SuppressWarnings({ "unchecked" })
		List<User> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean saveByUsername(String username) {
		String hql = "from User where username=?";
		Query query = this.currentSession().createQuery(hql);
		query.setString(0, username);
		@SuppressWarnings({ "unchecked" })
		List<User> list = query.list();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		String hql = "from User";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public User findById(Integer uid) {
		return this.getHibernateTemplate().get(User.class, uid);
	}

	@Override
	public boolean delete(User user) {
		try {
			this.getHibernateTemplate().delete(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(UserAndHobby userAndHobby) {
		try {
			userAndHobby.getUser().setUsers_Hobby(userAndHobby.getUsers_Hobby());
			this.getHibernateTemplate().update(userAndHobby.getUser());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public boolean addImage(UserAndHobby userAndHobby) {
		try {
			User user = this.getHibernateTemplate().get(User.class, userAndHobby.getUser().getUid());
			userAndHobby.getUserAlbum().setUser(user);
			this.getHibernateTemplate().save(userAndHobby.getUserAlbum());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			return false;
		}
	}

	@Override
	public void add(UserAndHobby userAndHobby) {
		userAndHobby.getUser().setUsers_Hobby(userAndHobby.getUsers_Hobby());
		this.getHibernateTemplate().save(userAndHobby.getUser());
	}

	@Override
	public List<String> searchBox() {
		String hql = "select username from User";
		Query query = this.currentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<String> list = query.list();
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

}
