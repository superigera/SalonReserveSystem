package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.ReservationsMapper;

@Service
public class ReservationsServiceImpl implements ReservationsService {

	@Autowired
	ReservationsMapper mapper;

	@Override
	public void reservations(String id, String name, String email, String number, String date, String time) {

		mapper.reserve(id, name, email, number, date, time);
	}

}
