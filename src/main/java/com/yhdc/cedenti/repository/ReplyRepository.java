package com.yhdc.cedenti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yhdc.cedenti.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{

	@Modifying
	@Query("DELETE FROM Reply r WHERE r.board.board_id = :board_id")
	void deleteByBoardId(@Param("board_id") Long board_id);
	
}
