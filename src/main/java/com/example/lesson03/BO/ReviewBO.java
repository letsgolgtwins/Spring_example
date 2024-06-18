package com.example.lesson03.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired // DI 
	private ReviewMapper reviewMapper;
	
	// lesson03 ex01 select
	// input: id (controller로 부터 요청 받음)
	// output: (Mapper로 부터 가져와서) < Review(단건) or null > (Controller로 넘겨줌)
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id); // reviewMapper.selectReview();를 컨트롤러에 return 하겠다. 
	}
	
	// lesson03 ex02_1 insert  
	// input: Review
	// output: 성공한 행의 개수(int)
	public int addReview(Review review) { // 컨트롤러로부터 review 객체를 가져오는 셈 // 근데 output이 void일 수도 있다
		return reviewMapper.insertReview(review);
	}
	
	// lesson03 ex02_2 insert 
	// addReviewAsField(4, "콤비네이션R", "꾸꾸", 5.0, "역시 맛있다 도미노!"); 를 보고 만들것
	public int addReviewAsField(int storeId, String menu, String userName, Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// lesson03 ex03 update
	// input-id, review / output: 성공한 행 개수
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
}
