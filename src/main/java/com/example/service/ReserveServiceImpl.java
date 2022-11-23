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
	public List<Reserve> findSearchReserve(String day, String name) {
		return mapper.findSearchReserve(day, name);
	}

	@Override
	public void cancelReserve(String cancel_id) {
		mapper.cancelReserve(cancel_id);
	}

	@Override
	public void reservations(Integer id, String name, String email, String number, String date, String time) {

		mapper.reserve(id, name, email, number, date, time);
	}

	@Override
	public List<Reserve> findReserve(Integer member_id, String today) {
		return mapper.findReserve(member_id, today);
	}

	@Override
	public List<Reserve> findPastReserve(Integer member_id, String today) {
		return mapper.findPastReserve(member_id, today);
	}

}
