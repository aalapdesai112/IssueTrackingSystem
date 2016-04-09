package dsynhub.its.bean;
public class IssueResolutionBean {
private int issueResolutionId;
private int issueId;
private String issueName;
private String issueActionType;
private String issueActionDescription;
private int issueResolvedBy;
private int userId;
private String userFirstName;
private String issueResolvedDate;
public IssueResolutionBean() {
	super();
	this.issueResolutionId = 0;
	this.issueId = 0;
	this.issueName = null;
	this.issueActionType = null;
	this.issueActionDescription = null;
	this.issueResolvedBy = 0;
	this.userId = 0;
	this.userFirstName = null;
	this.issueResolvedDate = null;
}
public int getIssueResolutionId() {
	return issueResolutionId;
}
public void setIssueResolutionId(int issueResolutionId) {
	this.issueResolutionId = issueResolutionId;
}
public int getIssueId() {
	return issueId;
}
public void setIssueId(int issueId) {
	this.issueId = issueId;
}
public String getIssueName() {
	return issueName;
}
public void setIssueName(String issueName) {
	this.issueName = issueName;
}
public String getIssueActionType() {
	return issueActionType;
}
public void setIssueActionType(String issueActionType) {
	this.issueActionType = issueActionType;
}
public String getIssueActionDescription() {
	return issueActionDescription;
}
public void setIssueActionDescription(String issueActionDescription) {
	this.issueActionDescription = issueActionDescription;
}
public int getIssueResolvedBy() {
	return issueResolvedBy;
}
public void setIssueResolvedBy(int issueResolvedBy) {
	this.issueResolvedBy = issueResolvedBy;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserFirstName() {
	return userFirstName;
}
public void setUserFirstName(String userFirstName) {
	this.userFirstName = userFirstName;
}
public String getIssueResolvedDate() {
	return issueResolvedDate;
}
public void setIssueResolvedDate(String issueResolvedDate) {
	this.issueResolvedDate = issueResolvedDate;
}
}