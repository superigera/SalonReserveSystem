package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.MemberService;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

	@Autowired
	MemberService memberService;

	@Autowired
//	private MenuService menuService;

	// メニュー画面
	@GetMapping("/new_reserve")
	public String menu() {

		// メニュー一覧取得
//		List<Menu> menuList = menuService.getMenus();
//
//		model.addAttribute("menuList", menuList);

		return "reserve/menu";
	}

	// メニュー画面 検索
	@PostMapping("/new_reserve")
	public String menu_search() {
		return "redirect:/reserve/new_reserve";
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
