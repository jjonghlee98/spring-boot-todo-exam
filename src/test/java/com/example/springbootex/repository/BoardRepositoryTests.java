package com.example.springbootex.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.springbootex.domain.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	public void testInsert() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Board board = Board.builder()
					.title("title..........")
					.content("content..........")
					.writer("writer: " + (i % 10))
					.build();
			
			boardRepository.save(board);
			log.info("BNO: " + board.getBno());
		});
	}
	
	@Test
	public void testSelect() {
		Long bno = 100L;
		
		Optional<Board> result = boardRepository.findById(bno);
		
		Board board = result.orElseThrow();
		
		log.info(board);
	}
	
	@Test
	public void testUpdate() {
		Long bno = 100L;
		
		Optional<Board> result = boardRepository.findById(bno);
		
		Board board = result.orElseThrow();
		
		board.change("change title.....", "change content.....");
		
		boardRepository.save(board);
		
	}
	
	/* 이미 삭제되어 있는 bno이기 때문에 gradle build 하면 error로 뜸. 당연한 결과임 */
	@Test
	public void testDelete() {
		Long bno = 1L;
		
		boardRepository.deleteById(bno);
	}
	
	@Test
	public void testPaging() {
		Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
		
		Page<Board> result = boardRepository.findAll(pageable);
	}
	
	@Test
	public void testSearch1() {
		Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());
		
		boardRepository.search1(pageable);
	}
	
	@Test
	public void testSearchAll() {
		String[] types = {"t", "c", "w"};
		
		String keyword = "1";
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
		
		Page<Board> result = boardRepository.searchAll(types,  keyword, pageable);
		
		log.info(result.getTotalPages());
		
		log.info(result.getSize());
		
		log.info(result.getNumber());
		
		log.info(result.hasPrevious() + ": " + result.hasNext());
		
		result.getContent().forEach(board -> log.info(board));
	}
	
}
