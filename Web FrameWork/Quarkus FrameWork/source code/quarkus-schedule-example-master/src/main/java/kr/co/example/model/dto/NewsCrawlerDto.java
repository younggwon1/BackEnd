package kr.co.example.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsCrawlerDto {
	private String news_id;
    private String category;
    private String category_incident;
}
