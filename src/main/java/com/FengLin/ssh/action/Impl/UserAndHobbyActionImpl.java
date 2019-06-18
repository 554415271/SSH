package com.FengLin.ssh.action.Impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.FengLin.ssh.MD5.userMD5;
import com.FengLin.ssh.action.UserAndHobbyAction;
import com.FengLin.ssh.entity.User;
import com.FengLin.ssh.entity.UserAndHobby;
import com.FengLin.ssh.entity.Users_Hobby;
import com.FengLin.ssh.service.UserAndHobbyService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class UserAndHobbyActionImpl extends ActionSupport implements ModelDriven<UserAndHobby>, UserAndHobbyAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserAndHobby userAndHobby = new UserAndHobby();
	static Integer id = null;

	@Override
	public UserAndHobby getModel() {
		return userAndHobby;
	}

	private UserAndHobbyService userAndHobbyService;

	public void setUserAndHobbyService(UserAndHobbyService userAndHobbyService) {
		this.userAndHobbyService = userAndHobbyService;
	}

	@Override
	public void queryAll() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<UserAndHobby> list = userAndHobbyService.findAll();
		JsonConfig jsonConfig = new JsonConfig(); // 建立配置文件
		jsonConfig.setIgnoreDefaultExcludes(false); // 设置默认忽略
		jsonConfig.setExcludes(new String[] { "userAlbum", "userAlbums" });
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		ServletActionContext.getContext().getSession().put("list", list);
		try {
			response.getWriter().print(jsonArray);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void login() {
		User user = userAndHobbyService.login(userAndHobby.getUser().getUsername());
		userAndHobby.setSum(1);
		if (user != null) {
			if (!userAndHobby.getUser().getPassword().equals(userMD5.str2MD5(user.getPassword()))) {
				// 密码不正确
				userAndHobby.setSum(-2);
			} else {
				List<String> list = userAndHobbyService.filtrateHobby(user);
				JSONArray jsonArray = JSONArray.fromObject(list);
				userAndHobby.setUser(user);
				userAndHobby.setListArray(jsonArray);
				// 存储入session
				id = userAndHobby.getUser().getUid();
				refreshUserLogin(userAndHobby);
			}
		} else {
			// 用户不存在
			userAndHobby.setSum(-1);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(userAndHobby.getSum());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void refreshUserLogin(UserAndHobby userAndHobby) {
		ServletActionContext.getContext().getSession().put("userAndHobbyLogin", userAndHobby);
	}

	@Override
	public void findAll() {
		queryAll();
	}

	@Override
	public void delete() {
		User users = userAndHobbyService.findById(userAndHobby.getUser().getUid()).getUser();
		Boolean bool = userAndHobbyService.delete(users);
		userAndHobby.setSum(1);
		if (bool != true) {
			userAndHobby.setSum(-1);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(userAndHobby.getSum());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	@SuppressWarnings("static-access")
	public String newImage(String image) {
		Calendar data = Calendar.getInstance();
		return image.substring(0, image.lastIndexOf(".")) + "·" + String.valueOf(data.get(data.YEAR))
				+ String.valueOf(data.get(data.MONTH) + 1) + String.valueOf(data.get(data.DATE)) + "·"
				+ String.valueOf(data.get(data.MINUTE)) + image.substring(image.lastIndexOf("."));
	}

	@Override
	public void save() {
		// 处理前台传来的头像
		userAndHobby.getUser().setPicFileName(newImage(userAndHobby.getUser().getPicFileName()));
		String filePath = ServletActionContext.getServletContext().getRealPath("/headImage");
		File file = new File(filePath, userAndHobby.getUser().getPicFileName());
		try {
			FileUtils.copyFile(userAndHobby.getUser().getPic(), file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 处理前台传来的兴趣爱好
		HttpServletRequest request = ServletActionContext.getRequest();
		String hobby = request.getParameter("hobby");
		String user_register_Status_code = request.getParameter("user_register_Status_code");
		Object[] hobbyObjects = JSONArray.fromObject(hobby).toArray();
		Users_Hobby users_Hobby = new Users_Hobby();
		if (hobbyObjects == null || hobbyObjects.length == 0) {
			userAndHobby.setUsers_Hobby(users_Hobby);
		} else {
			for (Object object : hobbyObjects) {
				userAndHobby.setUsers_Hobby(userAndHobbyService.arrayToHobby(users_Hobby, object.toString()));
			}
		}

		// 保存用户传过来的信息并回显状态值
		userAndHobby.setSum(1);
		if (userAndHobbyService.duplicate_checking(userAndHobby.getUser().getUsername())) {
			userAndHobby.setSum(-1);
		} else {
			userAndHobbyService.add(userAndHobby);
			if (user_register_Status_code.equals("注册")) {
				User user = userAndHobbyService.login(userAndHobby.getUser().getUsername());
				id = user.getUid();
				List<String> list = userAndHobbyService.filtrateHobby(user);
				JSONArray jsonArray = JSONArray.fromObject(list);
				userAndHobby.setUser(user);
				userAndHobby.setListArray(jsonArray);
				refreshUserLogin(userAndHobby);
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(userAndHobby.getSum());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String hobby = request.getParameter("hobby");
		Object[] hobbyObjects = JSONArray.fromObject(hobby).toArray();
		List<String> list = new ArrayList<String>();
		Users_Hobby users_Hobby = new Users_Hobby();
		users_Hobby.setHid(userAndHobby.getUsers_Hobby().getHid());
		for (Object object : hobbyObjects) {
			list.add(object.toString());
			userAndHobby.setUsers_Hobby(userAndHobbyService.arrayToHobby(users_Hobby, object.toString()));
		}
		// 通过uid从数据库查询出头像名，避免更新用户信息时头像名信息丢失
		UserAndHobby getPicByUidAndHobby = userAndHobbyService.findById(userAndHobby.getUser().getUid());
		userAndHobby.getUser().setPicFileName(getPicByUidAndHobby.getUser().getPicFileName());

		Boolean bool = userAndHobbyService.update(userAndHobby);
		JSONArray jsonArray = JSONArray.fromObject(list);
		userAndHobby.setListArray(jsonArray);
		userAndHobby.setSum(1);
		if (bool != true) {
			userAndHobby.setSum(-1);
		} else {
			if (userAndHobby.getUser().getUid() == id) {
				refreshUserLogin(userAndHobby);
			}
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(userAndHobby.getSum());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void searchBox() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String hobby = request.getParameter("searchBox");
		List<String> datas = userAndHobbyService.searchBox();
		List<String> listData = getData(datas, hobby);
		JSONArray jsonArray = JSONArray.fromObject(listData);
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(jsonArray);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<String> getData(List<String> datas, String keyword) {
		List<String> list = new ArrayList<String>();
		for (String data : datas) {
			if (data.contains(keyword) && !keyword.equals("")) {
				list.add(data);
			}
		}
		return list;
	}

	@Override
	public void addImage() {
		userAndHobby.getUserAlbum().setImageFileName(newImage(userAndHobby.getUserAlbum().getImageFileName()));
		Boolean bool = userAndHobbyService.addImage(userAndHobby);
		String filePath = ServletActionContext.getServletContext().getRealPath("/Time_album");
		File file = new File(filePath, userAndHobby.getUserAlbum().getImageFileName());
		try {
			FileUtils.copyFile(userAndHobby.getUserAlbum().getImage(), file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		userAndHobby.setSum(1);
		if (bool != true) {
			userAndHobby.setSum(-1); // 添加图片失败
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.getWriter().print(userAndHobby.getSum());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}