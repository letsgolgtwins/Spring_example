package com.example.lesson04.BO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	// input: Student(파라미터 하나하나가 아닌 Student 자체) & output: void or int
	public void addStudent(Student student) {
		studentMapper.insertStudent(student); // mapper는 나에게 성공한 행의 개수를 주지만, 나는 컨트롤러에게 굳이 주지 않음^^
	}
	
	// select해주는 get메소드 -(0620 수업전 내 생각. 아마 아웃풋으로 도메인인 메소드를 만들지 않을까?)
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
