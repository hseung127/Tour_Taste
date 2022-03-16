package com.green.tnt.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookmarkVO {
	private int bseq;
	private String id;
	private int m0tseq;
	private int m0rseq;
	private int m1tseq;
	private int m1rseq;

	private int m1tCount;
	private int m1rCount;
	private int m0rCount;
	
	private int m1tBookmarkyn;
	private int m1rBookmarkyn;
	private int m0rBookmarkyn;
}
