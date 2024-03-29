package com.yhdc.cedenti.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

	private Long bno;
	private String title;
	private String body;
	private boolean board_privacy;
	
	private Long writerId;
	private String writerUsername;
	
	private LocalDateTime created;
	private LocalDateTime updated;
	
	private int replyCount;	
}
