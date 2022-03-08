package cs3500.model.hw05;

import java.util.List;

/**
 * This is the circle class, which represents one of the shapetypes.
 */
public class Circle extends AShape implements IShape {

  public Circle(String shapeName, List<Movement> movementList) {
    super(shapeName, movementList);
  }

  /**
   * Represents the function in order to return the name of the given shape.
   *
   * @return Returns the shape name.
   */
  @Override
  public ShapeKind getShapeKind() {
    return ShapeKind.CIRCLE;
  }
}
