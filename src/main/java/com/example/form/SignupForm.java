package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class SignupForm {

	private Integer member_id;

	@NotBlank(groups = ValidGroup1.class)
	private String name;

	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String email;

	@NotBlank(groups = ValidGroup1.class)
	private String phone_number;

	@NotNull(groups = ValidGroup1.class)
	@Range(min = 0, max = 100, groups = ValidGroup2.class)
	private Integer age;

	@NotNull(groups = ValidGroup1.class)
	private Integer gender;

	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 4, max = 100, groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
	private String password;
}