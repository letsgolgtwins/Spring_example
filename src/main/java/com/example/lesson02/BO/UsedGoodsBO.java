package com.example.lesson02.BO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.Mapper.UsedGoodsMapper;
import com.example.lesson02.domain.UsedGoods;

@Service // Spring bean으로 등록한다는 뜻.
public class UsedGoodsBO {
	
	// Spring bean을 Autowired를 통해서 가져온다.
	@Autowired // * Dependency Injection(DI): 의존성 주입
	private UsedGoodsMapper usedGoodsMapper; // 객체 (객체 이름은 소문자로)

	// input: 없음 (Controller로부터 들어온 요청)
	// output: (Repository로 부터 받아온 것을) List<UsedGoods> (Controller한테 줌)
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsMapper.selectUsedGoodsList();
		return usedGoodsList; // Contoller한테 줌(리턴)
	}
}
