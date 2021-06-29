package com.yhdc.cedenti.repositorytest;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.cedenti.model.Board;
import com.yhdc.cedenti.model.Reply;
import com.yhdc.cedenti.repository.ReplyRepository;

@SpringBootTest
public class ReplyRepositoryTest {

	@Autowired
	private ReplyRepository replyRepository;

//	@Test
//	public void insertReplies() {
//
//		IntStream.rangeClosed(1, 100).forEach(i -> {
//
//			Long no = (long) (Math.random() * 50) + 1;
//
//			Board board = Board.builder().bno(no).build();
//
//			Reply reply = Reply.builder().replier("guest"+i).body("Body..." + i).reply_privacy(false).board(board)
//					.build();
//
//			replyRepository.save(reply);
//		});
//	}
	
//	@Transactional
//	@Test
//	public void readReply1() {
//		Optional<Reply> result = replyRepository.findById(36L);
//		
//		Reply reply = result.get();
//		
//		System.out.println(reply);
//		System.out.println(reply.getBoard());
//	}
	
	@Test 
	public void testListByBoard() {
		List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(6L).build());
		
		replyList.forEach(reply -> System.out.println(reply));
	}
}
