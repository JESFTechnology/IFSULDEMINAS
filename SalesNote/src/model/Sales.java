package model;

import java.util.List;

public class Sales {
	private List<SellItem> sales;
	
	public Sales(List<SellItem> sales) {
		this.sales = sales;
	}

	public List<SellItem> getSales() {
		return sales;
	}

	public double amountSelled() {
		double value = 0;
		for(SellItem s : sales) {
			value += s.amountValue();
		}
		return value;
	}
	
}