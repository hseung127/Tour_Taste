package com.green.tnt.seasonboard;

import java.util.List;

import com.green.tnt.dto.SeasonboardVO;

import utils.Criteria;

public interface SeasonboardService {
	
	SeasonboardVO getSeasonboard(SeasonboardVO vo);

	public int countSeasonboard(String subject);

	public List<SeasonboardVO> listSeasonboard(String subject);

	public List<SeasonboardVO> ListWithPaging(Criteria criteria, String subject);

	public void insertSeasonboard(SeasonboardVO vo);

	public void updateSeasonboard(SeasonboardVO vo);
	
	public void deleteSeasonboard(int sseq);
}
