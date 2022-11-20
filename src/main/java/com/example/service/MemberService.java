package com.example.service;

import org.apache.ibatis.annotations.Param;

import com.example.model.Member;

public interface MemberService {

	// ユーザー登録
	public void signup(Member member);

	// メンバー情報取得
	public Member findMember(int member_id);

	// 個人情報更新
	public void updateMember(@Param("member") Member member);
}
