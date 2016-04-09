package dsynhub.its.bean;

public class SequrityQuestionBean {

	

	private int QuestionId;
	private String QuestionName;
	
	public SequrityQuestionBean()
	{
		
		QuestionId = 0;
		QuestionName = null;
	}

	public int getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}

	public String getQuestionName() {
		return QuestionName;
	}

	public void setQuestionName(String questionName) {
		QuestionName = questionName;
	}
}
