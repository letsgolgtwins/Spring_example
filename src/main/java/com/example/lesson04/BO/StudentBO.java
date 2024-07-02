package com.example.lesson04.BO;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.Repository.StudentRepository;
import com.example.lesson07.entity.StudentEntity;

@Service
public class StudentBO {

	// MyBatis 전용 aw
	@Autowired
	private StudentMapper studentMapper;
	
	// JPA 전용 aw
	@Autowired
	private StudentRepository studentRespository;
	
	// 240702 JPA - 아래의 addStudent 를 재활용(오버라이딩) 할 거임.
	// i: controller로 부터 들어올 파라미터 4개 / o: StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // 근데 Entity에서 createdAt에 @CreationTimeStamp 를 해주었기에 생략해도된다.
				.build();
		
		return studentRespository.save(student);
		
	}
	
	// input: Student(파라미터 하나하나가 아닌 Student 자체) & output: void or int
	public void addStudent(Student student) {
		studentMapper.insertStudent(student); // mapper는 나에게 성공한 행의 개수를 주지만, 나는 컨트롤러에게 굳이 주지 않음^^
	}
	
	// select해주는 get메소드 -(0620 수업전 내 생각. 아마 아웃풋으로 도메인인 메소드를 만들지 않을까?)
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
