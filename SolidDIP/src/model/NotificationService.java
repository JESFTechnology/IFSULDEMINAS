
package model;

import java.util.List;

public class NotificationService {

	private List<Sender> senders;
	
	public NotificationService(List<Sender> senders) {
		this.senders = senders;
	}

	public void notifyUser(String message) {
		for (Sender senders : senders)
			senders.sender(message);
	}
}
