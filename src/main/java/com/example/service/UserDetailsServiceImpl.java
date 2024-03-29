package com.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			String sql = "SELECT * FROM members WHERE email = ?";
			Map<String, Object> map = jdbcTemplate.queryForMap(sql, username);
			String password = (String) map.get("password");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority((String) map.get("authority")));
			Integer member_id = (Integer) map.get("member_id");
			return new UserDetailsImpl(username, password, authorities, member_id);
		} catch (Exception e) {
			System.out.println(e);
			throw new UsernameNotFoundException("user not found.", e);
		}
	}

	public boolean isExistUser(String email) {
		String sql = "SELECT COUNT(*) FROM members WHERE email = ?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, new Object[] { email });
		if (count == 0) {
			return false;
		}
		return true;
	}

}
