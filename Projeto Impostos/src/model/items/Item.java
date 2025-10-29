package model.items;

import java.util.ArrayList;
import java.util.List;

import model.taxes.Tax;

public abstract class Item {
	private String name;
	private Double cost;
	private List<Tax> taxes;
	
	public Item (String name, Double cost) {
		this.name = name;
		setCost(cost);
		taxes = new ArrayList<>();
	}
	
	public Double getCost() {
		return cost;
	}
	
	public void setCost(Double cost) {
		if (cost < 0)
			throw new IllegalArgumentException("Custo invávlido: " + cost);
		
		this.cost = cost;
	}
	
	public boolean addTax(Tax tax) {
		if (tax == null)
			return false;
		
		if (taxes.contains(tax))
			return false;
		
		return taxes.add(tax);
	}
	
	protected List<Tax> getTaxes() {
		return taxes;
	}
	
	public abstract Double calculateFinalPrice();
}
