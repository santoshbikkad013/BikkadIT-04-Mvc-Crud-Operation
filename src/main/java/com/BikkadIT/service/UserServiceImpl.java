package com.BikkadIT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.dao.UserDaoI;
import com.BikkadIT.entity.User;

@Service
public class UserServiceImpl  implements UserServiceI{

	@Autowired
	private UserDaoI userDaoI;
	
	@Override
	public int saveUser(User user) {
		System.out.println("Service Layer Method");
		System.out.println(user);
		int id = userDaoI.saveUserToDb(user);
		
		
		return id;
	}

	@Override
	public boolean loginCheckServiceLayer(User user) {
		
		
		List<User> allData = userDaoI.getAllData();
		
		for(User user1:allData) {
			
			if(user.getUname().equals(user1.getUname()) && user.getPassword().equals(user1.getPassword())) {
				return true;
			}
		}
		
		
		return false;
	}

	@Override
	public List<User> getAll() {
		List<User> list = userDaoI.getAllDataFromDB();
		return list;
	}

	@Override
	public User getSingleUser(int uid) {
		User single = userDaoI.getSingle(uid);
		return single;
	}

	@Override
	public List<User> updateUser(User user) {
		List<User> updateUser = userDaoI.updateUser(user);
		return updateUser;
	}

	@Override
	public List<User> deleteUser(int id) {
		List<User> list = userDaoI.deleteUserById(id);
		return list;
	}

}
