package com.example.lesson01;

// 일반 Java bean으로 만든다. 즉 어노테이션 필요x
public class Data {
	// 필드
	private int id;
	private String name;

	// getter setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
