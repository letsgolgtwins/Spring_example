package com.example.lesson05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
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
	
	// http://localhost/lesson05/ex03
	@GetMapping("/ex03")
	public String ex03(Model model) {
		// Mon Jun 24 16:20:24 KST 2024
		Date date = new Date();
		model.addAttribute("date", date); // 모델에 담기
		
		// 2024-06-24
		LocalDate localDate = LocalDate.now(); // new를 안했음에도 now()를 사용할 수 있는 이유는 static메소드여서 그럼
		model.addAttribute("localDate", localDate); // 모델에 담기
		
		// 2024-06-24T16:21:23.415145900
		LocalDateTime localDateTime = LocalDateTime.now(); // static메소드
		model.addAttribute("localDateTime", localDateTime); // 모델에 담기
		
		// UTC 표준시 - 글로벌하게 사용하는 경우
		// 2024-06-24T16:22:00.409707800+09:00[Asia/Seoul]
		ZonedDateTime zonedDateTime = ZonedDateTime.now(); // static 메소드
		model.addAttribute("zonedDateTime", zonedDateTime); // 모델에 담기
		
		// 화면
		return "lesson05/ex03";
	}
	
}
