package view;

import model.SaleLog;
import model.Sale;
import model.SaleItem;

public class Logging implements SaleLog {
	
	public void show(Sale sales) {
		System.out.println("***** Nota de venda *****");
		System.out.printf("%-15s %-10s %-10s %-10s","Produto", "Preço","Quantidade", "Total");
		
		System.out.println();
		
		for (SaleItem item : sales.getSales()) {
			int stringlength = item.getProduct().getDescription().length();
			int length = item.getProduct().getDescription().length() > 15 ? 15 : stringlength; 
			System.out.printf("%-15s %-10.2f %-10d %-10.2f\n",item.getProduct().getDescription().substring(0, length),
			item.getProduct().getPrice(),
			item.getQuantity(),
			item.amountValue());
		}
		
		System.out.printf("%37s %.2f ", "Total" ,sales.amountSelled());
		System.out.printf("%37s %s\n", "Método de pagamento", sales.paymentMethod());
		System.out.printf("%37s %.2f\n", "Valor a ser pago", sales.valueToBePaid());
	}
}
