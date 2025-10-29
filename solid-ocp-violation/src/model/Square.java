package model;

public class Square implements Shape{
	private double side;
	
	public Square(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public String getDescription() {
        return String.format("Quadrado l: %.2f", side);
    }
}