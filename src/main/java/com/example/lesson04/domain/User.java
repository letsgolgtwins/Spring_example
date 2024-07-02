package com.example.lesson04.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {

	// 필드
	private int id;
	private String name;
	private String yyyymmdd;
	private String introduce;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	// 240702 loombok 테스트로 getter setter 다 지웠음.
}
