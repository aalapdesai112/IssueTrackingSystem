package dsynhub.its.bean;

public class IssueDetailBean {
	private int issueId;
	private String issueName;
	private String issueDescription;
	private int issueTypeId;
	private String issueType;
	private String issueCreationDate;
	private int userId;
	private String userName;
	private int taskId;
	private String taskName;
	private int osId;
	private String os;
	private int issuePriorityId;
	private String issueLevel;
	private int issueStatusId;
	private String issueStatus;
	private String issueStatusDate;
	private String issueSnapShot;

	public IssueDetailBean() {
		super();
		this.issueId = 0;
		this.issueName = null;
		this.issueDescription = null;
		this.issueTypeId = 0;
		this.issueType = null;
		this.issueCreationDate = null;
		this.userId = 0;
		this.userName=null;
		this.taskId = 0;
		this.taskName = null;
		this.osId = 0;
		this.os = null;
		this.issuePriorityId = 0;
		this.issueLevel = null;
		this.issueStatusId = 0;
		this.issueStatus = null;
		this.issueStatusDate = null;
		//this.issueSnapShot = null;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public int getIssueTypeId() {
		return issueTypeId;
	}

	public void setIssueTypeId(int issueTypeId) {
		this.issueTypeId = issueTypeId;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getIssueCreationDate() {
		return issueCreationDate;
	}

	public void setIssueCreationDate(String issueCreationDate) {
		this.issueCreationDate = issueCreationDate;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getOsId() {
		return osId;
	}

	public void setOsId(int osId) {
		this.osId = osId;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public int getIssuePriorityId() {
		return issuePriorityId;
	}

	public void setIssuePriorityId(int issuePriorityId) {
		this.issuePriorityId = issuePriorityId;
	}

	public String getIssueLevel() {
		return issueLevel;
	}

	public void setIssueLevel(String issueLevel) {
		this.issueLevel = issueLevel;
	}

	public int getIssueStatusId() {
		return issueStatusId;
	}

	public void setIssueStatusId(int issueStatusId) {
		this.issueStatusId = issueStatusId;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getIssueStatusDate() {
		return issueStatusDate;
	}

	public void setIssueStatusDate(String issueStatusDate) {
		this.issueStatusDate = issueStatusDate;
	}

	public String getIssueSnapShot() {
		return issueSnapShot;
	}

	public void setIssueSnapShot(String issueSnapShot) {
		this.issueSnapShot = issueSnapShot;
	}
}