package model.items;

import model.taxes.Tax;

public class Service extends Item {
	// TODO implementar a classe
	public Service(String name, Double cost) {
		super(name, cost);
	}
	@Override
	public Double calculateFinalPrice() {
		double totalTaxes = 0.0;
		
		for (Tax tax : getTaxes()) {
			totalTaxes += tax.calculateTax(this);
		}
		
		return getCost()+totalTaxes;
	};
}
