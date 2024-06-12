package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// HTML 화면으로 보내는 컨트롤러 용도로 쓸 예정.
@Controller // @ResponseBody 혹은 @RestController면 안된다.
public class Lesson01Ex02Controller {

	// http://localhost/lesson01/ex02  --port를 80으로 바꿨음
	@RequestMapping("/lesson01/ex02") // 얘는 단지 치고 들어가는 주소이고
	public String ex02() {
		// return 되는 String 은 html의 경로이다. (언제? ResponseBody가 없을 떄)
		
		// return 				 "lesson01/ex02"
		// 원래는 return "templates/lesson01/ex02.html";
		return "lesson01/ex02"; // response html view 경로
		// 얘는 html 주소이다. 위에와 전혀 다른 것.
	}
}
