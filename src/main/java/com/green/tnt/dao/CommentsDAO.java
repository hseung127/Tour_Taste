package com.green.tnt.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.CommentsVO;

import utils.Criteria;

@Repository
public class CommentsDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public CommentsVO getComments(CommentsVO vo) {

		return mybatis.selectOne("mappings.comments-mapping.getComments", vo);
	}

	public int countComments(String content) {

		return mybatis.selectOne("mappings.comments-mapping.countCommentsList", content);
	}

	public List<CommentsVO> listComments(String content) {

		return mybatis.selectList("mappings.comments-mapping.listComments", content);
	}

	public List<CommentsVO> ListWithPaging(Criteria criteria, String content) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("content", content);
		return mybatis.selectList("mappings.comments-mapping.listWithPaging", map);
	}

	public void deleteComments(int com_seq) {
		mybatis.delete("mappings.comments-mapping.deletComments", com_seq);

	}
}
