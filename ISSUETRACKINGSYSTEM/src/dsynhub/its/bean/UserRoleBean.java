package dsynhub.its.bean;

public class UserRoleBean {
	private int roleId;
	private String roleName;
	
	
	public UserRoleBean() {
		super();
		this.roleId = 0;
		this.roleName = null;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
