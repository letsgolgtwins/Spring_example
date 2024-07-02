package com.example.lesson07.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson07.entity.StudentEntity;

// 어노테이션 필요없음
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> { // 제네릭 <entity명, pk의 타입>

	// Spring Data JPA vs 순수한 JPA
	// public StudentEntity save(StudentEntity student) 원래대로라면 내가 만들었을 것. 
	
	// 이게 끝. 
}
