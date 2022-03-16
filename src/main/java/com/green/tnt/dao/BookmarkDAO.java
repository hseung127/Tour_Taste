package com.green.tnt.dao;



import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tnt.dto.BookmarkVO;
import com.green.tnt.dto.Member0_tVO;

import utils.Criteria;


@Repository
public class BookmarkDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	// ���������� ������ ��õ ������ ���ã�⿡ �߰�
		public void insertM1tBookmark(BookmarkVO vo) {
		
			mybatis.insert("mappings.bookmark-mapping.insertM1tBookmark", vo);
		}
		
	
	// ���������� ������ ��õ ���� ���ã�⿡ �߰�
	public void insertM1rBookmark(BookmarkVO vo) {
	
		mybatis.insert("mappings.bookmark-mapping.insertM1rBookmark", vo);
	}
	
	
	// ���������� ȸ�� ��õ ���� ���ã�⿡ �߰�
	public void insertM0rBookmark(BookmarkVO vo) {
	
		mybatis.insert("mappings.bookmark-mapping.insertM0rBookmark", vo);
	}
	
	
	// m1tseq�� ���ã�� ����
	public List<BookmarkVO> getCountM1tBookmark(BookmarkVO vo) {	
		return mybatis.selectList("mappings.bookmark-mapping.countM1tBookmark",vo);
	}
	
	// m1rseq�� ���ã�� ����
	public List<BookmarkVO> getCountM1rBookmark(BookmarkVO vo) {	
		return mybatis.selectList("mappings.bookmark-mapping.countM1rBookmark",vo);
	}
		
	// m1trseq�� ���ã�� ����
	public List<BookmarkVO> getCountM0rBookmark(BookmarkVO vo) {	
		return mybatis.selectList("mappings.bookmark-mapping.countM0rBookmark",vo);
	}
	
	
	// id�� M1r���ã�� ����
	public List<BookmarkVO> M1rBookmarkyn(BookmarkVO vo) {	
		//HashMap<String, Object> map = new HashMap<>();
		//map.put("bvo", bvo);
		//System.out.println("dao����"+map);
		//map.put("BookmarkVO", vo);
		//map.put("key", key);
		return mybatis.selectList("mappings.bookmark-mapping.M1rBookmarkyn",vo);
	}
	
	

}
