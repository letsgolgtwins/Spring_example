package com.example.lesson02.BO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service // Spring bean으로 등록한다는 뜻.
public class UsedGoodsBO {

	// input: 없음 (Controller로부터 들어온 요청)
	// output: (Repository로 부터 받아온 것을) List<UsedGoods> (Controller한테 줌)
	public List<UsedGoods> getUsedGoodsList() {
		// 여기서부턴 내일부터~
	}
}
