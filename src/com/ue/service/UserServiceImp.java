package com.ue.service;

import com.ue.dao.UserDao;
import com.ue.domain.User;
import com.ue.utils.BeanUtils;

//@Service
public class UserServiceImp implements UserService {

	private UserDao userDao = null;

	public UserServiceImp() {
		userDao = (UserDao) BeanUtils.getBean("userDao");
	}

	@Override
	public boolean insertUser(User user) {
		if(user == null){
			return false;
		}
		return userDao.insertUser(user);
	}

	@Override
	public boolean deleteUserById(int use_id) {
		if(use_id <= 0){
			return false;
		}
		return userDao.deleteUserById(use_id);
	}

	@Override
	public boolean deleteUserByName(String tagName) {
		if(tagName == null || "".equals(tagName)){
			return false;
		}
		return userDao.deleteUserByName(tagName);
	}

	@Override
	public boolean updateUserById(int use_id, User newUser) {
		if(use_id <= 0|| newUser == null){
			return false;
		}
		return userDao.updateUserById(use_id, newUser);
	}

	@Override
	public User searchUserById(int tagId) {
		if(tagId <= 0){
			return null;
		}
		return userDao.searchUserById(tagId);
	}

	@Override
	public User searchUserByPhone(String use_phone) {
		if(use_phone == null || "".equals(use_phone)){
			return null;
		}
		return userDao.searchUserByPhone(use_phone);
	}

	@Override
	public User searchUserByUserId(int userId) {
		if(userId <= 0){
			return null;
		}
		return userDao.searchUserById(userId);
	}

	@Override
	public int getUserCount() {
		// TODO Auto-generated method stub
		return userDao.getUserCount();
	}
	
	

}
