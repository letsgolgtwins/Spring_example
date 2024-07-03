package com.example.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 객체 출력시 필드값들이 그냥 뿌려도 안에 있는 내용물이 다 보인다. id에는 뭐가 들어있고~ name에는 뭐가 들어있고~
@AllArgsConstructor // 모든 파라미터가 있는 생성자
@NoArgsConstructor // 파라미터가 아무것도 없는 기본 생성자
@Builder(toBuilder = true)  // setter를 대신해서 내용을 담음. 업데이트까지 하게 하고 싶다면 뒤에 (toBuilder = true) 를 붙여준다. 이는 필드수정을 허용하겠다라는 의미이다.
@Getter // getter만 
@Table(name="new_student")
@Entity // 이 객체는 entity라는 걸 알려줘야 함. BO-JPA-DB 
public class StudentEntity {
	@Id // id가 primary key라는 걸 알려주는 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY) // insert시 방금 들어간 그때의 id를 가져오겟다.
	// 필드
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber") // 어플리케이션 프로퍼티스에 카멜케이스를 설정해줫음에도 해줘야 한다.
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@CreationTimestamp // 시간값이 null(없어도)이어도 현재시간으로 들어감. & update 할 시 바뀌지 않음.
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp // update 할 시 시간 변경됨.
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
	
}
