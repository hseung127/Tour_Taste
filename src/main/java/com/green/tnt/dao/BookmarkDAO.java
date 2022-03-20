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
	// 메인페이지 관리자 추천 관광지 즐겨찾기에 추가
		public void insertM1tBookmark(BookmarkVO vo) {
		
			mybatis.insert("mappings.bookmark-mapping.insertM1tBookmark", vo);
		}
		
	
	// 메인페이지 관리자 추천 맛집 즐겨찾기에 추가
	public void insertM1rBookmark(BookmarkVO vo) {
	
		mybatis.insert("mappings.bookmark-mapping.insertM1rBookmark", vo);
	}
	
	
	// 메인페이지 회원 추천 맛집 즐겨찾기에 추가
	public void insertM0rBookmark(BookmarkVO vo) {
	
		mybatis.insert("mappings.bookmark-mapping.insertM0rBookmark", vo);
	}
	
	
	// m1tseq별 즐겨찾기 개수
	public List<BookmarkVO> getCountM1tBookmark(BookmarkVO vo) {	
		return mybatis.selectList("mappings.bookmark-mapping.countM1tBookmark",vo);
	}
	
	// m1rseq별 즐겨찾기 개수
	public List<BookmarkVO> getCountM1rBookmark(BookmarkVO vo) {	
		return mybatis.selectList("mappings.bookmark-mapping.countM1rBookmark",vo);
	}
		
	// m1trseq별 즐겨찾기 개수
	public List<BookmarkVO> getCountM0rBookmark(BookmarkVO vo) {	
		return mybatis.selectList("mappings.bookmark-mapping.countM0rBookmark",vo);
	}
	
	// bseq 가져오기
	public int getBM_currval() {
		return mybatis.selectOne("mappings.bookmark-mapping.getBM_currval");
	}

	
	
	// id별 M1r즐겨찾기 여부
	public List<BookmarkVO> M1rBookmarkyn(BookmarkVO vo) {	
		//HashMap<String, Object> map = new HashMap<>();
		//map.put("bvo", bvo);
		//System.out.println("dao에서"+map);
		//map.put("BookmarkVO", vo);
		//map.put("key", key);
		return mybatis.selectList("mappings.bookmark-mapping.M1rBookmarkyn",vo);
	}
	
	public void insertM1tBM(BookmarkVO vo) {
		
		mybatis.insert("mappings.bookmark-mapping.insertM1tBM", vo);
	}

	public void insertM1rBM(BookmarkVO vo) {
		
		mybatis.insert("mappings.bookmark-mapping.insertM1rBM", vo);
	}
	
	public void insertM0tBM(BookmarkVO vo) {
		
		mybatis.insert("mappings.bookmark-mapping.insertM0tBM", vo);
	}
	
	public void insertM0rBM(BookmarkVO vo) {
		
		mybatis.insert("mappings.bookmark-mapping.insertM0rBM", vo);
	}
	
	public void deleteBM(BookmarkVO vo) {
		
		mybatis.delete("mappings.bookmark-mapping.deleteBM", vo);
	}
	
	
	

}
