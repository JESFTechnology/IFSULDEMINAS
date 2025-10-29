package view;

import model.items.Product;
import model.items.Service;
import model.taxes.ICMS;
import model.taxes.IPI;
import model.taxes.ISS;
import model.taxes.Tax;

public class Main {

	public static void main(String[] args) {
		//Testar serviço
		Service lavaJato = new Service("Lavagem de carros pequenos", 60.0);
		Tax iss = new ISS("machado");
		Tax icms = new ICMS("MG","SP");
		
		lavaJato.addTax(icms);
		lavaJato.addTax(iss);
		
		System.out.println("Preço da lavagem: R$"+lavaJato.calculateFinalPrice());
		
		//Testar produtos
		
		Product car = new Product("Pulse", 120000.0, 2000.0, 3200.0, 0.5);
		
		Tax ipi = new IPI("auto");
		car.addTax(ipi);
		car.addTax(icms);
		
		System.out.println("Preço do carro: R$"+car.calculateFinalPrice());
	}
}
