package com.green.tnt.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.SeasonVO;

@Repository
public class SeasonDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public List<SeasonVO> getHomeSeasonList(){
		return mybatis.selectList("mappings.season-mapping.getHomeSeasonList");
	}
}
