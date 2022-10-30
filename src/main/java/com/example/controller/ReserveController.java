package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Menu;
import com.example.model.NonMember;
import com.example.service.MemberService;
import com.example.service.MenuService;
import com.example.service.ReservationsService;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

	@Autowired
	MemberService memberService;

	@Autowired
	MenuService menuService;

	@Autowired
	ReservationsService reservationsService;

	// メニュー画面
	@GetMapping("/new_reserve")
	public String menu(Model model) {
		// メニュー一覧取得
		List<Menu> menuList = menuService.getMenus();
		model.addAttribute("menuList", menuList);
		model.addAttribute("menus", menuList);

		return "reserve/menu";
	}

	// メニュー画面 検索
	@PostMapping("/search")
	public String menu_search(Model model, @RequestParam(name = "menu_id", defaultValue = "") Integer[] menuLists) {
		// メニュー一覧取得
		List<Menu> menuList = menuService.getMenus();
		model.addAttribute("menuList", menuList);

		List<Menu> menus = new ArrayList<>();
		for (int i = 0; i < menuLists.length; i++) {
			menus.addAll(menuService.SearchMenu(menuLists[i]));
		}
		System.out.println(menus);
		model.addAttribute("menus", menus);

		return "reserve/menu";
	}

	// 日時選択画面
	@PostMapping("/date_select")
	public String date_select(Model model, @ModelAttribute Menu menu) {

		return "reserve/date_select";
	}

	// 個人情報入力画面
	@PostMapping("/input_info")
	public String input_info(Model model, @ModelAttribute Menu menu, @RequestParam("time") String time,
			@RequestParam("day") String day, NonMember nonMember) {
		System.out.println(menu);
		int day_index = day.indexOf(".");
		String month = day.substring(0, 2);
		String days = day.substring(3);
//		List<Menu> menus = new ArrayList<>();
//		menus.addAll(menuService.SearchMenu(menu_id));
//		model.addAttribute("menus", menus);
		model.addAttribute("time", time);
		model.addAttribute("month", month);
		model.addAttribute("days", days);

		return "reserve/input_info";
	}

	// 予約確認画面
	@PostMapping("/confirm")
	public String confirm(Model model, @ModelAttribute Menu menu, NonMember nonMember,
			@RequestParam("month") String month, @RequestParam("time") String time, @RequestParam("days") String days) {

		model.addAttribute("time", time);
		model.addAttribute("month", month);
		model.addAttribute("days", days);

		return "reserve/confirm";
	}

	// DB登録
	@PostMapping("/reserve_register")
	public String reserve_register(Model model, @RequestParam("month") String month, @RequestParam("time") String time,
			@RequestParam("days") String days, NonMember nonMember, @RequestParam("menu_id") String menu_id) {
		System.out.println(menu_id);
		String reserve_day = month + "-" + days;
		reservationsService.reservations(menu_id, nonMember.getNon_member_name(), nonMember.getNon_member_email(),
				nonMember.getNon_member_phone_number(), reserve_day, time);
		return "top/top";
	}

}
