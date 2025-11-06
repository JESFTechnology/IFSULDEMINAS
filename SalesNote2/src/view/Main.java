package view;

import controler.SalesController;
import model.Sales;

public class Main {

	public static void main(String[] args) {
		Sales sales = new Sales();
		
		SalesController salesController = new SalesController(sales);
		
		salesController.addProduct("Apresuntado", 17.80, 1);
		salesController.addProduct("Queijo", 29.80, 1);
		salesController.addProduct("Tomate", 2.50, 3);
		
		Logging logging = new Logging();
		logging.show(sales);
	}

}
