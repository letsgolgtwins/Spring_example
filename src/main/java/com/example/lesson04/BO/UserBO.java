package com.example.lesson04.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.domain.User;
import com.example.lesson04.mapper.UserMapper;

@Service
public class UserBO {

	@Autowired
	private UserMapper userMapper;
	
	// lesson04 ex01_1
	// input: 파라미터 4개 & output: int(성공한 행의 개수) or void
	public void addUser(String name, String yyyymmdd, String email, String introduce) {
		userMapper.insertUser(name, yyyymmdd, email, introduce);
	}
	
	// lesson04 ex01_2
	// input: x & output: User
	public User getLatestUser() {
		return userMapper.selectLatestUser();
	}
}
