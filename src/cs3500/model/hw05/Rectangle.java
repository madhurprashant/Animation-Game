package cs3500.model.hw05;

import java.util.List;

/**
 * This is a shapetype class that helps the enum enforce that desired shapetype through it's method
 * override.
 */
public class Rectangle extends AShape implements IShape {

  /**
   * This constructor creates a shape of a rectangle.
   *
   * @param shapeName    This is the name and key of shape.
   * @param movementList This is the list of all movements the shape makes.
   */
  public Rectangle(String shapeName, List<Movement> movementList) {
    super(shapeName, movementList);
  }

  /**
   * Represents the function in order to return the name of the given shape.
   *
   * @return Returns the shape name.
   */
  @Override
  public ShapeKind getShapeKind() {
    return ShapeKind.RECTANGLE;
  }
}
