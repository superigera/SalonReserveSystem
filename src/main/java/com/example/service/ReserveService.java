package com.example.service;

import java.util.List;

import com.example.model.Reserve;

public interface ReserveService {

	// 予約全件取得
	public List<Reserve> findTodayReserve(String today);

	// 検索予約取得
	public List<Reserve> findSearchReserve(String today, String name);

	// 予約キャンセル
	public void cancelReserve(String cancel_id);

	// 予約登録
	public void reservations(String id, String name, String email, String number, String date, String time);
}
