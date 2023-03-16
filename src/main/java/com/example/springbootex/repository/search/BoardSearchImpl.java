package com.example.springbootex.repository.search;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.example.springbootex.domain.Board;
import com.example.springbootex.domain.QBoard;
import com.querydsl.jpa.JPQLQuery;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

	public BoardSearchImpl() {
		super(Board.class);
	}

	@Override
	public Page<Board> search1(Pageable pageable) {
		
		QBoard board = QBoard.board;
		
		JPQLQuery<Board> query = from(board); // select.. from board
		
		query.where(board.title.contains("1")); // where title like ...
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<Board> list = query.fetch();
		
		long count = query.fetchCount();
		
		return null;
	}

}
