package com.yhdc.cedenti.service;

import com.yhdc.cedenti.dto.BoardDTO;
import com.yhdc.cedenti.dto.PageRequestDTO;
import com.yhdc.cedenti.dto.PageResultDTO;
import com.yhdc.cedenti.model.Board;
import com.yhdc.cedenti.model.Member;

public interface BoardService {

	Long register(BoardDTO dto);

	PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

	// Get Board with BoardID
	BoardDTO get(Long bno);

	// Delete Board with BoardID
	void removeWithReplies(Long bno);
	
	// Modify Board
	void modify(BoardDTO boardDTO);

	// Post Board
	default Board dtoToEntity(BoardDTO dto) {

		Member member = Member.builder().mno(dto.getWriterId()).build();

		Board board = Board.builder().bno(dto.getBno()).title(dto.getTitle()).body(dto.getBody())
				.board_privacy(dto.isBoard_privacy()).writer(member).build();

		return board;
	}

	// List Board
	default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {

		BoardDTO boardDTO = BoardDTO.builder().bno(board.getBno()).title(board.getTitle())
				.body(board.getBody()).board_privacy(board.isBoard_privacy()).writerId(member.getMno())
				.writerUsername(member.getUsername()).created(board.getCreated()).updated(board.getUpdated())
				.replyCount(replyCount.intValue()).build();

		return boardDTO;
	}

}
