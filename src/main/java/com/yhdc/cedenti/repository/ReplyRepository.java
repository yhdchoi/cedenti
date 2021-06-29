package com.yhdc.cedenti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yhdc.cedenti.model.Board;
import com.yhdc.cedenti.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{

	@Modifying
	@Query("DELETE FROM Reply r WHERE r.board.bno = :bno")
	void deleteByBoardId(@Param("bno") Long bno);
	
	// Get Reply by Board
	List<Reply> getRepliesByBoardOrderByRno(Board board);
	
	
}
