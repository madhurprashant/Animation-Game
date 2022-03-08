package cs3500.model.hw05;

/**
 * Represents the interface Coordinates with the given functions to be implemented by the abstract
 * coordinates class and the classes extending that abstract class.
 */
public interface ICoordinates {

  /**
   * Represents the public function that sets the current x value to the new parameterized X-Value.
   *
   * @param nextXValue Represents the value to be set for the X-Coordinate of the given object
   */
  public void setXCoordinate(int nextXValue);

  /**
   * Represents the public function that sets the current y value to the new parameterized Y-Value.
   *
   * @param nextYValue Represents the value to be set for the Y-Coordinate of the given object
   */
  public void setYCoordinate(int nextYValue);

  /**
   * Represents the public function in order to get the X-Coordinate of the given object in the
   * course of the animation.
   */
  public int getXValueCoordinate();

  /**
   * Represents the public function in order to get the Y-Coordinate of the given object in the
   * course of the animation.
   */
  public int getYValueCoordinate();
}
