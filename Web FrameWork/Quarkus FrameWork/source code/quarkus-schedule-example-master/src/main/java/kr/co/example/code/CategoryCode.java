package kr.co.example.code;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum CategoryCode {
	C_100("100", "정치"),  
	C_101("101", "경제"),  
	C_102("102", "사회"),  
	C_103("103", "생활/문화"),  
	C_104("104", "세계"),  
	C_105("105", "IT/과학"),  
	C_001("001", "속보"), 
	;
	
	public String code;
	public String nm;

	/**
	 * return news code map
	 * @return
	 */
	public static HashMap<String, String> getAllCodeStringMap() {
		HashMap<String, String> codeMap = new HashMap<>();
		for (CategoryCode c : values()) {
			codeMap.put(c.code, c.nm);
		}
		return codeMap;
	}

	public static String getName(String code) {
		String rslt = "";
		for (CategoryCode c : values()) {
			if(code.equals(c.code)) rslt = c.nm;
		}
		return rslt;
	}
}
