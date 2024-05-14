package com.green.jpaEx_QM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jpaEx_QM.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	//저자 이름으로 조회하기
	List<Book> findByAuthor(String author);
	
	//가격으로 조회하기 - 얼마 이하
	List<Book> findByPriceLessThanEqual(int price);
	
	//가격으로 조회하기 - 얼마 미만
	List<Book> findByPriceLessThan(int price);
	
	//가격으로 조회하기 - 10000원 ~ 20000원
	List<Book> findByPriceBetween(int price1, int price2);

	
	//제목으로 조회하기 - "Java"라는 문자열이 포함되어있는 제목의 책
	List<Book> findByTitleLike(String title);

}
