package com.ue.test;

import org.springframework.stereotype.Controller;

import com.ue.domain.User3;
import com.ue.service.UserService;
import com.ue.utils.BeanUtils;

@Controller
public class UserTest {

	private UserService userService;

	public UserTest() {
		System.out.println("*********home***********");
		userService = (UserService) BeanUtils.getBean("userService");
	}

	public void insert() {
		@SuppressWarnings("unused")
		User3 user = new User3("name", "sex");
		//boolean res = this.userService.insertUser(user);
		//System.out.println(res);
	}

	public void deleteid() {
		boolean res = this.userService.deleteUserById(2);
		System.out.println(res);
	}

	public void deletename() {
		boolean res = this.userService.deleteUserByName("name");
		System.out.println(res);
	}

	public void updateid() {
//		User3 user = new User3("name2", "sex2");
//		boolean res = this.userService.updateUserById(2, user);
//		System.out.println(res);
	}

	public void updatename() {
		//User3 user = new User3("name3", "sex3");
		//boolean res = this.userService.updateUserByName("name2", user);
		//System.out.println(res);
	}

	public static void searid() {
//		User user = userService.searchUserById(3);
//		System.out.println(user);
	}

	public static void searname() {
//		User user = userService.searchUserByPhone("13601509223");
//		System.out.println(user);
	}

	public void getAllUsers() {
//		List<User3> list = this.userService.getAllUsers();
//		for (User3 areaDto : list) {
//			System.out.println(areaDto.getName());
//		}
//		System.out.println(list.size());

	}

	public static void main(String[] args) {
		
	}
	
}
