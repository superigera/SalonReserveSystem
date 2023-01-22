package com.example.model;

import lombok.Data;

@Data
public class Member {

	private Integer member_id;

	private String name;

	private String email;

	private String phone_number;

	private Integer age;

	private Integer gender;

	private String password;

	private String authority;

	private String created_at;

	private String update_at;

}
