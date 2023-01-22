package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.UserDetailsImpl;
import com.example.application.UserApplicationService;
import com.example.model.Member;
import com.example.model.Menu;
import com.example.model.Reserve;
import com.example.service.MemberService;
import com.example.service.MenuService;
import com.example.service.ReserveService;

@Controller
@RequestMapping("/login_page")
public class UserController {

	@Autowired
	ReserveService reserveService;

	@Autowired
	MenuService menuService;

	@Autowired
	private UserApplicationService userApplicationService;

	@Autowired
	MemberService memberService;

	@Autowired
	private ModelMapper modelMapper;

	// マイページ画面
	@GetMapping("/mypage")
	public String mypage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		// 日付取得
		Date d = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMdd");
		String today = d1.format(d);

		List<Reserve> ReserveList = reserveService.findReserve(userDetails.getMember_id(), today);
		List<Menu> menus = new ArrayList<>();
		for (Reserve reserve : ReserveList) {
			menus = menuService.SearchMenu(reserve.getMenu_id());
			for (Menu menu : menus) {
				String name = menu.getMenu_name();
				Integer times = menu.getMenu_times();
				reserve.setMenu_name(name);
				reserve.setMenu_times(times);
			}
		}
		model.addAttribute("ReserveList", ReserveList);

		List<Reserve> pastReserveList = reserveService.findPastReserve(userDetails.getMember_id(), today);
		model.addAttribute("pastReserveList", pastReserveList);

		return "login/mypage";
	}

	// マイページ画面キャンセル
	@PostMapping("/mypage_cancel")
	public String mypage_cancel(Model model, @RequestParam("cancel_id") String cancel_id) {

		// 予約キャンセル
		reserveService.cancelReserve(cancel_id);
		return "redirect:/login_page/mypage";
	}

	// 個人情報更新画面
	@GetMapping("/update_info")
	public String update_info(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		Member member_info_list = memberService.findMember(userDetails.getMember_id());
		model.addAttribute("member_info_list", member_info_list);
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		return "login/update_info";
	}

	// DB更新
	@PostMapping("/update_info")
	public String update(Model model, Member member_list_info, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		Member member = modelMapper.map(member_list_info, Member.class);
		memberService.updateMember(member);
		return "login/mypage";
	}
}
