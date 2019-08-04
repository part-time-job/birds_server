package com.ue.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ue.domain.User;
import com.ue.domain.User3;

public interface UserDao extends Serializable {

	/**
	 * 往数据库添加一条用户记录
	 * @param user 需要添加的对象
	 * @return 正数表示添加成功，否则添加失败
	 */
	boolean insertUser(User user);

	// 删除
	boolean deleteUserById(int tagID);

	boolean deleteUserByName(String tagName);

	// 修改
	boolean updateUserById(int use_id, User newUser);
	// 查找
	User searchUserById(int use_id);

	User searchUserByPhone(String use_phone);
	
	// ORMapping
	User MapToObject(Map<String, Object> map);

	int getUserCount();

}