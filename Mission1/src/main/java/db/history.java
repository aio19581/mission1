package db;

class history {
	private int historyNo;
	private double LNT;
	private double LAT;
	private String historyDate;
	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public double getLNT() {
		return LNT;
	}
	public void setLNT(double lNT) {
		LNT = lNT;
	}
	public double getLAT() {
		return LAT;
	}
	public void setLAT(double lAT) {
		LAT = lAT;
	}
	public String getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}
}
