package com.yhdc.cedenti.repositorytest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.cedenti.model.Board;
import com.yhdc.cedenti.model.Member;
import com.yhdc.cedenti.repository.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	public void insertBoards() {
		IntStream.rangeClosed(1, 50).forEach(i -> {

			Long no = (long) (Math.random() * 50) + 1;

			Member member = Member.builder().member_id(no).build();

			Board board = Board.builder().title("Title..." + i).body("Body..." + i).board_privacy("Public")
					.writer(member).build();

			boardRepository.save(board);
		});
	}
	
//	@Transactional
//	@Test
//	public void testRead1() {
//		Optional<Board> result = boardRepository.findById(23L);
//		
//		Board board = result.get();
//		
//		System.out.println(board);
//		System.out.println(board.getWriter());
//	}
//	
//	@Test
//	public void testReadWithWriter() {
//		Object result = boardRepository.getBoardWithWriter(28L);
//		
//		Object[] arr = (Object[])result;
//		
//		System.out.println(Arrays.toString(arr));
//	}
//	
//	@Test
//	public void testGetBoardWithReply() {
//		List<Object[]> result =boardRepository.getBoardWithReply(16L);
//		
//		for (Object[] arr : result) {
//			System.out.println(Arrays.toString(arr));
//		}
//	}
//	
//	@Test
//	public void testWithReplyCount() {
//		Pageable pageable = PageRequest.of(0, 10, Sort.by("board_id").descending());
//		
//		Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);
//		
//		result.get().forEach(row -> {
//			Object[] arr = (Object[])row;
//			System.out.println(Arrays.toString(arr));
//		});
//	}
//	
//	@Test
//	public void testRead3() {
//		Object result = boardRepository.getBoardById(28L);
//		
//		Object[] arr = (Object[])result;
//		
//		System.out.println(Arrays.toString(arr));
//	}
	
}
