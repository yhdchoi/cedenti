package com.yhdc.cedenti.repositorytest;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.cedenti.entity.Board;
import com.yhdc.cedenti.entity.Member;
import com.yhdc.cedenti.repository.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	public void insertBoards() {
		IntStream.rangeClosed(1, 50).forEach(i -> {
			
			Long l = Long.valueOf(i);

			Member member = Member.builder().member_id(l).build();

			Board board = Board.builder().title("Title..." + i).body("Body..." + i).board_privacy("Public")
					.writer(member).build();
			
			++l;
			boardRepository.save(board);
		});
	}
}
