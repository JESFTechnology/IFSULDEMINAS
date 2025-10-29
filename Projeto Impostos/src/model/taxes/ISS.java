package model.taxes;

import model.items.Item;
import model.items.Service;
import model.persistence.DataBaseMock;

public class ISS extends Tax {

	private String city;
	
	public ISS(String city) {
		this.city = city;
	}
	
	@Override
	public String getName() {
		return "ISS";
	}

	@Override
	public Double calculateTax(Item item) {
		try {
			Service service = (Service) item;
		} catch (ClassCastException cce) {
			throw new IllegalStateException("Item inválido ISS.");
		}
		
		Double taxPercent = DataBaseMock.selectISS(city);
		
		return item.getCost() * taxPercent;
	}
}
