package com.example.lesson02.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson02.domain.UsedGoods;

@Mapper
public interface UsedGoodsMapper {

	// input: 없음 (BO로 부터 받아옴)
	// output: List<UsedGoods> (BO한테 전달)
	public List<UsedGoods> selectUsedGoodsList();
}
