package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login_page")
public class LoginController {

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
	public String admin() {
		return "login/admin";
	}

	// 予約登録画面
	@GetMapping("/reserve_register")
	public String reserve_register() {
		return "login/reserve_register";
	}

}
