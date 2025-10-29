package view;

import model.AreaCalculator;
import model.Circle;
import model.Rectangle;
import model.Square;

public class Main {

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(5.0, 10.0);
		Circle circle = new Circle(8.5);
		Square sqre = new Square(12.0);
		
		AreaCalculator calculator = new AreaCalculator();
		
		calculator.calculateArea(rect);
		calculator.calculateArea(circle);
		calculator.calculateArea(sqre);
		
		
		for (String shape : calculator.getAreas())
			System.out.println(shape);
	}
}