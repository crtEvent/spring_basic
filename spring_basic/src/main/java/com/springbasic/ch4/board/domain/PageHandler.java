package com.springbasic.ch4.board.domain;

public class PageHandler {
	private int totalCnt;  // �� �Խù� ����
	private int pageSize;  // �� �������� �Խù� ��
	private int naviSize = 10;  // ������ ������̼��� ũ��
	private int totalPage; // ��ü ������ ����
	private int page;      // ���� ������
	private int beginPage; // ������̼��� ù��° ������
	private int endPage;   // ������̼��� ������ ������
	private boolean showPrev; // ���� �������� �̵��ϴ� ��ũ ǥ�� ����
	private boolean showNext; // ���� �������� �̵��ϴ� ��ũ ǥ�� ����
	
	public PageHandler(int totalCnt, int page) {
		this(totalCnt, page, 10);
	}
	
	public PageHandler(int totalCnt, int page, int pageSize) {
		this.totalCnt = totalCnt;
		this.pageSize = pageSize;
		this.page = page;
		
		totalPage = (int) Math.ceil(totalCnt / (double)pageSize);
		beginPage = ((page / naviSize) * naviSize) +1;
		endPage = Math.min(beginPage + naviSize - 1, totalPage);
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}
	
	public void print() {
		System.out.println("page = "+page);
		System.out.print(showPrev ? "[PREV] " : "");
		for(int i = beginPage; i <= endPage; i++) {
			System.out.print(i+" ");
		}
		System.out.print(showNext ? "[NEXT]\n" : "\n");
	}

	@Override
	public String toString() {
		return "PageHandler [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", naviSize=" + naviSize
				+ ", totalPage=" + totalPage + ", page=" + page + ", beginPage=" + beginPage + ", endPage=" + endPage
				+ ", showPrev=" + showPrev + ", showNext=" + showNext + "]";
	}
	
}
