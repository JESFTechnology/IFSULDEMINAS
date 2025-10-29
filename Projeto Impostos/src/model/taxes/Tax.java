package model.taxes;

import model.items.Item;

public abstract class Tax {
	public abstract String getName();
	public abstract Double calculateTax(Item item);
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		Tax otherTax = null; 
		
		try {
			// Cast
			otherTax = (Tax) obj;
		} catch (ClassCastException cce) {
			cce.printStackTrace();
			return false;
		}
		
		return this.getName().
					equals(otherTax.getName());
	}
}
