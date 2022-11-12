package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Reserve;
import com.example.repository.ReserveMapper;

@Service
public class ReserveServiceImpl implements ReserveService {

	@Autowired
	private ReserveMapper mapper;

	@Override
	public List<Reserve> findTodayReserve(String today) {
		return mapper.findTodayReserve(today);
	}

	@Override
	public List<Reserve> findSearchReserve(String day) {
		return mapper.findSearchReserve(day);
	}

	@Override
	public void reservations(String id, String name, String email, String number, String date, String time) {

		mapper.reserve(id, name, email, number, date, time);
	}

}
