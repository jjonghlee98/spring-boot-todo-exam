package com.example.springbootex.domain;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(length = 2000, nullable = false)
	private String content;
	
	@Column(length = 50, nullable = false)
	private String writer;
	
	public void change(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
}
