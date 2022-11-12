package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Reserve;

@Mapper
public interface ReserveMapper {

	// 本日予約全件取得
	public List<Reserve> findTodayReserve(String today);

	// 検索予約取得
	public List<Reserve> findSearchReserve(String today);

}
