package dsynhub.its.bean;

public class UserTypeBean {
	private int userTypeId;
	private String userType;
	public UserTypeBean() {
		
		this.userTypeId = 0;
		this.userType = null;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}