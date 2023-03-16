package com.example.springbootex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springbootex.domain.Board;
import com.example.springbootex.repository.search.BoardSearch;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

	@Query(value = "select now()", nativeQuery = true)
	String getTime();
	
}
