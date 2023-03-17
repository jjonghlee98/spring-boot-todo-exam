package com.example.springbootex.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	
	private Long bno;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private LocalDateTime regDate;
	
	private LocalDateTime modDate;
	
}
