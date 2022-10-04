package com.example.service;

import java.util.List;

import com.example.model.Menu;

public interface MenuService {

	// メニュー取得
	public List<Menu> getMenus();

	// メニュー検索
	public List<Menu> SearchMenu(int menu_Id);
}
