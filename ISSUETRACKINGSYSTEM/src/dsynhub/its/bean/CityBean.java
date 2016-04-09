package dsynhub.its.bean;

public class CityBean {
	
	private int cityId;
	private String cityName;
	private int stateId;
	private String stateName;
	public CityBean()
	{
		
		this.cityId = 0;
		this.cityName = null;
		this.stateId = 0;
		this.stateName=null;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}