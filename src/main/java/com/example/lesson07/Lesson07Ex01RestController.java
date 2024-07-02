package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.BO.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C: create
	// http://localhost/lesson07/ex01/create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "오지환";
		String phoneNumber = "010-1010-1010";
		String email = "ojh@lgtwins.com";
		String dreamJob = "야구선수(유격수)";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob); // JSON 으로 return
	}
}
