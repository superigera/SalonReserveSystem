package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Menu;
import com.example.model.Reserve;
import com.example.service.MenuService;
import com.example.service.ReserveService;

@Controller
@RequestMapping("/login_page")
public class LoginController {

	@Autowired
	ReserveService reserveService;

	@Autowired
	MenuService menuService;

	// ログイン画面
	@GetMapping("/input_login")
	public String login() {
		return "login/login";
	}

	// マイページ画面
	@GetMapping("/mypage")
	public String mypage() {
		return "login/mypage";
	}

	// 個人情報更新画面
	@GetMapping("/update_info")
	public String update_info() {
		return "login/update_info";
	}

	// アドミン画面
	@GetMapping("/admin")
	public String admin(Model model) {
		// 日付取得
		Date d = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat d2 = new SimpleDateFormat("Hmm");
		String today = d1.format(d);
		String time = d2.format(d);

		// 本日予約全件取得
		List<Reserve> ReserveList = reserveService.findTodayReserve(today);
		model.addAttribute("ReserveList", ReserveList);
		model.addAttribute("time", time);

		return "login/admin";
	}

	// アドミン画面検索
	@PostMapping("/admin_search")
	public String admin_sarch(Model model, @RequestParam("search_day") String search_day,
			@RequestParam("search_name") String search_name) {

		search_day = search_day.replace("-", "");

		// 検索予約取得
		List<Reserve> ReserveList = reserveService.findSearchReserve(search_day, search_name);
		model.addAttribute("ReserveList", ReserveList);

		return "login/admin";
	}

	// 予約登録画面
	@GetMapping("/register")
	public String register(Model model, Reserve reserve) {
		// メニュー一覧取得
		List<Menu> menuList = menuService.getMenus();
		model.addAttribute("menuList", menuList);

		return "login/reserve_register";
	}

	// DB登録
	@PostMapping("/reserve_register")
	public String reserve_register(Model model, Reserve reserve, @RequestParam("menu_id") String menu_id,
			@RequestParam("reserve_date") String reserve_date, @RequestParam("time") String time) {
		reserve_date = reserve_date.replace("-", "");
		reserveService.reservations(menu_id, reserve.getNon_member_name(), null, reserve.getNon_member_phone_number(),
				reserve_date, time);

		return "redirect:/login_page/admin";
	}

}
