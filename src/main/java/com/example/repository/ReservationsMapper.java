package com.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReservationsMapper {

	// 予約登録
	public void reserve(@Param("menu_id") String id, @Param("non_member_nane") String name,
			@Param("non_member_email") String email, @Param("non_member_phone_number") String number,
			@Param("reserve_days") String date, @Param("reserve_time") String time);
}
