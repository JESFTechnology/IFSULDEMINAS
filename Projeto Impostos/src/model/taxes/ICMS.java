package model.taxes;

import model.items.Item;
import model.persistence.DataBaseMock;

public class ICMS extends Tax {
	private String from;
	private String to;
	
	public ICMS(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public Double calculateTax(Item item) {
		Double taxPercent = DataBaseMock.
				selectICMS(from, to);
		
		return item.getCost() * taxPercent;
	}
	
	@Override
	public String getName() {
		return "ICMS";
	}
}
