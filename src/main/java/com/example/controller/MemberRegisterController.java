package com.example.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.application.UserApplicationService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;
import com.example.model.Member;
import com.example.service.MemberService;

@Controller
@RequestMapping("/register")
public class MemberRegisterController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserApplicationService userApplicationService;

	// 新規登録画面表示
	@GetMapping("/new_register")
	public String newRegister(Model model, @Validated @ModelAttribute SignupForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		return "register/new_register";
	}

	// 新規登録確認画面表示
	@PostMapping("/post_confirm")
	public String postConfirm(Model model, @RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phone_number") String phone_number, @RequestParam("age") String age,
			@RequestParam("gender") String gender, @RequestParam("password") String password,
			@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult result) {
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone_number", phone_number);
		model.addAttribute("age", age);
		model.addAttribute("gender", gender);
		model.addAttribute("password", password);

		if (result.hasErrors()) {
			return newRegister(model, form);
		}

		return "register/register_confirm";
	}

	// DB登録
	@PostMapping("/confirm")
	public String confirmRegister(Model model, @ModelAttribute @Validated(GroupOrder.class) SignupForm form) {

		Member member = modelMapper.map(form, Member.class);

		memberService.signup(member);

		return "top/top";
	}
}
