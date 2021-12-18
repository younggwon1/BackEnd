package kr.co.example.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kr.co.example.model.vo.NewsCat;


@Repository
public interface NewsCatRepository extends CrudRepository<NewsCat, String> {
	
	
}
