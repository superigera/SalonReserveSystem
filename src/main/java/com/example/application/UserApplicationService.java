package com.example.application;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

	public Map<String, Integer> getGenderMap() {
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		genderMap.put("男性", 1);
		genderMap.put("女性", 2);
		genderMap.put("その他", 3);
		return genderMap;
	}
}
