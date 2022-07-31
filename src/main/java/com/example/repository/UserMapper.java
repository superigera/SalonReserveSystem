package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Members;

@Mapper
public interface UserMapper {

	// ユーザー登録
	public int insertOne(Members members);
}
