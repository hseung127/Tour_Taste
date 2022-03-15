package utils;

/*
 * ���� �������� ������ ������ �����ϴ� Ŭ����
 * - ���� ������ ��ȣ
 * - ������ �� ��� �׸� ��
 * - �� �������� ���� �Խñ� ��ȣ
 */
public class Criteria {
	private int pageNum;		// ���� ������ ��ȣ
	private int rowsPerPage;	// �������� ������� ����
	private String keyword;
	// ������
	public Criteria() {
		// �⺻��: ��������ȣ: 1, ������ �� �׸��: 10 
		this(1, 10);
	}
	
	public Criteria(int pageNum, int rowsPerPage) {
		this.pageNum = pageNum;
		this.rowsPerPage = rowsPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if (pageNum <= 0) {
			this.pageNum = 1;
		} else {
			this.pageNum = pageNum;
		}
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	// �������� �׸��� ���� 20���� ����
	public void setRowsPerPage(int rowsPerPage) {
		if (rowsPerPage <= 0 || rowsPerPage > 20)
			this.rowsPerPage = 20;
		else
			this.rowsPerPage = rowsPerPage;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/*
	 * �� ���������� �����ϴ� �׸��ȣ�� ��ȯ
	 * ��: 1������ - 1
	 *     2������ - 11, . . .
	 */
	public int getPageStart() {
		return (pageNum - 1) * rowsPerPage + 1;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", rowsPerPage=" + rowsPerPage + ", keyword=" + keyword + "]";
	}


}







