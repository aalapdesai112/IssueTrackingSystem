package dsynhub.its.bean;
public class ProjectUserBean {
			private int projUserId;
			private int projId;
			private int userId;
			private int roleId;
			private String projName;
			private String userName;
			private String roleName;
			public ProjectUserBean()
			{
				this.projUserId = 0;
				this.projId = 0;
				this.userId = 0;
				this.roleId = 0;
				this.projName = null;
				this.userName = null;
				this.roleName = null;
			}
			public int getProjUserId() {
				return projUserId;
			}
			public void setProjUserId(int projUserId) {
				this.projUserId = projUserId;
			}
			public int getProjId() {
				return projId;
			}
			public void setProjId(int projId) {
				this.projId = projId;
			}
			public int getUserId() {
				return userId;
			}
			public void setUserId(int userId) {
				this.userId = userId;
			}
			public int getRoleId() {
				return roleId;
			}
			public void setRoleId(int roleId) {
				this.roleId = roleId;
			}
			public String getProjName() {
				return projName;
			}
			public void setProjName(String projName) {
				this.projName = projName;
			}
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public String getRoleName() {
				return roleName;
			}
			public void setRoleName(String roleName) {
				this.roleName = roleName;
			}
	}