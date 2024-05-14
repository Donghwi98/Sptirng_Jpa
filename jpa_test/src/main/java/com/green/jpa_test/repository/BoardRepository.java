package com.green.jpa_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jpa_test.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
}
