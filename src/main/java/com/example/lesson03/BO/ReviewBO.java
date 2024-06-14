package com.example.lesson03.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired // DI 
	private ReviewMapper reviewMapper;
	
	// input: id (controller로 부터 요청 받음)
	// output: (Mapper로 부터 가져와서) < Review(단건) or null > (Controller로 넘겨줌)
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id); // reviewMapper.selectReview();를 컨트롤러에 return 하겠다. 
	}
}
