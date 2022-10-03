package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Menu;

@Mapper
public interface MenuMapper {

	// メニュー全件取得
	public List<Menu> findMenu();

	// メニュー検索
	public List<Menu> SearchMenu(int menu_id);
}
