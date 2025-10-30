package model;

public class Square extends Shape {

	private double side;

	public Square(String description, double side) {

		this.side = side;
	}

	public double getSide() {
		return side;
	}
	
	public void setSide(double side) {		
		this.side = side;
	}
	
	@Override
	public double getArea() {
		return side * side;
	}
}