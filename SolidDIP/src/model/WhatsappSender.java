package model;

public class WhatsappSender implements Sender {

	@Override
	public void sender(String message) {
		System.out.println(String.format("Nova mensagem WhatsApp \n%s\n", message));
		
	}
	
}