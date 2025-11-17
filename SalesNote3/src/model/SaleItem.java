package model;

public class SaleItem {
	private Product product;
	private int quantity;
	
	public SaleItem(Product product, int amount) {
		this.product = product;
		this.quantity = amount;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double amountValue() {
		return product.getPrice() * quantity;
	}
}