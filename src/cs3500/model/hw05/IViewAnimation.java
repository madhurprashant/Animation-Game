package cs3500.model.hw05;

import java.util.List;
import java.util.Map;

/**
 * This view prevents unauthorized access, particularly from view, into mutables.
 */
public interface IViewAnimation {

  /**
   * Reads the map animation.
   *
   * @return Returns the entire map.
   */
  Map<String, IShape> readAnimation();

  /**
   * Returns the shape in the particular map key.
   *
   * @param shapeName key value for a shape.
   * @return Returns a shape. If key is not present, key returns null.
   */
  IShape readShape(String shapeName) throws IllegalArgumentException;


  /**
   * This returns the shape's entire movement list.
   *
   * @param shapeName is the key value of shape.
   * @return Returns the shape's entire movement list.
   */
  List<Movement> readMovementList(String shapeName) throws IllegalArgumentException;

  /**
   * This class returns a specific movement specified by an integer. This acts as the get function
   * for list but safer for our purposes.
   *
   * @param shapeName key of map.
   * @param movepos   specific movement to be read within shape found by key.
   * @return a specific movement.
   */
  Movement readMovement(String shapeName, int movepos) throws IllegalArgumentException;

  /**
   * Returns the canvas that the animation will be drawn on.
   *
   * @return The canvas used for drawing.
   */
  Canvas getCanvas();


}
