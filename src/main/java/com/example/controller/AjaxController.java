package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Events;
import com.example.service.ReserveServiceImpl;

@RestController
public class AjaxController {
	@Autowired
	ReserveServiceImpl reserveServiceImpl;

	// ajaxのデータでカレンダーに渡す
	@GetMapping("/ajax_reserve")
	public @ResponseBody List<Events> ajax_reserve(@RequestParam("menu_time") String menu_time) {
		System.out.println(menu_time);

		List<Events> list = new ArrayList<>();
		list.addAll(reserveServiceImpl.reserveDuplicationCheck());

		List<Events> test = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			Events events = new Events();
			events.setTitle("不可");
			events.setStart(list.get(i).getReserve_days() + "T" + list.get(i).getReserve_time());

			String end = "";
			if (Integer.valueOf(list.get(i).getMenu_times()) >= 60) {
				int result = Integer.valueOf(list.get(i).getMenu_times()) + 40
						+ Integer.valueOf(list.get(i).getReserve_time());

				end = Integer.valueOf(result).toString();
			} else {
				int result = Integer.valueOf(list.get(i).getMenu_times())
						+ Integer.valueOf(list.get(i).getReserve_time());
				end = Integer.valueOf(result).toString();
			}
			events.setEnd(list.get(i).getReserve_days() + "T" + end);

			test.add(events);
		}
		return test;
	}

}
