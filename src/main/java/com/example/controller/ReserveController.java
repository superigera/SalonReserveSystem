package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

	// メニュー画面
	@GetMapping("/new_reserve")
	public String menu() {
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
