package com.example.springbootex.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springbootex.dto.BoardDTO;
import com.example.springbootex.dto.PageRequestDTO;
import com.example.springbootex.dto.PageResponseDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

	@Autowired
	private BoardService boardService;
	
//	@Test
//	public void testRegister() {
//		
//		BoardDTO boardDTO = BoardDTO.builder()
//				.title("Sample Title....")
//				.content("Sample Content....")
//				.writer("user00")
//				.build();
//		
//		Long bno = boardService.register(boardDTO);
//		
//		log.info("bno: " + bno);
//		
//	}
	
//	@Test
//	public void testModify() {
//		
//		BoardDTO boardDTO = BoardDTO.builder()
//				.bno(101L)
//				.title("Updated title....101")
//				.content("Updated content....101")
//				.build();
//		
//		boardService.modify(boardDTO);
//		
//	}
	
	@Test
	public void testList() {
		
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
				.type("tcw")
				.keyword("1")
				.page(1)
				.size(10)
				.build();
		
		PageResponseDTO<BoardDTO> pageResponseDTO = boardService.list(pageRequestDTO);
		
		log.info(pageResponseDTO);
		
	}
	
}
