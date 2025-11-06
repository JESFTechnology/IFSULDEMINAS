package controler;

import model.Product;
import model.Sales;
import model.SellItem;

public class SalesController {
	private Sales sales;
	
	public SalesController(Sales sales) {
		this.sales = sales;
	}
	
	public void addProduct(String name, double price, int amount) {
		Product product = new Product(name, price);
		SellItem sellItem = new SellItem(product, amount);
		sales.addSellItem(sellItem);
	}
}
