package com.example.springbootex.repository.search;

import java.util.List;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import com.example.springbootex.domain.Board;
import com.example.springbootex.domain.QBoard;

public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

	public BoardSearchImpl() {
		super(Board.class);
	}

	@Override
	public Page<Board> search1(Pageable pageable) {

		QBoard board = QBoard.board; // QBoard 객체

		JPQLQuery<Board> query = from(board); // select ... from board

		BooleanBuilder booleanBuilder = new BooleanBuilder(); // (

		booleanBuilder.or(board.title.contains("11")); // title like ...

		booleanBuilder.or(board.content.contains("11")); // content like ...

		query.where(booleanBuilder);

		query.where(board.bno.gt(0L));

		this.getQuerydsl().applyPagination(pageable, query);

		List<Board> list = query.fetch();

		long count = query.fetchCount();

		return null;
	}

	@Override
	public Page<Board> searchAll(String[] types, String keyword, Pageable pageable) {

		QBoard board = QBoard.board;
		JPQLQuery<Board> query = from(board);

		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if ((types != null && types.length > 0) && keyword != null) {
			
			for (String type: types) {
				
				switch (type) {
				case "t":
					booleanBuilder.or(board.title.contains("1"));
					break;
				case "c":
					booleanBuilder.or(board.content.contains("1"));
					break;
				case "w":
					booleanBuilder.or(board.writer.contains("1"));
					break;
				}
				
			}// for end
			query.where(booleanBuilder);
		} // if end

		query.where(board.bno.gt(0L));
		
		this.getQuerydsl().applyPagination(pageable, query);
		
		List<Board> list = query.fetch();
		
		long count = query.fetchCount();
		
		return new PageImpl<>(list, pageable, count);
	}

}
