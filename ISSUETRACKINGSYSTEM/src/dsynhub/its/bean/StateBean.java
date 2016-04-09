package dsynhub.its.bean;

public class StateBean {
private int stateId;
private String stateName;
private int countryId;
private String countryName;

public StateBean() {	
	this.stateId = 0;
	this.stateName = null;
	this.countryId = 0;
	this.countryName=null;
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

public int getCountryId() {
	return countryId;
}

public void setCountryId(int countryId) {
	this.countryId = countryId;
}

public String getCountryName() {
	return countryName;
}

public void setCountryName(String countryName) {
	this.countryName = countryName;
}



}
