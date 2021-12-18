package kr.co.example.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "news_cat")
public class NewsCat extends NewsCommon{

	/**
	 *뉴스 종류  
	 */
	@Column(columnDefinition = "TEXT")
	private String category;

	
	@Column(columnDefinition = "TEXT")
	private String category_incident;
	
}
