package com.green.tnt.comments;

import java.util.List;

import com.green.tnt.dto.CommentsVO;

import utils.Criteria;

public interface CommentsService {
	
	CommentsVO getComments(CommentsVO vo);

	public int countComments(String content);

	public List<CommentsVO> listComments(String content);

	public List<CommentsVO> ListWithPaging(Criteria criteria, String content);

	public void deleteComments(int com_seq);
}
