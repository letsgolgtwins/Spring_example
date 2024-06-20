package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.BO.ReviewBO;
import com.example.lesson03.domain.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class Lesson03Ex02RestController {

	// 이번에도 `new_review` 테이블 쓸 거다.
	@Autowired
	private ReviewBO reviewBO;

	// http://localhost/lesson03/ex02/01
	@RequestMapping("/01")
	public String ex02_1() {
		Review review = new Review();
		review.setStoreId(19);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("이민희");
		review.setPoint(4.5);
		review.setReview("혼자 먹기 딱 적당하네요~");

		// insert후 성공한 row수를 리턴받는다.
		int rowCount = reviewBO.addReview(review);
		
		// html (왜냐? ResponseBody가 있고, String 리턴이기때문에)
		return "성공한 행의 개수:" + rowCount; // String 더하기 int는 최종적으로 String이 된다. 즉, 이 문장 하나가 출력된다.
	}
	
	// http://localhost/lesson03/ex02/02
	@RequestMapping("/02")
	public String quiz02_2() { // 하나하나씩 들어가는 경우

		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "꾸꾸", 5.0, "역시 맛있다 도미노!");
		return "성공한 행의 개수: " + rowCount;
	}
	
}
