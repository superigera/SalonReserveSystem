package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login_page")
public class LoginController {

	// ログイン画面
	@GetMapping("/input_login")
	public String getLogin() {
		return "login/login";
	}

	@PostMapping("/input_login")
	public String postLogin() {
		return "login/login";
	}

}
