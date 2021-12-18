package kr.co.example.scheduled;


import static io.quarkus.scheduler.Scheduled.ConcurrentExecution.SKIP;

import java.time.LocalDateTime;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.beans.factory.annotation.Autowired;

import io.quarkus.scheduler.Scheduled;
import kr.co.example.code.NewsPaperCode;
import kr.co.example.dao.NewsCrawlerDao;
import kr.co.example.service.NaverCrawlerService;
import kr.co.example.utils.ExamUtil;
import lombok.extern.log4j.Log4j2;

@ApplicationScoped
@Log4j2
public class Schedules {
	
	@Autowired
	NaverCrawlerService naverCrawlerService;
	
	@Autowired
	NewsCrawlerDao newsCrawlerDao;
	
	@ConfigProperty(name = "news.cron.daterange", defaultValue = "1")
	int DATE_RANGE;
	
	@ConfigProperty(name = "news.cron.datestart", defaultValue = "0")
	int DATE_START;
	
	//중복실행 방지 기능 스케쥴 
	@Scheduled(cron="{news.cron.expr}", concurrentExecution = SKIP)
    void cronJob() {
		log.info("1. news crawler start!! SDT=-{} EDT=-{}", DATE_START, DATE_RANGE);
		Map<String,String> codeMap = NewsPaperCode.getAllCodeStringMap();
		
		String ymd = ExamUtil.getYmd(0);
		for(int i = DATE_START ; i < DATE_RANGE + DATE_START; i++) {
			ymd = ExamUtil.getYmd(0 - i);
			
			//쓰레드화 시킬까???
			for(String code : codeMap.keySet()) {
				//2. get page
				int pagenum = naverCrawlerService.getNewsTotalPage(code,ymd);
				log.info("2. news get totalpage O={}, ON={}, D={}, C={}", code, codeMap.get(code), ymd, pagenum);
				if(pagenum < 0) return;
			}
			
		}
		log.info("news crawler end!!");
    }
}
