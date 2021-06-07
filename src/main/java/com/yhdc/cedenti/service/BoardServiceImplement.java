package com.yhdc.cedenti.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yhdc.cedenti.dto.BoardDTO;
import com.yhdc.cedenti.dto.PageRequestDTO;
import com.yhdc.cedenti.dto.PageResultDTO;
import com.yhdc.cedenti.entity.Board;
import com.yhdc.cedenti.entity.Member;
import com.yhdc.cedenti.repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImplement implements BoardService {

	private final BoardRepository boardRepository;

	@Override
	public Long register(BoardDTO dto) {
		log.info(dto);
		Board board = dtoToEntity(dto);
		boardRepository.save(board);
		return board.getBoard_id();
	}

	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {

		log.info(pageRequestDTO);

		Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board) en[0], (Member) en[1], (Long) en[2]));

		Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("board_id").descending()));
		
		return new PageResultDTO<>(result, fn);
	}
}

