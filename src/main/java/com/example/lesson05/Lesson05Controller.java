package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	// http://localhost/lesson05/ex01
	@GetMapping("/ex01")
	public String ex01() {
		return "lesson05/ex01";
	}
	
	// http://localhost/lesson05/ex02
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		// List<String> 만들기
		List<String> fruits = new ArrayList<>(List.of("사과", "메론", "복숭아", "포도", "수박"));
		
		// model에 담기
		model.addAttribute("fruits", fruits);
		
		// List<Map<String, Object>> 
		List<Map<String, Object>> users = new ArrayList<>();
		Map<String, Object> user = new HashMap<>();
		user.put("name", "오지환");
		user.put("age", 35);
		user.put("hobby", "야구");
		users.add(user);
		
	
		user = new HashMap<>();
		user.put("name", "홍창기");
		user.put("age", 30);
		user.put("hobby", "야구");
		users.add(user);
		
		// model에 담기
		model.addAttribute("users", users);
		
		
		// 화면
		return "lesson05/ex02";
	}
	
	
}
