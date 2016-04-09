package dsynhub.its.bean;

public class IssuePriorityBean {

	private int issuePriorityId;
	private String issuePriorityLevel;
	public IssuePriorityBean() {
	
		this.issuePriorityId = 0;
		this.issuePriorityLevel = null;
	}
	public int getIssuePriorityId() {
		return issuePriorityId;
	}
	public void setIssuePriorityId(int issuePriorityId) {
		this.issuePriorityId = issuePriorityId;
	}
	public String getIssuePrioritylevel() {
		return issuePriorityLevel;
	}
	public void setIssuePrioritylevel(String issuePrioritylevel) {
		this.issuePriorityLevel = issuePrioritylevel;
	}
	
	
}
