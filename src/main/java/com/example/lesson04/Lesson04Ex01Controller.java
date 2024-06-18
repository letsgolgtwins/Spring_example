package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.BO.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
// 화면이니까 Rest가 빠진다.
@Controller // html화면의 경우 ResponseBody 사용 안함.
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원가입 화면
	// http://localhost/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET) // 처음에 링크타고 들어오는 것이므로 GET
	public String addUserView() {
		return "lesson04/addUser"; // html view 경로. *슬래시는 안붙이고 .html도 안붙인다. 이게 틀렸을 경우 500에러가 발생한다.
	}
	
	// lesson04 ex01_1
	// 회원가입 진행 => DB에 저장 => 결과 화면
	@PostMapping("/add-user") // POST만 허용하겠다 + 주소(공통된 주소 제외하고)
	public String addUser(
			@RequestParam("name") String name, 
			@RequestParam("yyyymmdd") String yyyymmdd, 
			@RequestParam("email") String email, 
			@RequestParam(value = "introduce", required = false) String introduce) { // null허용인 경우 required를 붙여준다
		
		// DB에 저장 - insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 결과 화면 이동
		return "lesson04/afterAddUser"; 
	}
	
	// lesson04 ex01_2
	// 최근 가입자 정보를 뿌리는 화면
	// http://localhost/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	public String latestUserView(Model model) { // Model: View화면에서 데이터를 꺼내쓸 수 있는 객체
		// DB select 최신 가입자 한 명(단 건)
		User user = userBO.getLatestUser();
		
		// Model 주머니에 담는다. => HTML에서 꺼내쓴다.
		model.addAttribute("result", user); // key, 
		model.addAttribute("title", "최근 가입한 유저 정보!");
		
		// 결과 화면 이동
		return "lesson04/latestUser";
	}
}
