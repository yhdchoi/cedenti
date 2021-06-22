package com.yhdc.cedenti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yhdc.cedenti.dto.BoardDTO;
import com.yhdc.cedenti.dto.PageRequestDTO;
import com.yhdc.cedenti.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	//LIST
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		
		log.info("list..." + pageRequestDTO);
		
		model.addAttribute("result", boardService.getList(pageRequestDTO));
	}
	
	
	// REGISTER
	@GetMapping("/register")
	public void register() {
		log.info("register get ...");
	}	
	
	@PostMapping("/register")
	public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		
		log.info("dto..." + dto);
		
		Long board_id = boardService.register(dto);
		
		log.info("BoardID..." + board_id);
		
		redirectAttributes.addFlashAttribute("msg", board_id);
		
		return "redirect:/board/list";
	}
	
	
	// GET
	@GetMapping({"/read", "/modify"})
	public void read(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long board_id, Model model) {
		
		log.info("board_id : " +board_id);
		
		BoardDTO boardDTO = boardService.get(board_id);
		
		log.info(boardDTO); 
		
		model.addAttribute("dto", boardDTO);
	}
	
	
	// DELETE
	@PostMapping("/remove")
	public String remove(Long board_id, RedirectAttributes redirectAttributes) {
		log.info("board_id: " + board_id);
		
		boardService.removeWithReplies(board_id);
		
		redirectAttributes.addFlashAttribute("msg", board_id);
		
		return "redirect:/board/list";
	}
	
		
	// MODIFY
	@PostMapping("/modify")
	public String modify(BoardDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes) {
		log.info("post modify......");
		log.info("dto: " + dto);
		
		boardService.modify(dto);
		
		redirectAttributes.addAttribute("page", requestDTO.getPage());
		redirectAttributes.addAttribute("type", requestDTO.getType());
		redirectAttributes.addAttribute("keyword", requestDTO.getKeyword());
		
		redirectAttributes.addAttribute("board_id", dto.getBoard_id());		
		
		return "redirect:/board/read";
	}	

}
