package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Member;

@Mapper
public interface MemberMapper {

	// ユーザー登録
	public int insertOne(Member member);

}
