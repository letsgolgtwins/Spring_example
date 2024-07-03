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
	
	// U: update
	// http://localhost/lesson07/ex01/update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 7번인 dreamjob을 변경 (한국시리즈 우승주장)
		return studentBO.updateStudentDreamJobById(7, "한국시리즈 우승주장");
	}
	
	// D: delete
	// http://localhost/lesson07/ex01/delete
	@GetMapping("/delete")
	public String delete() { // delete는 무언갈 가져오는 게 아닌 삭제하는 거 일뿐이므로 아웃풋으로 아무것도 가져오지 않는다. 근데 void는 좀 그러니, String 으로 하겠다.
		// id가 8번인 데이터 삭제
		studentBO.deleteStudentById(12);
		return "삭제 성공";
	}
		
}
