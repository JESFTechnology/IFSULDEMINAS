package model;

public class SMSSender implements Sender {

	@Override
	public void sender(String message) {
		System.out.println(String.format("Nova SMS \n%s\n", message));
		
	}
}