package calculator.domain;

/**
 * Represents a ticket
 * @hibernate.class table="rpn_calculator"
 */
public class Result {
	
	Long id;
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
	
}
