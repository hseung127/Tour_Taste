package com.green.tnt.bookmark;

import java.util.List;

import com.green.tnt.dto.BookmarkVO;

public interface BookmarkService  {

	//���ã�� �߰�
	void insertM1tBookmark(BookmarkVO vo);

	void insertM1rBookmark(BookmarkVO vo);

	void insertM0rBookmark(BookmarkVO vo);
	
	
	// m1tseq�� ���ã�� ����
	public List<BookmarkVO> getCountM1tBookmark(BookmarkVO vo);
	// m1rseq�� ���ã�� ����
	public List<BookmarkVO> getCountM1rBookmark(BookmarkVO vo);
	// m1trseq�� ���ã�� ����
	public List<BookmarkVO> getCountM0rBookmark(BookmarkVO vo);
	
	
	//
	public List<BookmarkVO> M1rBookmarkyn(BookmarkVO vo);
	
}


