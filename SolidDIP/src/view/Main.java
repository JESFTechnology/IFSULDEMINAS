package view;

import java.util.ArrayList;
import java.util.List;

import model.EmailSender;
import model.NotificationService;
import model.SMSSender;
import model.Sender;
import model.WhatsappSender;

public class Main {

	public static void main(String[] args) {
		

		List<Sender> senders = new ArrayList<>();
		senders.add(new EmailSender());
		senders.add(new SMSSender());		
		senders.add(new WhatsappSender());
		
		NotificationService notificationService = new NotificationService(senders);
		notificationService.notifyUser("Seu código de acesso é @eac82");
	}
}