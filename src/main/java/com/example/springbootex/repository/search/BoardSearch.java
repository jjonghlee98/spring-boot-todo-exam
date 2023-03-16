package com.example.springbootex.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.springbootex.domain.Board;

public interface BoardSearch {

	Page<Board> search1(Pageable pageable);
	
}
