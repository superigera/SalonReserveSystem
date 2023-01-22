package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.Reserve;

@Mapper
public interface ReserveMapper {

	// 本日予約全件取得
	public List<Reserve> findTodayReserve(String today);

	// 検索予約取得
	public List<Reserve> findSearchReserve(String day, String name);

	// 予約キャンセル
	public void cancelReserve(String cancel_id);

	// 直近予約取得
	public List<Reserve> findReserve(@Param("member_id") Integer member_id, @Param("today") String today);

	// 過去予約取得
	public List<Reserve> findPastReserve(@Param("member_id") Integer member_id, @Param("today") String today);

	// 予約登録
	public void reserve(@Param("menu_id") Integer id, @Param("non_member_name") String name,
			@Param("non_member_email") String email, @Param("non_member_phone_number") String number,
			@Param("reserve_days") String date, @Param("reserve_time") String time, @Param("date_up") String date_up);
}
