package com.yhdc.cedenti.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yhdc.cedenti.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
	
	@Query("SELECT b, w FROM Board b LEFT JOIN b.writer w WHERE b.board_id = :board_id")
	Object getBoardWithWriter(@Param("board_id") Long board_id);
	
	@Query("SELECT b, r FROM Board b LEFT JOIN Reply r ON r.board = b WHERE b.board_id = :board_id")
	List<Object[]> getBoardWithReply(@Param("board_id") Long board_id);
	
	@Query(value = "SELECT b, w, count(r) FROM Board b LEFT JOIN b.writer w LEFT JOIN Reply r ON r.board = b GROUP BY b", 
			countQuery = "SELECT count(b) FROM Board b")	
	Page<Object[]> getBoardWithReplyCount(Pageable pageable);
	
	@Query("SELECT b, w, count(r) FROM Board b LEFT JOIN b.writer w LEFT OUTER JOIN Reply r ON r.board = b WHERE b.board_id = :board_id")
	Object getBoardById(@Param("board_id") Long Board_id);
	
	
}
