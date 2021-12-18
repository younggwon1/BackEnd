package kr.co.example.code;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum NewsPaperCode {
	O_023("조선일보", "023"),  
	;
	
	public String nm;
	public String code;

	/**
	 * return news code map
	 * @return
	 */
	public static HashMap<String, String> getAllCodeStringMap() {
		HashMap<String, String> codeMap = new HashMap<>();
		for (NewsPaperCode c : values()) {
			codeMap.put(c.code, c.nm);
		}
		return codeMap;
	}

}
