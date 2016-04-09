package dsynhub.its.bean;

public class CountryBean {
private int countryId;
private String countryName;
public CountryBean() {
	
	this.countryId = 0;
	this.countryName = null;
	
}
public int getCountryID() {
	return countryId;
}
public void setCountryID(int countryID) {
	this.countryId = countryID;
}
public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}

}
