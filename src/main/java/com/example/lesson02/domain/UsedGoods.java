package com.example.lesson02.domain;

import java.time.LocalDateTime;

// 일반 Java bean 
// DTO, model, domain & Entity(의 역할도 함)
public class UsedGoods {
	// 필드 - db에서 desc `used_goods`; 한다음 Field를 싹 다 복사해온다
	private int id;
	private int sellerId;
	private String title;
	private String description;
	private int price;
	private String pictureUrl;
	private LocalDateTime createdAt; // Java 8 버전 부터 나온 LocalDateTime 임포트
	private LocalDateTime updatedAt;

	// getter
	public int getId() {
		return id;
	}

	public int getSellerId() {
		return sellerId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public String getPictureUrl() {
		return pictureUrl;
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

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
