package dsynhub.its.bean;

public class IssueTypeBean
{
private int issuetypeid;
private String issuetype;
public IssueTypeBean() 
{
	this.issuetypeid = 0;
	this.issuetype = null;
}
public int getIssuetypeid()
{
	return issuetypeid;
}
public void setIssuetypeid(int issuetypeid)
{
	this.issuetypeid = issuetypeid;
}
public String getIssuetype()
{
	return issuetype;
}
public void setIssuetype(String issuetype) 
{
	this.issuetype = issuetype;
}
}
