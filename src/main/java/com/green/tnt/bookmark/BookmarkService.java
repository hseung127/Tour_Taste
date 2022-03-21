package com.green.tnt.bookmark;

import java.util.List;

import com.green.tnt.dto.BookmarkVO;

public interface BookmarkService  {

	//즐겨찾기 추가
	void insertM1tBookmark(BookmarkVO vo);

	void insertM1rBookmark(BookmarkVO vo);

	void insertM0rBookmark(BookmarkVO vo);
	
	
	// m1tseq별 즐겨찾기 개수
	public List<BookmarkVO> getCountM1tBookmark(BookmarkVO vo);
	// m1rseq별 즐겨찾기 개수
	public List<BookmarkVO> getCountM1rBookmark(BookmarkVO vo);
	// m1trseq별 즐겨찾기 개수
	public List<BookmarkVO> getCountM0rBookmark(BookmarkVO vo);
	
	public int getBM_currval();
	
	//
	public List<BookmarkVO> M1rBookmarkyn(BookmarkVO vo);
	
	public void insertM1tBM(BookmarkVO vo);
	
	public void insertM1rBM(BookmarkVO vo);
	
	public void insertM0tBM(BookmarkVO vo);
	
	public void insertM0rBM(BookmarkVO vo);
	
	public void deleteBM(BookmarkVO vo);
	
}


