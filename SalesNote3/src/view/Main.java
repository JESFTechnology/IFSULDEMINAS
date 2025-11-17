package view;

import model.Sale;
import model.SaleLog;

public class Main {

	public static void main(String[] args) {
		Sale sale = new Sale();
		sale.addItem("pn", 1);
		sale.addItem("fn", 2);
		sale.addItem("ms", 4);
		
		sale.cretePayment("dc");
		
		SaleLog logging = new Logging();
		logging.show(sale);
	}

}
