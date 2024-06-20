package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {

	// DB에 insert
	public int insertStudent(Student student); // 성공한 행의 개수 return

	// DB에서 select -(수업전 내 생각으론 한 건이므로 아웃풋으로 도메인이름을 하지 않을까)
	public Student selectStudentById(int id);
}
