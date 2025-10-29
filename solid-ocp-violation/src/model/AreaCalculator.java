package model;

import java.util.ArrayList;
import java.util.List;

public class AreaCalculator {

    private List<String> areas = new ArrayList<>();

    public double calculateArea(Shape shape) {
        double area = shape.calculateArea();
        areas.add(String.format("%s = %.2f", shape.getDescription(), area));
        return area;
    }

    public List<String> getAreas() {
        return new ArrayList<>(areas);
    }
}