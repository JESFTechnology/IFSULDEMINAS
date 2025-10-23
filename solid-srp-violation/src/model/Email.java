package model;

public class Email {
	private String messageEmail;
	public Email(String email, String message) { 
        // Simulando envio de email
        this.messageEmail = "Sending invoice to " + email + ":\n" + message;
    }
	
	public String getMessageEmail() {
		return this.messageEmail;
	}
}
