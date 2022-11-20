package com.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.Member;

@Mapper
public interface MemberMapper {

	// ユーザー登録
	public int insertOne(Member member);

	// メンバー情報取得
	public Member findMember(int member_id);

	// 個人情報更新
	public void updateMember(@Param("member") Member member);

}
