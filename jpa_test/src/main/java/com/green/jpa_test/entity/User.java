package com.green.jpa_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
	@Id
	private String username;
	private String password;
	private String name;
	private String tel;
	
	public User(String username) {
		this.username = username;
	}
	
	
}
