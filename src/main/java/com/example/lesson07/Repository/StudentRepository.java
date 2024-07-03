package com.example.lesson07.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// 어노테이션 필요없음
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { // 제네릭 <entity명, pk의 타입>
	// 이게 끝.

	// Spring Data JPA vs 순수한 JPA
	// public StudentEntity save(StudentEntity student) - insert
	// public StudentEntity findById(int id) - update
	// public void delete(StudentEntity student) - delete
	// public List<StudentEntity> findAll - select // 1) 전체 조회
	
	// JPQL 문법 ex02/select - 메소드 이름 주의 한 글자라도 틀리면 작동 안된다. 
	public List<StudentEntity> findAllByOrderByIdDesc();  // 2) id 기준 내림차순 전체 조회 (order by id desc)
	public List<StudentEntity> findTop3ByOrderByIdDesc(); // 3) id 기준 내림차순 3개만 조회
	public List<StudentEntity> findByName(String name1111); // 4) 이름이 오지환인 데이터 조회
	public List<StudentEntity> findByNameIn(List<String> names); // 5) in문으로 일치하는 값 모두 조회
	public List<StudentEntity> findByNameAndDreamJob(String name111, String dreamJob111); // 6) 여러 column 값과 일치하는 데이터 조회
	public List<StudentEntity> findByEmailContains(String keyword); // 7) email 컬럼에 lgtwins.com 가 포함된 데이터 조회 - like문
	public List<StudentEntity> findByNameStartingWith(String keyword); // 8) 성씨가 문씨인 데이터 조회 - like문 > like '문%'
	public List<StudentEntity> findByIdBetween(int startId, int endId); // 9) id가 2에서부터 5까지 조회 - between 
}
