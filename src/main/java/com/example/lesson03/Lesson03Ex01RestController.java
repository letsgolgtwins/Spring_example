package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.BO.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;

	// http://localhost/lesson03/ex01
	// 자, 이제 http://localhost/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			// 1. @RequestParam(value = "id") int id // 필수 파라미터
			// 2. @RequestParam(value = "id", required = true) int id // 필수 파라미터
			// 3. @RequestParam(value = "id", required = false) Integer id // 비필수 파라미터 null도 가능한 셈=주문이 들어올 수도 있고(ex01?id=7), 안들어올 수도 있다(ex01). 이 경우  
			// 4. @RequestParam(value = "id", defaultValue = "1") int id // 비필수 파라미터 + 기본값 1
			) { 
//3.		if (id == null) {
//			id = 1;
//		} // id가 특정번호인 거 하나만 가져올 것이므로 List를 쓰지 않고 그냥 도메인 이름으로만 만든다.
		return reviewBO.getReviewById(id); // response JSON 
	}
}
