package model.taxes;

import model.items.Item;
import model.items.Product;
import model.persistence.DataBaseMock;

public class IPI extends Tax {
	private String segment;
	
	
	public IPI(String segment) {
		this.segment = segment;
	}
	
	@Override
	public String getName() {
		return "IPI";
	}

	@Override
	public Double calculateTax(Item item) {
		Product product = null;
		try {
			product = (Product) item;
		} catch (ClassCastException cce) {
			throw new 
				IllegalStateException("Item inválido para IPI");
		}
		
		Double taxPercent = DataBaseMock.
				selectIPI(segment);
		
		Double baseValue = product.getCost() + 
				           product.getInsurance() + 
				           product.getShipping();
		
		return baseValue * taxPercent;
	}
}
