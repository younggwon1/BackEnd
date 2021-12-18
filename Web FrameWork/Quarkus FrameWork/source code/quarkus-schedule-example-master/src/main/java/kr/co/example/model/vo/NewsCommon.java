package kr.co.example.model.vo;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class NewsCommon {

	/**
	 *뉴스 키값 
	 */
	@Id
	protected String idsk;
	
}