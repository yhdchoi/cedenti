package com.yhdc.cedenti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.cedenti.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
}
