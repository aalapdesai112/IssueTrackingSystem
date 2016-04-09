package dsynhub.its.bean;
public class FeedbackBean {
private int feedbackId;
private String feedbackName;
private String feedbackDescription;
private String feedbackDate;

public FeedbackBean() {
	this.feedbackId = 0;
	this.feedbackName = null;
	this.feedbackDescription = null;
	this.feedbackDate = null;
}
public int getFeedbackId() {
	return feedbackId;
}
public void setFeedbackId(int feedbackId) {
	this.feedbackId = feedbackId;
}
public String getFeedbackName() {
	return feedbackName;
}
public void setFeedbackName(String feedbackName) {
	this.feedbackName = feedbackName;
}
public String getFeedbackDescription() {
	return feedbackDescription;
}
public void setFeedbackDescription(String feedbackDescription) {
	this.feedbackDescription = feedbackDescription;
}
public String getFeedbackDate() {
	return feedbackDate;
}
public void setFeedbackDate(String feedbackDate) {
	this.feedbackDate = feedbackDate;
}
}