package model;

public class Notification {
	private String message;
	public Notification(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	public String sendEmail(String email) {
		Email emailSys = new Email(email, message);
		return emailSys.getMessageEmail();
	}
	
	public void sendSerial() {
		System.out.println(message); 
	}
	
	public void sendSerial(String messageCusto) {
		System.out.println(messageCusto);
	}
}
