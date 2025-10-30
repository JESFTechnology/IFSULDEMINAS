package view;

import model.Rectangle;
import model.Shape;
import model.Square;

public class Main {

	public static void main(String[] args) {
		Shape rect = new Rectangle("Retangulo",10,5);
        
        System.out.println("Área Rectangulo 1: " + rect.getArea());

        // Liskov (onde espera super-classe, 
        // devemos poder passar uma sub-classe)

		rect = new Square("Quadrado",10);
		
        System.out.println("Área Quadrado 2: " + rect.getArea());
    }
}