package com.green.jpaex.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // JPA로 관리되는 객체라는 표시.
@Table(name = "tbl_memo")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement 자동부여
	private Long mno;
	
	@Column(length = 200, nullable = false)
	private String memoText;
	
	public Memo(String memoText) {
		this.memoText = memoText;
	}
	
}
