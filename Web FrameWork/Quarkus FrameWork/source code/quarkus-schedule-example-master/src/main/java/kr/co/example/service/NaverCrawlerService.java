package kr.co.example.service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.example.component.CrawlerCmd;
import kr.co.example.config.Def;
import kr.co.example.dao.NewsCrawlerDao;
import kr.co.example.utils.ExamUtil;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class NaverCrawlerService {
	
	@Autowired
	CrawlerCmd crawlerCmd;
	
	@Autowired
	NewsCrawlerDao newsCrawlerDao;
	
	public int getNewsTotalPage(String code, String todayNow ) {
		int num_Pages = 1;
		String url;
		Document doc;
		String lastpage_str;
		while(true) {
			url = Def.NAVER_NEWS_BASEURL+code+"&date="+todayNow+"&page="+num_Pages;
			
			doc = crawlerCmd.getWebDocument(url);
			if(doc == null) {
				log.warn("new public cralwing fail. O={}, D={}",code,todayNow);
				return -1;
			}
			
			Elements pageEl = doc.getElementsByClass("nclicks(fls.page)");
			
			if(doc.getElementsByClass("next nclicks(fls.page)").isEmpty()) {
				Element lastpageel = pageEl.last();
				if(lastpageel == null) 
					return num_Pages;
				String rslt = lastpageel.text();
				int tmp = ExamUtil.atoi(rslt);
				if(tmp > 0)
					num_Pages = tmp;
				
				return num_Pages;
			}
			
			lastpage_str = pageEl.get(pageEl.size()-2).text();
			num_Pages = ExamUtil.atoi(lastpage_str) + 1;
		}
	}
}
