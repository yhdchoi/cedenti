package com.yhdc.cedenti.service;

import java.util.List;

import com.yhdc.cedenti.dto.ReplyDTO;
import com.yhdc.cedenti.model.Board;
import com.yhdc.cedenti.model.Reply;

public interface ReplyService {

	// Save Reply
	Long register(ReplyDTO replyDTO);

	// Save reply to a specific Board
	List<ReplyDTO> getList(Long bno);

	// Modify Reply
	void modify(ReplyDTO replyDTO);

	// Delete Reply
	void remove(Long rno);

	// ReplyDTO is converted to Reply Object and carried with Board Object
	default Reply dtoToEntity(ReplyDTO replyDTO) {

		Board board = Board.builder().bno(replyDTO.getBno()).build();

		Reply reply = Reply.builder().rno(replyDTO.getRno()).replier(replyDTO.getReplier()).body(replyDTO.getBody())
				.reply_privacy(replyDTO.isReply_privacy()).board(board).build();

		return reply;
	}

	// ReplyDTO is converted to Reply Object and without the need of Board Object
	// ~ therefore only the BNO.
	default ReplyDTO entityToDTO(Reply reply) {

		ReplyDTO dto = ReplyDTO.builder().rno(reply.getRno()).replier(reply.getReplier()).body(reply.getBody())
				.reply_privacy(reply.isReply_privacy()).created(reply.getCreated()).updated(reply.getUpdated()).build();

		return dto;
	}
}
