package calculator.domain;

/**
 * Represents a ticket
 * @hibernate.class table="rpn_calculator"
 */
public class Result {
	
	Long id;
	String resultCode;
	String resultMsg;
	String request;	
	String answer;
	
	/**
	  * @return a Long representing the database id.
	  * @hibernate.id unsaved-value="null"
	  * generator-class="native" column="id"
	  */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
     * @return the RPN answer
     * @hibernate.property column="response"
     */
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
     * @return the RPN Request
     * @hibernate.property column="request"
     */
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	
	/**
     * @return the result code indication success/failure
     * @hibernate.property column="result_code"
     */
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
     * @return the result msg indicating success/failure message
     * @hibernate.property column="result_msg"
     */
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}
