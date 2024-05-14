package db;

public class wifi {
	private String MGR_NO;
    private String WRDOFC;
    private String MAIN_NM;
    private String ADRES1;
    private String ADRES2;
    private String FLOOR;
    private String TY;
    private String MBY;
    private String SE;
    private String CMCWR;
    private int CNSTC_YEAR;
    private String INOUT_DOOR;
    private String REMARS3;
    private double LNT;
    private double LAT;
    public int getCNSTC_YEAR() {
		return CNSTC_YEAR;
	}

	public void setCNSTC_YEAR(int cNSTC_YEAR) {
		CNSTC_YEAR = cNSTC_YEAR;
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

	private String WORK_DTTM;
//    
//    public wifi(String MGR_NO, String WRDOFC, String MAIN_NM, String ADRES1, String ADRES2, String FLOOR, String TY, String MBY, String SE, String CMCWR, int CNSTC_YEAR, String INOUT_DOOR, String REMARS3, double LNT, double LAT, String WORK_DTTM) {
//    	this.MGR_NO = MGR_NO;
//    	this.WRDOFC = WRDOFC;
//    	this.MAIN_NM = MAIN_NM;
//    	this.ADRES1 = ADRES1;
//    	this.ADRES2 = ADRES2;
//    	this.FLOOR = FLOOR;
//    	this.TY = TY;
//    	this.MBY = MBY;
//    	this.SE = SE;
//    	this.CMCWR = CMCWR;
//    	this.CNSTC_YEAR = CNSTC_YEAR;
//    	this.INOUT_DOOR = INOUT_DOOR;
//    	this.REMARS3 = REMARS3;
//    	this.LAT = LAT;
//    	this.LNT = LNT;
//    	this.WORK_DTTM = WORK_DTTM;	
//    }
    
    public String getMGR_NO() {
        return MGR_NO;
    }

    public void setMGR_NO(String MGR_NO) {
        this.MGR_NO = MGR_NO;
    }

    public String getWRDOFC() {
        return WRDOFC;
    }

    public void setWRDOFC(String WRDOFC) {
        this.WRDOFC = WRDOFC;
    }

    public String getMAIN_NM() {
        return MAIN_NM;
    }

    public void setMAIN_NM(String MAIN_NM) {
        this.MAIN_NM = MAIN_NM;
    }

    public String getADRES1() {
        return ADRES1;
    }

    public void setADRES1(String ADRES1) {
        this.ADRES1 = ADRES1;
    }

    public String getADRES2() {
        return ADRES2;
    }

    public void setADRES2(String ADRES2) {
        this.ADRES2 = ADRES2;
    }

    public String getFLOOR() {
        return FLOOR;
    }

    public void setFLOOR(String FLOOR) {
        this.FLOOR = FLOOR;
    }

    public String getTY() {
        return TY;
    }

    public void setTY(String TY) {
        this.TY = TY;
    }

    public String getMBY() {
        return MBY;
    }

    public void setMBY(String MBY) {
        this.MBY = MBY;
    }

    public String getSE() {
        return SE;
    }

    public void setSE(String SE) {
        this.SE = SE;
    }

    public String getCMCWR() {
        return CMCWR;
    }

    public void setCMCWR(String CMCWR) {
        this.CMCWR = CMCWR;
    }

    public String getINOUT_DOOR() {
        return INOUT_DOOR;
    }

    public void setINOUT_DOOR(String INOUT_DOOR) {
        this.INOUT_DOOR = INOUT_DOOR;
    }

    public String getREMARS3() {
        return REMARS3;
    }

    public void setREMARS3(String REMARS3) {
        this.REMARS3 = REMARS3;
    }

    public String getWORK_DTTM() {
        return WORK_DTTM;
    }

    public void setWORK_DTTM(String WORK_DTTM) {
        this.WORK_DTTM = WORK_DTTM;
    }
    
    
}
