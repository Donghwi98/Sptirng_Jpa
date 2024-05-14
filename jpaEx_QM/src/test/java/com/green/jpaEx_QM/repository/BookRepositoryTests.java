package com.green.jpaEx_QM.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.jpaEx_QM.entity.Book;

@SpringBootTest
public class BookRepositoryTests {
	
	@Autowired
	BookRepository bookRepository;
	
	//@Test
	public void insert() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			Book book = Book.builder()
					.title("Jave " + 1)
					.author("aaa")
					.publisher("green")
					.price(5000)
					.build();
			
			bookRepository.save(book);
		});
		/*
		for(int i = 0; i < 10; i++) {
			Book book = new Book("java " + 1 "aaa", "green", 5000);
			bookRepository.save(book);
		}
		*/
	}
	
	//@Test
	public void findByAuthor() {
		//저자 이름으로 조회하기 : findByAuthor(문자열)

		List<Book> list = bookRepository.findByAuthor("aaa");
		
		for(Book book : list) {
			System.out.println(book);
		}
	
	
	}
	
	
	//@Test
	public void findByPrice() {
		//가격으로 조회하기 - 8000원이하만 책 조회하기
		List<Book> list = bookRepository.findByPriceLessThanEqual(8000);
		
		for(Book book : list) {
			System.out.println(book);
		}
		
	}
	
	//@Test
	public void findByPrice2() {
		//가격으로 조회하기 - 8000원이하만 책 조회하기
		List<Book> list = bookRepository.findByPriceLessThan(8000);
		
		for(Book book : list) {
			System.out.println(book);
		}
		
	}
	
	
	//@Test
	public void findByPrice3() {
		List<Book> list = bookRepository.findByPriceBetween(10000, 20000);
		
		for(Book book : list) {
			System.out.println(book);
		}
	} 
	
	
	@Test
	public void findByTitle() {
		List<Book> list = bookRepository.findByTitleLike("%Java%");
		
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
	
	
	
	
	
	
}
