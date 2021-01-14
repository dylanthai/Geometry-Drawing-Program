import java.awt.Graphics;
import java.awt.Color;

class Square extends Shape {
  private int length;
  
  public Square(Color colour, int xCoordinate, int yCoordinate, int length) {
    this.type = "Square";
    this.colour = colour;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.length = length;
    this.area = (double) length*length;
  }
  
  public void draw (Graphics g) {
    g.setColor(colour);
    g.fillRect(xCoordinate, yCoordinate, length, length);
  }
  public String getShapeData() {
    String data = String.format("%s %d %d %d", type, length, xCoordinate, yCoordinate);
    return data;
  }
  public void displayShapeData() {
    System.out.printf("%s Length: %d XCoordinate: %d YCoordinate: %d Area: %.2f", type, length, xCoordinate,
                      yCoordinate, area);
  }
  public void setLength(int newLength) {
    length = newLength;
  }
  
  public void printLength() {
    System.out.println("The current length is: " + this.length);
  }
}