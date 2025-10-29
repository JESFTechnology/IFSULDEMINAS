package model.items;

import model.taxes.Tax;

public class Product extends Item {
	private Double shipping;
	private Double insurance;
	private Double profits;
	
	public Product(String name,  Double cost,
			Double shipping, Double insureance, Double profits) {
		super(name, cost);
		
		this.insurance = insureance;
		this.shipping = shipping;
		this.profits = profits;
	}
	
	public Double getShipping() {
		return shipping;
	}
	
	public Double getInsurance() {
		return insurance;
	}
	
	@Override
	public Double calculateFinalPrice() {
		double totalTaxes = 0.0;
		
		for (Tax tax : getTaxes()) {
			totalTaxes += tax.calculateTax(this);
		}
		
		double totalCost = getCost()+totalTaxes+shipping+insurance;
		double profitsValue = totalCost * profits;
		
		return totalCost+profitsValue;
	}
}
