package model;

public class Rectangle implements Shape{
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getDescription() {
        return String.format("Retângulo l: %.2f a: %.2f", width, height);
    }
}