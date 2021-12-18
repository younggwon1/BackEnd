package kr.co.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.example.dao.repository.NewsCatRepository;
import kr.co.example.model.dto.NewsCrawlerDto;
import kr.co.example.model.vo.NewsCat;

@Service
public class NewsCrawlerDao {

	@Autowired
	NewsCatRepository newsCatRepository;
	
	
	public void saveAll(NewsCrawlerDto dto){
		NewsCat newsCat = new NewsCat();
		newsCat.setIdsk(dto.getNews_id());
		newsCat.setCategory(dto.getCategory());
		newsCat.setCategory_incident(dto.getCategory_incident());
		newsCatRepository.save(newsCat);
	}
	
}
