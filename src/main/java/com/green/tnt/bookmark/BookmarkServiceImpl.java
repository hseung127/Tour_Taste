package com.green.tnt.bookmark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tnt.dto.BookmarkVO;
import com.green.tnt.dao.BookmarkDAO;
import com.green.tnt.bookmark.BookmarkService;


@Service("BookmarkService")
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	private BookmarkDAO bDao;
	
	@Override
	public void insertM1tBookmark(BookmarkVO vo) {
		bDao.insertM1tBookmark(vo);
	}

	@Override
	public void insertM1rBookmark(BookmarkVO vo) {
		bDao.insertM1rBookmark(vo);
	}

	@Override
	public void insertM0rBookmark(BookmarkVO vo) {
		bDao.insertM0rBookmark(vo);  
	}

	@Override
	public List<BookmarkVO> getCountM1tBookmark(BookmarkVO vo) {
		
		return bDao.getCountM1tBookmark(vo);
	}

	@Override
	public List<BookmarkVO> getCountM1rBookmark(BookmarkVO vo) {
		
		return bDao.getCountM1rBookmark(vo);
	}

	@Override
	public List<BookmarkVO> getCountM0rBookmark(BookmarkVO vo) {
		
		return bDao.getCountM0rBookmark(vo);
	}
	@Override
	public int getBM_currval() {
		return bDao.getBM_currval();
	}

	@Override
	public List<BookmarkVO> M1rBookmarkyn(BookmarkVO vo) {
		return bDao.M1rBookmarkyn(vo);
	}

	@Override
	public void insertM1tBM(BookmarkVO vo) {
		
		bDao.insertM1tBM(vo);
	}

	@Override
	public void insertM1rBM(BookmarkVO vo) {

		bDao.insertM1rBM(vo);
	}

	@Override
	public void insertM0tBM(BookmarkVO vo) {
		
		bDao.insertM0tBM(vo);
	}

	@Override
	public void insertM0rBM(BookmarkVO vo) {
		
		bDao.insertM0rBM(vo);
	}

	@Override
	public void deleteBM(BookmarkVO vo) {
		
		bDao.deleteBM(vo);
	}


}
