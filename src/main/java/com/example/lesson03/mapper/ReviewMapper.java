package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// lesson03 ex01 select
	// input: id
	// output: Review 단건 or null
	public Review selectReviewById(int id);

	// lesson03 ex02_1 insert
	public int insertReview(Review review); //int로 리턴하는 건 성공한 행의 개수(int)를 리턴하는 것

	// lesson03 ex02_2 insert
	public int insertReviewAsField(
			// 하나의 Map으로 xml에 전송
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") Double point, 
			@Param("review") String review
			);
	
	// lesson03 ex03 update
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review
			);
	
	// lesson03 ex04 delete
	public int deleteReviewById(int id);
}
