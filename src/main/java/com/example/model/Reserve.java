package com.example.model;

import lombok.Data;

@Data
public class Reserve {

	private Integer reservations_id;

	private Integer menu_id;

	private Integer member_id;

	private String non_member_name;

	private String non_member_email;

	private String non_member_phone_number;

	private String reserve_days;

	private String reserve_time;

	private String date_up;

	private String menu_name;

	private Integer menu_times;
}
