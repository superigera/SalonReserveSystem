package com.example;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Collection<GrantedAuthority> authorities;
	private String member_id;

	public UserDetailsImpl(String username, String password, Collection<GrantedAuthority> authorities,
			String member_id) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.member_id = member_id;
	}

	// 権限リストを返す
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	// パスワードを返す
	@Override
	public String getPassword() {
		return password;
	}

	// ユーザー名を返す
	@Override
	public String getUsername() {
		return username;
	}

	// メンバーIDを返す
	public String getMember_id() {
		return member_id;
	}

	// アカウントの有効期限の判定
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// アカウントのロック状態の判定
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 資格情報の有効期限の判定
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 有効なユーザーであるかの判定
	@Override
	public boolean isEnabled() {
		return true;
	}
}