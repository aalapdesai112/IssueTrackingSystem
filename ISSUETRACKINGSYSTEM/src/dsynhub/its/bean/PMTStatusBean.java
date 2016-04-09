package dsynhub.its.bean;

public class PMTStatusBean {
private int pmtstatusid;
private String pmtstatus;
public PMTStatusBean() 
{
	this.pmtstatusid = 0;
	this.pmtstatus = null;
}
public int getPmtstatusid() {
	return pmtstatusid;
}
public void setPmtstatusid(int pmtstatusid) {
	this.pmtstatusid = pmtstatusid;
}
public String getPmtstatus() {
	return pmtstatus;
}
public void setPmtstatus(String pmtstatus) {
	this.pmtstatus = pmtstatus;
}

}
