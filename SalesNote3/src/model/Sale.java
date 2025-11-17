package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
	private List<SaleItem> sales;
	private Payment payment;
	
	public Sale() {
		this.sales = new ArrayList<>();
	}

	public List<SaleItem> getSales() {
		return sales;
	}

	public double amountSelled(){
		double value = 0;
		for(SaleItem s : sales) {
			value += s.amountValue();
		}
		return value;
	}
	
	public boolean addItem(String code, int amount) {
		Product product;
		try {
			product = new Product(code);
		} catch (IllegalArgumentException e) {
			System.err.println("Erro ao adicionar item: " + e.getMessage());
			return false;
		}

		if (product.getStock() >= amount) {
			SaleItem saleItem = new SaleItem(product, amount);
			return sales.add(saleItem);
		} else {
			throw new IllegalArgumentException("Estoque baixo");
		}
	}	
	
	public void cretePayment(String paymentMethod) {
		payment = DBMock.selectPayment(paymentMethod);
	}
	
	public double valueToBePaid() {
		if (payment == null)
			throw new IllegalStateException("Método de pagamento não definido");
		
		return payment.valueToBePaid(amountSelled());
	}
	
	public String paymentMethod() {
		return payment == null ? "" : payment.toString();
	}
}