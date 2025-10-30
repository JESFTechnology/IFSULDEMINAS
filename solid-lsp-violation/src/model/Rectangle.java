package model;

public class Rectangle extends Shape {
	
	private double width;
	private double length;

	
	public Rectangle( String description, double length, double width) {		
		this.width = width;
		this.length = length;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}

	@Override
	public double getArea () {
		return width * length;
	}
	
}