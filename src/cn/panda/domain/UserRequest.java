package cn.panda.domain;



public class UserRequest {
	
	private int	currentPage=1;		//当前第几页
	private int itemPerPageNum=5;  	//每页显示多少条
	private int startindex;			//记住用户看的页的数据在数据库中起始地位置
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getItemPerPageNum() {
		return itemPerPageNum;
	}
	public void setItemPerPageNum(int itemPerPageNum) {
		this.itemPerPageNum = itemPerPageNum;
	}
	public int getStartindex() {
		
		this.startindex = (this.currentPage-1)*this.itemPerPageNum;
		
		return startindex;
	}	
	
}
