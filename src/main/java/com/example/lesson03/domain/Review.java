package com.example.lesson03.domain;

import java.time.LocalDateTime;

public class Review {

	// 필드
	private int id;
	private int storeId;
	private String menu;
	private String userName;
	private Double point; // null이 가능한 컬럼은 자료형을 입력할때 소문자 말고 대문자로 입력해줘야 한다. 즉, double 말고 Double로
	private String review;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	// getter
	public int getId() {
		return id;
	}

	public int getStoreId() {
		return storeId;
	}

	public String getMenu() {
		return menu;
	}

	public String getUserName() {
		return userName;
	}

	public Double getPoint() {
		return point;
	}

	public String getReview() {
		return review;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	// setter
	public void setId(int id) {
		this.id = id;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
