package com.yhdc.cedenti.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyDTO {

	private Long rno;
	private String replier;
	private String body;
	private boolean reply_privacy;
	
	private Long bno;
	
	private LocalDateTime created;
	private LocalDateTime updated;
}
