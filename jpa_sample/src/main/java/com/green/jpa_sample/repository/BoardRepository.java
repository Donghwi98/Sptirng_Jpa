package com.green.jpa_sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jpa_sample.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
