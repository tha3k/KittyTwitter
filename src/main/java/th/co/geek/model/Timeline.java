package th.co.geek.model;

import org.hibernate.validator.constraints.NotBlank;


public class Timeline {
	
	@NotBlank
	String userName;
	@NotBlank
	String message;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

	
	
	
	
	
	
	
}
