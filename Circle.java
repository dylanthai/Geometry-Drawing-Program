import java.awt.Graphics;
import java.awt.Color;

public class Circle extends Shape {
  private int radius;
  private int diameter;
  
  public Circle(Color colour, int xCoordinate, int yCoordinate, int radius) {
    this.type = "Circle";
    this.colour = colour;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.radius = radius;
    this.diameter = 2*radius;
    this.perimeter = 2*Math.PI*radius;
    this.area = Math.PI*Math.pow(radius, 2);
  }
  
  public void draw (Graphics g) {
    g.setColor(colour);
    g.fillOval(xCoordinate, yCoordinate, 2*radius, 2*radius);
  }
  public String getShapeData() {
    String data = String.format("%s %d %d %d", type, radius, xCoordinate, yCoordinate);
    return data;
  }
  public void displayShapeData() {
    System.out.printf("%s radius: %d diameter: %d XCoordinate: %d YCoordinate: %d Area: %.2f Circumference %.2f",
                                 type,radius, diameter, xCoordinate, yCoordinate, area, perimeter);
  }
  public void setRadius(int newRadius) {
    radius = newRadius;
  }
  public void printRadius() {
    System.out.println("The current radius is: " + this.radius);
  }
}