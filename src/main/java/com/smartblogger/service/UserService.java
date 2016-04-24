package com.smartblogger.service;

import java.util.List;

import com.smartblogger.dao.UserDAO;
import com.smartblogger.model.Blog;
import com.smartblogger.model.User;


public class UserService {
	private static UserDAO userDao;

	public UserService() {
		userDao = new UserDAO();
	}

	public void create(User entity) throws Exception {
		userDao.openCurrentSessionwithTransaction();
		try {
			userDao.create(entity);
		} catch (Exception e) {
			userDao.closeCurrentSession();
			throw e;
		} 
		userDao.closeCurrentSessionwithTransaction();
	}

	public void update(User entity) throws Exception {
		userDao.openCurrentSessionwithTransaction();
		try {
			userDao.update(entity);
		} catch (Exception e) {
			userDao.closeCurrentSession();
			throw e;
		} 
		userDao.closeCurrentSessionwithTransaction();
	}

	public User getByUsername(String username) {
		userDao.openCurrentSession();
		User user = userDao.getByUsername(username);
		userDao.closeCurrentSession();
		return user;
	}
	
	public boolean  isValidPassword(String username, String password) {
		userDao.openCurrentSession();
		boolean result =  userDao.isValidPassword (username, password);
		userDao.closeCurrentSession();
		return result;
	}

	
	public User getById(Integer id) {
		userDao.openCurrentSession();
		User user = userDao.getById(id);
		userDao.closeCurrentSession();
		return user;
	}

	public User getByLoginInfo(String email, String password) {
		userDao.openCurrentSession();
		User user = userDao.getByLoginInfo(email, password);
		userDao.closeCurrentSession();
		return user;
	}
	public void delete(String id) throws Exception {
		userDao.openCurrentSessionwithTransaction();
		User user = userDao.getById(id);
		try {
			userDao.delete(user);
		} catch (Exception e) {
			userDao.closeCurrentSession();
			throw e;
		} 
		userDao.closeCurrentSessionwithTransaction();
	}

	public List<User> getAll() {
		userDao.openCurrentSession();
		List<User> users = userDao.getAll();
		userDao.closeCurrentSession();
		return users;
	}
	
	public void deleteAll() throws Exception {
		userDao.openCurrentSessionwithTransaction();
		try {
			userDao.deleteAll();
		} catch (Exception e) {
			userDao.closeCurrentSession();
			throw e;
		} 
		
		userDao.closeCurrentSessionwithTransaction();
	}


}