package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

	// ajaxのデータでカレンダーに渡す
	@GetMapping("/ajax_reserve")
	public @ResponseBody List<String> ajax_reserve() {
		List<String> test1 = new ArrayList<>();
		test1.add("20230130T0900");
		test1.add("20230131T0900");

		// serveice使ってSQLで下記の形式で取得しリストに代入
		// endの為にも、menu_idでMENUと結合してtimeも取得
		// reserve_days + "T" + reserve_time
		// 上記をreturnし、javascriptでeventsをループする
		// startは上記、endはstart + time

		return test1;
	}

}
