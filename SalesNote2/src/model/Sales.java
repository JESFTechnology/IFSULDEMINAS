package model;

import java.util.ArrayList;
import java.util.List;

public class Sales {
	
	private List<SellItem> sales;
	
	public Sales() {
		this.sales = new ArrayList<>();
	}

	public List<SellItem> getSales() {
		return sales;
	}

	public double amountSelled(){
		double value = 0;
		for(SellItem s : sales) {
			value += s.amountValue();
		}
		return value;
	}
	
	public boolean addSellItem(SellItem item) {
		if (item == null)
			throw new IllegalArgumentException("Item de venda inválido");
		
		return sales.add(item);
	}	
}