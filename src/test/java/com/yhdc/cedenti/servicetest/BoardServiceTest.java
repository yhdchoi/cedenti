package com.yhdc.cedenti.servicetest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.cedenti.dto.BoardDTO;
import com.yhdc.cedenti.service.BoardService;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	private BoardService boardService;

//	@Test
//	public void testRegister() {
//		BoardDTO dto = BoardDTO.builder().title("Test.").body("Test...").board_privacy("public").writerId(32L).build();
//
//		boardService.register(dto);
//	}
//
//	@Test
//	public void testList() {
//		PageRequestDTO pageRequestDTO = new PageRequestDTO();
//
//		PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);
//
//		for (BoardDTO boardDTO : result.getDtoList()) {
//			System.out.println(boardDTO);
//		}
//	}
//
//	@Test
//	public void testGet() {
//		Long board_id = 41L;
//
//		BoardDTO boardDTO = boardService.get(board_id);
//
//		System.out.println(boardDTO);
//	}
//
//	@Test
//	public void testRemove() {
//		Long board_id = 1L;
//
//		boardService.removeWithReplies(board_id);
//	}
	
	@Test
	public void testModify() {
		BoardDTO boardDTO = BoardDTO.builder().board_id(2L).title("New Title").body("New Body").build();
		
		boardService.modify(boardDTO);
	}
}
