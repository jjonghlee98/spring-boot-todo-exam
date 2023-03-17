package com.example.springbootex.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

	@Builder.Default
	private int page = 1;

	@Builder.Default
	private int size = 10;

	private String type;

	private String keyword;

	public String[] getTypes() {

		if (type == null || type.isEmpty()) {
			return null;
		}

		return type.split("");

	}

	public Pageable getPageable(String... props) {
		return PageRequest.of(this.page - 1, this.size, Sort.by("bno").descending());
	}

	private String link;

	public String getLink() {
		StringBuilder builder = new StringBuilder();
		builder.append("page=" + this.page);
		builder.append("&size=" + this.size);

		if (type != null && type.length() > 0) {
			builder.append("&type=" + type);
		}

		if (keyword != null) {
			try {
				builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return builder.toString();

	}

}
