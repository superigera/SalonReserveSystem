package com.example.service;

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

		member.setAuthority("ROLE_USER");
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		mapper.insertOne(member);
	}

	@Override
	public Member findMember(int member_id) {
		return mapper.findMember(member_id);
	}

	@Override
	public void updateMember(Member member) {
		mapper.updateMember(member);
	}

}
