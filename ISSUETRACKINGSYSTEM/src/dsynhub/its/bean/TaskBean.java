package dsynhub.its.bean;

public class TaskBean {
private int taskId;
private String taskName;
private String taskDescription;
private String taskEstimateStartDate;
private String taskActualStartDate;
private String taskEstimateEndDate;
private String taskActualEndDate;
private int pmtPriorityId;
private int pmtStatusId;
private int moduleId;
private String pmtPriority;
private String pmtStatus;
private String moduleName;
public TaskBean() {
	super();
	this.taskId = 0;
	this.taskName = null;
	this.taskDescription = null;
	this.taskEstimateStartDate = null;
	this.taskActualStartDate = null;
	this.taskEstimateEndDate = null;
	this.taskActualEndDate = null;
	this.pmtPriorityId = 0;
	this.pmtStatusId = 0;
	this.moduleId = 0;
	this.pmtPriority = null;
	this.pmtStatus = null;
	this.moduleName = null;
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
public String getTaskDescription() {
	return taskDescription;
}
public void setTaskDescription(String taskDescription) {
	this.taskDescription = taskDescription;
}
public String getTaskEstimateStartDate() {
	return taskEstimateStartDate;
}
public void setTaskEstimateStartDate(String taskEstimateStartDate) {
	this.taskEstimateStartDate = taskEstimateStartDate;
}
public String getTaskActualStartDate() {
	return taskActualStartDate;
}
public void setTaskActualStartDate(String taskActualStartDate) {
	this.taskActualStartDate = taskActualStartDate;
}
public String getTaskEstimateEndDate() {
	return taskEstimateEndDate;
}
public void setTaskEstimateEndDate(String taskEstimateEndDate) {
	this.taskEstimateEndDate = taskEstimateEndDate;
}
public String getTaskActualEndDate() {
	return taskActualEndDate;
}
public void setTaskActualEndDate(String taskActualEndDate) {
	this.taskActualEndDate = taskActualEndDate;
}
public int getPmtPriorityId() {
	return pmtPriorityId;
}
public void setPmtPriorityId(int pmtPriorityId) {
	this.pmtPriorityId = pmtPriorityId;
}
public int getPmtStatusId() {
	return pmtStatusId;
}
public void setPmtStatusId(int pmtStatusId) {
	this.pmtStatusId = pmtStatusId;
}
public int getModuleId() {
	return moduleId;
}
public void setModuleId(int moduleId) {
	this.moduleId = moduleId;
}
public String getPmtPriority() {
	return pmtPriority;
}
public void setPmtPriority(String pmtPriority) {
	this.pmtPriority = pmtPriority;
}
public String getPmtStatus() {
	return pmtStatus;
}
public void setPmtStatus(String pmtStatus) {
	this.pmtStatus = pmtStatus;
}
public String getModuleName() {
	return moduleName;
}
public void setModuleName(String moduleName) {
	this.moduleName = moduleName;
}

}
