package com.example.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson07.Repository.StudentRepository;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	// !!!!!! 이번에만 BO를 생략한다.
	@Autowired
	private StudentRepository studentRepository;
	
	// R: Read
	// http://localhost/lesson07/ex02/select1
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		// 1) 전체 조회(기본으로 제공됨)
		// return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회 (order by id desc)
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개만 조회
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 오지환인 데이터 조회
		// return studentRepository.findByName("오지환");
		
		// 5) in문으로 일치하는 값 모두 조회
		// return studentRepository.findByNameIn(List.of("오지환", "문보경"));
		
		// 6) 여러 column 값과 일치하는 데이터 조회
		// return studentRepository.findByNameAndDreamJob("오지환", "한국시리즈 우승주장");

		// 7) email 컬럼에 lgtwins.com 가 포함된 데이터 조회 - like문 > like '%lgtwins.com%'
		// return studentRepository.findByEmailContains("lgtwins.com");
		
		// 8) 성씨가 문씨인 데이터 조회 - like문 > like '문%'
		// return studentRepository.findByNameStartingWith("문");
		
		// 9) id가 2에서부터 5까지 조회 - between 
		return studentRepository.findByIdBetween(2, 5);
	}
		
	// 240708
	// http://localhost/lesson07/ex02/select2
	@GetMapping("/select2")
	public List<StudentEntity> select2() {
		// 장래희망이 야구선수(유격수)인 데이터 조회
		return studentRepository.findByDreamJob("야구선수(유격수)");
	}
}
