package dsynhub.its.bean;

public class ProjectTechnologyBean {

	private int TechnologyId;
	private String projectTechnology;
	public ProjectTechnologyBean() 
	{
		
		this.TechnologyId = 0;
		this.projectTechnology = null;
	}
	public int getTechnologyId() {
		return TechnologyId;
	}
	public void setTechnologyId(int TechnologyId) {
		this.TechnologyId = TechnologyId;
	}
	public String getProjectTechnology() {
		return projectTechnology;
	}
	public void setProjectTechnology(String projectTechnology) {
		this.projectTechnology = projectTechnology;
	}
	
	
	
	
}
