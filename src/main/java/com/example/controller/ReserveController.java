package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.model.Menu;
import com.example.service.MemberService;
import com.example.service.MenuService;

@Controller
@RequestMapping("/reserve")
@SessionAttributes(types = Menu.class)
public class ReserveController {

	@Autowired
	MemberService memberService;

	@Autowired
	MenuService menuService;

	// メニュー画面
	@GetMapping("/new_reserve")
	public String menu(Model model) {
		// メニュー一覧取得
		List<Menu> menuList = menuService.getMenus();
		model.addAttribute("menuList", menuList);
		model.addAttribute("menus", menuList);
		model.addAttribute("menu", new Menu());

		return "reserve/menu";
	}

	// メニュー画面 検索
	@PostMapping("/search")
	public String menu_search(@RequestParam("menu_id") Integer[] menuLists, Model model) {
		// メニュー一覧取得
		List<Menu> menuList = menuService.getMenus();
		model.addAttribute("menuList", menuList);

		List<Menu> menus = new ArrayList<>();
		for (int i = 0; i < menuLists.length; i++) {
			menus.addAll(menuService.SearchMenu(menuLists[i]));
		}
		System.out.println(menus);
		model.addAttribute("menus", menus);
		model.addAttribute("menu", new Menu());

		return "reserve/menu";
	}

	// 選択しているメニューに追加
	@PostMapping("/add")
	public String add_menu(Model model,
//			, HttpServletRequest request
			@RequestParam("menu_id") Integer menu_id) {
		// メニュー一覧取得
		List<Menu> menuList = menuService.getMenus();
		model.addAttribute("menuList", menuList);
		model.addAttribute("menus", menuList);
		model.addAttribute("menu", new Menu());

		List<Menu> add_menus = new ArrayList<>();
		add_menus.addAll(menuService.SearchMenu(menu_id));
		model.addAttribute("add_menus", add_menus);
//		System.out.println(request.getAttributeNames());

		return "reserve/menu";
	}

	// 日時選択画面 仮でGET
	@GetMapping("/date_select")
	public String date_select() {
		return "reserve/date_select";
	}

	// 個人情報入力画面 仮でGET
	@GetMapping("/input_info")
	public String input_info() {
		return "reserve/input_info";
	}

	// 予約確認画面 仮でGET
	@GetMapping("/confirm")
	public String confirm() {
		return "reserve/confirm";
	}
}
