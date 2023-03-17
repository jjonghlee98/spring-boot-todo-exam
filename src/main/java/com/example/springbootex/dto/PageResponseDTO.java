package com.example.springbootex.dto;

import java.util.List;

import lombok.*;

@Getter
@ToString
public class PageResponseDTO<E> {

	private int page;
	
	private int size;
	
	private int total;
	
	private int start;
	
	private int end;
	
	private int last;
	
	private boolean prev;
	
	private boolean next;
	
	private List<E> dtoList;
	
	@Builder(builderMethodName = "withAll")
	public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
		
		if (total <= 0) {
			return;
		}
		
		this.page = pageRequestDTO.getPage();
		this.size = pageRequestDTO.getSize();
		
		this.total = total;
		this.dtoList = dtoList;
		
		this.end = (int)(Math.ceil(this.page / 10.0)) * 10;
		this.start = end - 9;
		
		this.last = (int)(Math.ceil(total / (double)this.size));
		this.end = end > last ? last : end;
		
		this.prev = start > 1;
		this.next = total > this.end * this.size;
		
	}
	
}
