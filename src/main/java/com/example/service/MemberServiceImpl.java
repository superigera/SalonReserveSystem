package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void signup(Member member) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = sdf.format(date);

		member.setAuthority("ROLE_USER");
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		member.setCreated_at(strDate);
		mapper.insertOne(member);
	}

	@Override
	public Member findMember(int member_id) {
		return mapper.findMember(member_id);
	}

	@Override
	public void updateMember(Member member) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = sdf.format(date);

		member.setUpdate_at(strDate);
		mapper.updateMember(member);
	}

}
