package com.green.jpaex.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.jpaex.entity.Memo;

@SpringBootTest
public class MemoRepositoryTests {
	@Autowired
	MemoRepository memoRepository;
	
	//@Test
	public void testInsertDummies() {
		for(int i = 0; i < 100; i++) {
			Memo memo = new Memo("Sample..." + i);
			memoRepository.save(memo);
		}
	}
	
	//@Test
	public void testSelect() {
		
		Long mno = 100L; // Long 타입이라 L 붙힘 int면 안붙혀도됨.
		
		Optional<Memo> result = memoRepository.findById(mno); // findById = 쿼리메소드 (쿼리로 바뀜 -> select로 바뀜)
		System.out.println("=====================");
		
		if(result.isPresent()) { // isPresent() == 있을때
			Memo memo = result.get();
			System.out.println(memo);
		}
		
	}
	
	//@Test
	public void testUpdate() {
		Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
		System.out.println(memoRepository.save(memo));
	}
	
	//@Test
	public void deleteUpdate() {
		Long mno = 100L;
		
		memoRepository.deleteById(mno);
	}
	
	//@Test
	public void testSelectAll() {
		List<Memo> list = memoRepository.findAll();
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void testCount() {
		long cnt = memoRepository.count();
		
		System.out.println("cnt : " + cnt);
		
		assertEquals(cnt, 100);
	}
	
}
