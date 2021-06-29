package com.yhdc.cedenti.servicetest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yhdc.cedenti.dto.ReplyDTO;
import com.yhdc.cedenti.service.ReplyService;

@SpringBootTest
public class ReplyServiceTest {

	@Autowired
	private ReplyService replyService;
	
	@Test
	public void testGetList() {
		Long bno = 1L;
		
		List<ReplyDTO> replyDTOList = replyService.getList(bno);
		
		replyDTOList.forEach(replyDTO -> System.out.println(replyDTO));
				
	}
}
