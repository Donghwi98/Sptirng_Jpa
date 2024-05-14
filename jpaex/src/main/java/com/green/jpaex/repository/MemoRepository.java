package com.green.jpaex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.jpaex.entity.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long>{

	Object findByMnoBetweenOrderByMnoDesc(long l, long m); // <Memo 는 칼럼명
	
}
