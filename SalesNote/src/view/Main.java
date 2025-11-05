package view;

import java.util.ArrayList;
import java.util.List;

import controller.InvoiceController;
import model.Product;
import model.Sales;
import model.SellItem;

public class Main {

	public static void main(String[] args) {
		Product product1 = new Product("Apresuntado Rezende ", 17.80);
		Product product2 = new Product("Queijo mussarela Porto Alegre", 29.80);
		Product product3 = new Product("Tomate", 2.50);
		
		SellItem item1 = new SellItem(product1, 5);
		SellItem item2 = new SellItem(product2, 2);
		SellItem item3 = new SellItem(product3, 1);
		
		List<SellItem> itemsList = new ArrayList();
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);

		Sales sell = new Sales(itemsList);
		
		InvoiceController controller = new InvoiceController();
		controller.showInVoice(controller.createListSelled(itemsList), sell.amountSelled()); 
	}

}