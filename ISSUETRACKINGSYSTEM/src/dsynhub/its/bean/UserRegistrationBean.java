package dsynhub.its.bean;

public class UserRegistrationBean {

	private int userId;
	private String userFirstName;
	private String userMiddleName;
	private String userLastName;
	private String user_Res_Address;
	private String user_Per_Address;
	private int cityId;
	private String cityName;
	private String userGender;
	private String birthDate;
	private String user_Mobile_No;
	private String user_Phone_No;
	private String emailId;
	private String passWord;
	private int typeId;
	private String userType;
	private int sequrityQuestionId;
	private String Security_Question;
	private String sequrityQuestionAns;
	private String loginDate;
	private String userStatus;
	private int stateId;
	private int countryId;
	private String stateName;
	private String countryName;

	public UserRegistrationBean() {

		this.userId = 0;
		this.userFirstName = null;
		this.userMiddleName = null;
		this.userLastName = null;
		this.user_Res_Address = null;
		this.user_Per_Address = null;
		this.cityId = 0;
		this.cityName = null;
		this.userGender = null;
		this.birthDate = null;
		this.user_Mobile_No = null;
		this.user_Phone_No = null;
		this.emailId = null;
		this.passWord = null;
		this.typeId = 0;
		this.userType = null;
		this.sequrityQuestionId = 0;
		this.Security_Question = null;
		this.sequrityQuestionAns = null;
		this.loginDate = null;
		this.userStatus = null;
		this.stateId=0;
		this.countryId=0;
		this.stateName=null;
		this.countryName=null;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public String getUserMiddleName() {
		return userMiddleName;
	}

	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUser_Res_Address() {
		return user_Res_Address;
	}

	public void setUser_Res_Address(String user_Res_Address) {
		this.user_Res_Address = user_Res_Address;
	}

	public String getUser_Per_Address() {
		return user_Per_Address;
	}

	public void setUser_Per_Address(String user_Per_Address) {
		this.user_Per_Address = user_Per_Address;
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

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getUser_Mobile_No() {
		return user_Mobile_No;
	}

	public void setUser_Mobile_No(String user_Mobile_No) {
		this.user_Mobile_No = user_Mobile_No;
	}

	public String getUser_Phone_No() {
		return user_Phone_No;
	}

	public void setUser_Phone_No(String user_Phone_No) {
		this.user_Phone_No = user_Phone_No;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getSequrityQuestionId() {
		return sequrityQuestionId;
	}

	public void setSequrityQuestionId(int sequrityQuestionId) {
		this.sequrityQuestionId = sequrityQuestionId;
	}

	public String getSecurity_Question() {
		return Security_Question;
	}

	public void setSecurity_Question(String security_Question) {
		Security_Question = security_Question;
	}

	public String getSequrityQuestionAns() {
		return sequrityQuestionAns;
	}

	public void setSequrityQuestionAns(String sequrityQuestionAns) {
		this.sequrityQuestionAns = sequrityQuestionAns;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
}