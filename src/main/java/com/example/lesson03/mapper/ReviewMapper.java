package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {

	// input: id
	// output: Review 단건 or null
	public Review selectReviewById(int id);
}
