package model;

import java.util.HashMap;
import java.util.Map;

public class DBMock {
	private final static Map<String, String[]> products = new HashMap<>();
	private final static Map<String, Payment> payments = new HashMap<>();
	
	static {
		products.put("pn", new String[] {"Picole Nobre", "50", "4"});
		products.put("fn", new String[] {"Feijão Nobre", "45", "14"});
		products.put("ms", new String[] {"Macarrão Santa Amália", "8", "8"});
		payments.put("cc", new CreditCard(5));
		payments.put("dc", new DebitCard(0));
		payments.put("pc", new Cash(5.0));
	}
	
	public static String[] selectProduct(String code) {
		return products.get(code);
	}
	
	public static Payment selectPayment(String code) {
		return payments.get(code);
	}
	
	public static void updateStock(String code, int newStock) {
		String[] productData = products.get(code);
		if (productData != null) {
			productData[2] = String.valueOf(newStock);
			products.put(code, productData);
		}
	}
}
