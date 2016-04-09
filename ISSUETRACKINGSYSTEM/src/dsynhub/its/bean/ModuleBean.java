package dsynhub.its.bean;

public class ModuleBean {
private int moduleId;
private String moduleName;
private String moduleDescription;
private String moduleEstimateStartDate;
private String moduleActualStartDate;
private String moduleEstimateEndDate;
private String moduleActualEndDate;
private int pmtPriorityId;
private int pmtStatusId;
private int projectId;
private String pmtPriority;
private String pmtStatus;
private String projectName;
public ModuleBean()
{
	this.moduleId = 0;
	this.moduleName = null;
	this.moduleDescription = null;
	this.moduleEstimateStartDate = null;
	this.moduleActualStartDate = null;
	this.moduleEstimateEndDate = null;
	this.moduleActualEndDate = null;
	this.pmtPriorityId = 0;
	this.pmtStatusId = 0;
	this.projectId = 0;
	this.pmtPriority=null;
	this.pmtStatus=null;
	this.projectName=null;
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

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public int getModuleId() {
	return moduleId;
}
public void setModuleId(int moduleId) {
	this.moduleId = moduleId;
}
public String getModuleName() {
	return moduleName;
}
public void setModuleName(String moduleName) {
	this.moduleName = moduleName;
}
public String getModuleDescription() {
	return moduleDescription;
}
public void setModuleDescription(String moduleDescription) {
	this.moduleDescription = moduleDescription;
}
public String getModuleEstimateStartDate() {
	return moduleEstimateStartDate;
}
public void setModuleEstimateStartDate(String moduleEstimateStartDate) {
	this.moduleEstimateStartDate = moduleEstimateStartDate;
}
public String getModuleActualStartDate() {
	return moduleActualStartDate;
}
public void setModuleActualStartDate(String moduleActualStartDate) {
	this.moduleActualStartDate = moduleActualStartDate;
}
public String getModuleEstimateEndDate() {
	return moduleEstimateEndDate;
}
public void setModuleEstimateEndDate(String moduleEstimateEndDate) {
	this.moduleEstimateEndDate = moduleEstimateEndDate;
}
public String getModuleActualEndDate() {
	return moduleActualEndDate;
}
public void setModuleActualEndDate(String moduleActualEndDate) {
	this.moduleActualEndDate = moduleActualEndDate;
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
public int getProjectId() {
	return projectId;
}
public void setProjectId(int projectId) {
	this.projectId = projectId;
}
}