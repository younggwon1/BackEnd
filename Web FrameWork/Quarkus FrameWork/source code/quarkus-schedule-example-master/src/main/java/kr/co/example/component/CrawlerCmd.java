package kr.co.example.component;

import java.net.URI;
import java.net.URLDecoder;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import io.vertx.core.http.HttpHeaders;

@Component
public class CrawlerCmd {
	
	public Document getWebDocument(String url) {
		Document doc;
		Connection conn = Jsoup.connect(url);
		conn.header(HttpHeaders.USER_AGENT.toString(), "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299");
		try {
			doc = conn.get();
		} catch (Exception e) {
			return null;
		}
		
		return doc;
				
	}
	
	public Document getWebDocument(String url, String charset) {
		Document doc;
		
		Connection conn = Jsoup.connect(url);
		conn.header(HttpHeaders.USER_AGENT.toString(), "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299");
		try {
			URI u = new URI(url);
			doc = conn.url(new URI(u.getScheme(), u.getUserInfo(), u.getHost(), u.getPort(), URLDecoder.decode(u.getPath(), charset), u.getQuery(), u.getFragment()).toURL()).get();
		} catch (Exception e) {
			return null;
		}
		
		return doc;
				
	}
	
}
