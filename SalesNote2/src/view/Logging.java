package view;

import model.SaleLog;
import model.Sales;
import model.SellItem;

public class Logging implements SaleLog {
	
	public void show(Sales sales) {
		System.out.println("***** Nota de venda *****");
		System.out.printf("%-15s %-10s %-10s %-10s","Produto", "Preço","Quantidade", "Total");
		
		System.out.println();
		
		for (SellItem item : sales.getSales()) {
			System.out.printf("%-15s %-10.2f %-10d %-10.2f\n",item.getProduct().getName(),
			item.getProduct().getPrice(),
			item.getQuantity(),
			item.amountValue());
		}
		
		System.out.printf("%37s %.2f ", "Total" ,sales.amountSelled());
	}
}
