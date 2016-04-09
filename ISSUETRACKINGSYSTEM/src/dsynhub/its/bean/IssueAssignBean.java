package dsynhub.its.bean;

public class IssueAssignBean {
private int issueId;
private String issueName;
private int issueAssignTo;
private String userName;
private String issueReportedBy;
private String userName1;
private String assignDate;
private int issueAssignId;
private int userId;
private String userFirstName;
public IssueAssignBean()
{
	this.issueId = 0;
	this.issueName = null;
	this.issueAssignTo = 0;
	this.userName = null;
	this.issueReportedBy = null;
	this.userName1 = null;
	this.assignDate = null;
	this.issueAssignId=0;
	this.userId=0;
	this.userFirstName=null;
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

public int getIssueAssignId() {
	return issueAssignId;
}

public void setIssueAssignId(int issueAssignId) {
	this.issueAssignId = issueAssignId;
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
public int getIssueAssignTo() {
	return issueAssignTo;
}
public void setIssueAssignTo(int issueAssignTo) {
	this.issueAssignTo = issueAssignTo;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public String getIssueReportedBy() {
	return issueReportedBy;
}

public void setIssueReportedBy(String issueReportedBy) {
	this.issueReportedBy = issueReportedBy;
}

public String getUserName1() {
	return userName1;
}
public void setUserName1(String userName1) {
	this.userName1 = userName1;
}
public String getAssignDate() {
	return assignDate;
}
public void setAssignDate(String assignDate) {
	this.assignDate = assignDate;
}
}