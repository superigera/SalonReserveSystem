package com.example.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Menu;
import com.example.repository.MenuMapper;

@Mapper
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menu_mapper;

	@Override
	public List<Menu> getMenus() {
		return menu_mapper.findMenu();
	}

}
