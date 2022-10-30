package com.example.model;

import lombok.Data;

@Data
public class Reservations {
	private String reservations_id;

	private String menu_id;

	private String member_id;

	private String non_member_nane;

	private String non_member_email;

	private String non_member_phone_number;

	private String reserve_days;

	private String reserve_time;

	private String date_up;

}
