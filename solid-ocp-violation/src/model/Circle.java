package model;

public class Circle implements Shape{
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String getDescription() {
        return String.format("Círculo r: %.2f", radius);
    }
}