package com.yhdc.cedenti.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.cedenti.dto.BoardDTO;
import com.yhdc.cedenti.dto.PageRequestDTO;
import com.yhdc.cedenti.dto.PageResultDTO;
import com.yhdc.cedenti.model.Board;
import com.yhdc.cedenti.model.Member;
import com.yhdc.cedenti.repository.BoardRepository;
import com.yhdc.cedenti.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;

	// Post Board
	@Override
	public Long register(BoardDTO dto) {
		log.info(dto);
		Board board = dtoToEntity(dto);
		boardRepository.save(board);
		return board.getBno();
	}

	// Get Board Pages: forms PageResultDTO by using entityToDTO
	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		log.info(pageRequestDTO);

		Function<Object[], BoardDTO> fn = (en -> entityToDTO((Board) en[0], (Member) en[1], (Long) en[2]));

//		Page<Object[]> result = boardRepository
//				.getBoardWithReplyCount(pageRequestDTO.getPageable(Sort.by("bno").descending()));
		
		Page<Object[]> result = boardRepository.searchPage(
				pageRequestDTO.getType(),
				pageRequestDTO.getKeyword(),
				pageRequestDTO.getPageable(Sort.by("bno").descending())				
				);

		return new PageResultDTO<>(result, fn);
	}

	// Get Board with BoardID
	@Override
	public BoardDTO get(Long bno) {
		Object result = boardRepository.getBoardById(bno);

		Object[] arr = (Object[]) result;

		return entityToDTO((Board) arr[0], (Member) arr[1], (Long) arr[2]);
	}

	// Delete Board
	@Transactional
	@Override
	public void removeWithReplies(Long bno) {
		replyRepository.deleteByBoardId(bno);
		boardRepository.deleteById(bno);
	}

	// Modify Board
	@Transactional
	@Override
	public void modify(BoardDTO boardDTO) {
		Board board = boardRepository.getById(boardDTO.getBno());

		board.changeTitle(boardDTO.getTitle());
		board.changeBody(boardDTO.getBody());

		boardRepository.save(board);
	}
}
