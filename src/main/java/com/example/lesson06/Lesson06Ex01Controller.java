package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.BO.UserBO;

@RequestMapping("/lesson06/ex01")
@Controller
public class Lesson06Ex01Controller {

	@Autowired
	private UserBO userBO; // lesson04에 있는 거 재사용
	
	// 회원가입 화면
	// http://localhost/lesson06/ex01/add-user-view
	@GetMapping("/add-user-view")
	public String AddUserView() {
		return "lesson06/addUser";
	}

	// AJAX가 하는 요청 -> AJAX가 하는 응답값은 반드시 String이다.
	@ResponseBody
	@PostMapping("/add-user")
	public String AddUser( // 지금 아웃풋 String과 위의 아웃풋 String과는 전혀 다른 형태를 return한다. 위에는 view화면을 뿌려주기 위한 String이고
			@RequestParam("name") String name, 
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// db에 insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 응답값 글자 내리기
		return "성공!"; // resposeBody에 "성공!"이 담겨짐
	}
	
	// 회원가입 성공 화면
	// http://localhost/lesson06/ex01/after-add-user-view
	@GetMapping("/after-add-user-view")
	public String AfterAddUserView() {
		return "lesson06/afterAddUser";
	}
	
}
