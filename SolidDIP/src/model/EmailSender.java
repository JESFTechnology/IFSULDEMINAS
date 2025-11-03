package model;

public class EmailSender implements Sender {

	@Override
	public void sender(String message) {
		System.out.println(String.format("Novo e-mail \n%s\n", message));
		
	}
}