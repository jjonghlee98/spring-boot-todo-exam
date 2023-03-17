package com.example.springbootex.service;

import com.example.springbootex.dto.BoardDTO;
import com.example.springbootex.dto.PageRequestDTO;
import com.example.springbootex.dto.PageResponseDTO;

public interface BoardService {
	
	Long register(BoardDTO boardDTO);
	
	BoardDTO readOnly(Long bno);
	
	void modify(BoardDTO boardDTO);
	
	void remove(Long bno);
	
	PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);
	
}
