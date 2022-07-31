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

import com.example.application.UserApplicationService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;
import com.example.model.Members;
import com.example.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/register")
@Slf4j
public class MemberRegisterController {

	@Autowired
	private UserApplicationService userApplicationService;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	// 新規登録画面
	@GetMapping("/new_register")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		return "register/new_register";
	}

	// 確認画面
	@PostMapping("/register_confirm")
	public String newMember(Model model, @ModelAttribute @Validated(GroupOrder.class) SignupForm form,
			BindingResult result) {

		if (result.hasErrors()) {
			return getSignup(model, form);
		}

		log.info(form.toString());

		Members members = modelMapper.map(form, Members.class);
		userService.signup(members);

		return "register/register_confirm";
	}
}
