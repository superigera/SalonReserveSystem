package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Menu;
import com.example.repository.MenuMapper;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menu_mapper;

	@Override
	public List<Menu> getMenus() {
		return menu_mapper.findMenu();
	}

	@Override
	public List<Menu> SearchMenu(int menu_id) {
		return menu_mapper.SearchMenu(menu_id);
	}

}
