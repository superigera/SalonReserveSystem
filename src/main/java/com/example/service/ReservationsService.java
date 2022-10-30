package com.example.service;

public interface ReservationsService {

	// 予約登録
	public void reservations(String id, String name, String email, String number, String date, String time);
}
