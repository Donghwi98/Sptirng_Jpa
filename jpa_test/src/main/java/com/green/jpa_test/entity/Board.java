package com.green.jpa_test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String content;
	
	@ManyToOne
	@JoinColumn(name="user")
	@ToString.Exclude
	private User username;
}
