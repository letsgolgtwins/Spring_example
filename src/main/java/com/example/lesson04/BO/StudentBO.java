package com.example.lesson04.BO;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	// 240703 JPA - update 
	// i: id, dreamJob / o: StudentEntity or null
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// 기존 데이터 조회 => StudentEntity
		StudentEntity student = studentRespository.findById(id).orElse(null); // 객체가 비어있을 경우엔 null로, 있을 경우엔 studentEntity로 
		
		// Entity의 데이터값을 변경해놓는다.
		if (student != null) { // student가 null이 아닐때
			student = student.toBuilder() // toBuilder는 기존 필드값은 유지
					.dreamJob(dreamJob) // 바꾸고 싶은 필드명(들어온 파라미터이름)
					.build(); // build()로 뚜껑 닫기 & 꼭 위에서 객체에 다시 저장!
			
			// update
			// save 요청
			student = studentRespository.save(student);
		}
		return student;
	}

	// 240703 JPA - delete
	// i: id / o: void
	public void deleteStudentById(int id) {
		// 방법1. 
//		StudentEntity student =	studentRespository.findById(id).orElse(null);
//		if (student != null) {
//			studentRespository.delete(student);
//		} 
		
		// 방법2.
		Optional<StudentEntity> studentOptional = studentRespository.findById(id);
		studentOptional.ifPresent(s -> studentRespository.delete(s)); // new문법) 람다식. 이럴경우 if문을 쓰지 않고도 NPE발생이 없다.
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// input: Student(파라미터 하나하나가 아닌 Student 자체) & output: void or int
	public void addStudent(Student student) {
		studentMapper.insertStudent(student); // mapper는 나에게 성공한 행의 개수를 주지만, 나는 컨트롤러에게 굳이 주지 않음^^
	}
	
	// select해주는 get메소드 -(0620 수업전 내 생각. 아마 아웃풋으로 도메인인 메소드를 만들지 않을까?)
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
