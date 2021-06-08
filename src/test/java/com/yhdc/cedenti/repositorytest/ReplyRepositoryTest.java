package com.yhdc.cedenti.repositorytest;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.cedenti.entity.Board;
import com.yhdc.cedenti.entity.Reply;
import com.yhdc.cedenti.repository.ReplyRepository;

@SpringBootTest
public class ReplyRepositoryTest {

	@Autowired
	private ReplyRepository replyRepository;

	@Test
	public void insertReplies() {

		IntStream.rangeClosed(1, 50).forEach(i -> {

			Long no = (long) (Math.random() * 50) + 1;

			Board board = Board.builder().board_id(no).build();

			Reply reply = Reply.builder().replier("guest").body("Body..." + i).reply_privacy("public").board(board)
					.build();

			replyRepository.save(reply);
		});
	}
	
	@Transactional
	@Test
	public void readReply1() {
		Optional<Reply> result = replyRepository.findById(36L);
		
		Reply reply = result.get();
		
		System.out.println(reply);
		System.out.println(reply.getBoard());
	}
}
