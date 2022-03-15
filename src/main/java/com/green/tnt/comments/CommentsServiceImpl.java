package com.green.tnt.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dao.CommentsDAO;
import com.green.tnt.dto.CommentsVO;

import utils.Criteria;

@Service("comments")
public class CommentsServiceImpl implements CommentsService {
	@Autowired
	private CommentsDAO comDao; 
	@Override
	public CommentsVO getComments(CommentsVO vo) {
		
		return comDao.getComments(vo);
	}

	@Override
	public int countComments(String content) {
		
		return comDao.countComments(content);
	}

	@Override
	public List<CommentsVO> listComments(String content) {
		
		return comDao.listComments(content);
	}

	@Override
	public List<CommentsVO> ListWithPaging(Criteria criteria, String content) {
		
		return comDao.ListWithPaging(criteria, content);
	}


	@Override
	public void deleteComments(int com_seq) {
		
		 comDao.deleteComments(com_seq);
	}

}
