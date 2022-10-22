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

import com.example.model.Member;
import com.example.model.Menu;
import com.example.service.MemberService;
import com.example.service.MenuService;

@Controller
@RequestMapping("/reserve")
//@SessionAttributes(types = Menu.class)
public class ReserveController {

	@Autowired
	MemberService memberService;

	@Autowired
	MenuService menuService;

	// メニュー画面
	@GetMapping("/new_reserve")
	public String menu(Model model, Menu menu) {
		// メニュー一覧取得
		List<Menu> menuList = menuService.getMenus();
		model.addAttribute("menuList", menuList);
		model.addAttribute("menus", menuList);

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

	// 日時選択画面
	@PostMapping("/date_select")
	public String date_select(@RequestParam("menu_id") Integer[] menuLists, Model model) {
		System.out.println(menuLists.toString());
		List<Menu> menus = new ArrayList<>();
		for (int i = 0; i < menuLists.length; i++) {
			menus.addAll(menuService.SearchMenu(menuLists[i]));
		}

		model.addAttribute("menus", menus);
		model.addAttribute("menu", new Menu());
		return "reserve/date_select";
	}

	// 個人情報入力画面
	@PostMapping("/input_info")
	public String input_info(Model model, @RequestParam("menu_id") Integer menu_id, @RequestParam("time") Integer time,
			@RequestParam("day") String day, Member member) {

		int day_index = day.indexOf(".");
		String month = day.substring(0, 2);
		String days = day.substring(3);
		List<Menu> menus = new ArrayList<>();
		menus.addAll(menuService.SearchMenu(menu_id));
		model.addAttribute("menus", menus);
		model.addAttribute("time", time);
		model.addAttribute("month", month);
		model.addAttribute("days", days);

		return "reserve/input_info";
	}

	// 予約確認画面
	@PostMapping("/confirm")
	public String confirm(Member member) {
		System.out.println(member);
		return "reserve/confirm";
	}
}
