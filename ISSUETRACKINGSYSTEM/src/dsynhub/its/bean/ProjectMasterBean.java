package dsynhub.its.bean;

public class ProjectMasterBean {

	
	private int projectId;
	private String projectName;
	private String projectdescription;
	private String proj_estimated_start_date;
	private String proj_actual_start_date;
	private String proj_estimated_end_date;
	private String proj_actual_end_date;
	private int priorityId;
	private int statusId;
	private int categaryId;
	private String pmtStatus;
	private String pmtPriority;
	private String projCategary;
	
	public ProjectMasterBean()
	{
		
		this.projectId = 0;
		this.projectName = null;
		this.projectdescription = null;
		this.proj_estimated_start_date = null;
		this.proj_actual_start_date = null;
		this.proj_estimated_end_date = null;
		this.proj_actual_end_date = null;
		this.priorityId = 0;
		this.statusId = 0;
		this.categaryId = 0;
		this.pmtPriority=null;
		this.pmtStatus=null;
		this.projCategary=null;
	}

	public String getPmtStatus() {
		return pmtStatus;
	}

	public void setPmtStatus(String pmtStatus) {
		this.pmtStatus = pmtStatus;
	}

	public String getPmtPriority() {
		return pmtPriority;
	}

	public void setPmtPriority(String pmtPriority) {
		this.pmtPriority = pmtPriority;
	}

	public String getProjCategary() {
		return projCategary;
	}

	public void setProjCategary(String projCategary) {
		this.projCategary = projCategary;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectdescription() {
		return projectdescription;
	}

	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}

	public String getProj_estimated_start_date() {
		return proj_estimated_start_date;
	}

	public void setProj_estimated_start_date(String proj_estimated_start_date) {
		this.proj_estimated_start_date = proj_estimated_start_date;
	}

	public String getProj_actual_start_date() {
		return proj_actual_start_date;
	}

	public void setProj_actual_start_date(String proj_actual_start_date) {
		this.proj_actual_start_date = proj_actual_start_date;
	}

	public String getProj_estimated_end_date() {
		return proj_estimated_end_date;
	}

	public void setProj_estimated_end_date(String proj_estimated_end_date) {
		this.proj_estimated_end_date = proj_estimated_end_date;
	}

	public String getProj_actual_end_date() {
		return proj_actual_end_date;
	}

	public void setProj_actual_end_date(String proj_actual_end_date) {
		this.proj_actual_end_date = proj_actual_end_date;
	}

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getCategaryId() {
		return categaryId;
	}

	public void setCategaryId(int categaryId) {
		this.categaryId = categaryId;
	}
	
	
}
