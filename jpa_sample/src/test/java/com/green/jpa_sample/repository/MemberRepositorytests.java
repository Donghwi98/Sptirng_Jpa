package com.green.jpa_sample.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.jpa_sample.entity.Member;
import com.green.jpa_sample.entity.Member.MemberBuilder;


@SpringBootTest
public class MemberRepositorytests {

	@Autowired
	MemberRepository memberRepository;

	@Test
	public void insert() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Member member = Member.builder()
					.email("user" + i + "@aaa.com")
					.password("1111")
					.name("User" + i)
					.build();
			memberRepository.save(member);
					
		});
		
		/*
		for(int i = 0; i < 100; i++) {
			Member member = new Member()
		}
		*/
	}
}
