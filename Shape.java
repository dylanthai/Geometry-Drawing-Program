import java.awt.Graphics;
import java.awt.Color;
import java.io.PrintWriter;    //import for file write


public abstract class Shape implements Comparable<Shape> {
  protected String type;
  protected Double area;
  protected Double perimeter;
  protected int xCoordinate;
  protected int yCoordinate;
  protected Color colour;
  
  /** Compare this shape to other shape by comparing the shape's area
    * @param other the Shape to compare to this Shape
    * @return a value < 0 if area is less than the other shape
    *                 > 0 if area is more than the other shape
    *                 = 0 if both shapes have the same area
    */
  
  @Override
  public int compareTo(Shape other) {
    return (int) (this.area - other.area);
  }
  
  public Double getPerimeter() {
    return perimeter;
  }
  public Double getArea() {
    return area;
  }
  public String getType() {
    return type;
  }
  public int getXCord() {
    return xCoordinate;
  }
  public int getYCord() {
    return yCoordinate;
  }
  public void printXCord() {
    System.out.println("The X Coordinate is: " + this.xCoordinate);
  }
  public void printYCord() {
     System.out.println("The Y Coordinate is: " + this.yCoordinate);
  }
  public void setXCord(int newX) {
    xCoordinate = newX;
  }
  public void setYCord(int newY) {
    yCoordinate = newY;
  }
  public void outputShapeData() {
    String data = getShapeData();
    System.out.println(data);
  }

  
  public void printShapeDataToFile(PrintWriter printWriter) {
    try {
      String data = getShapeData();
      printWriter.println(data);
    } catch (Exception e) {
      System.out.println("An error has occured while printing shape data to file.");
    }
  }

  abstract public void draw (Graphics g);
  
  abstract public String getShapeData();
  
  abstract public void displayShapeData();
  
  

}