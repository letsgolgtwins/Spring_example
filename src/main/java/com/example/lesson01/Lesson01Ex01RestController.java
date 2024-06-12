package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/ex01")
@RestController // @Controller + @ResponseBody 가 합쳐진 것. , Spring bean
public class Lesson01Ex01RestController {

	// http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String ex01_3() { // String을 return하고 그 결과 HTML
		return "<h3>@RestController를 사용하여 String을 return한다.</h3>";
	}

	// http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> ex01_4() {
		Map<String, String> map = new HashMap<>();
		map.put("오지환", "10");
		map.put("홍창기", "51");
		map.put("김현수", "22");
		return map;
	}

	// http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data ex01_5() { // 내가 만든 클래스 Data
		Data data = new Data(); // java bean 만듦
		data.setId(100);
		data.setName("이민희"); // 맵일때는 내가 key이름을 설정했다면, 이번에는 필드명이 key가 되는셈
		return data;
	}

	// 수업 막바지 추가 예제 
	// 서버 입장을 스스로 컨트롤 할 수 있다. 200 ok 로 할 수도 있고, 201 created로 할 수도있다. 그냥 이런게 있다 정도만 알아둘것.
	// http://localhost:8080/lesson01/ex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> ex01_6() {
		Data data = new Data(); 
		data.setId(100);
		data.setName("이민희"); 
//		ResponseEntity<Data> result = new ResponseEntity<Data>; 가 아래와 같음
		return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
