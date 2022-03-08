package cs3500.model.hw05;

/**
 * Abstract class for a posn of two coordinates. This is then extended by Pos2D and Dimensions
 * classes.
 */
public abstract class AbstractCoordinates implements ICoordinates {

  // Represents the X-Coordinate of the given object in the course of animation
  private int x;
  // Represents the Y-Coordinate of the given object in the course of animation
  private int y;

  /**
   * Represents a pair of coordinates.
   *
   * @param x Arbitrary value x.
   * @param y Arbitrary value y.
   * @throws IllegalArgumentException If the values are negative.
   */
  public AbstractCoordinates(int x, int y) throws IllegalArgumentException {

    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("Values cannot be negative.");
    }
    // Represents initializing the X-Coordinate of the given object in the course of the given
    // animation
    this.x = x;
    // Represents initializing the Y-Coordinate of the given object in the course of the given
    // animation
    this.y = y;
  }

  // Represents the public setter and the getter methods in order to get the X and the Y-Coordinates
  // of the given animation

  /**
   * Represents the public function that sets the current x value to the new parameterized X-Value.
   *
   * @param nextXValue Represents the value to be set for the X-Coordinate of the given object
   */
  public void setXCoordinate(int nextXValue) {
    this.x = nextXValue;
  }

  /**
   * Represents the public function that sets the current y value to the new parameterized Y-Value.
   *
   * @param nextYValue Represents the value to be set for the Y-Coordinate of the given object
   */
  public void setYCoordinate(int nextYValue) {
    this.y = nextYValue;
  }

  /**
   * Represents the public function in order to get the X-Coordinate of the given object in the
   * course of the animation.
   */
  public int getXValueCoordinate() {
    // Returns the X-Coordinate of the given object in the course of the animation
    return this.x;
  }

  /**
   * Represents the public function in order to get the Y-Coordinate of the given object in the
   * course of the animation.
   */
  public int getYValueCoordinate() {
    // Returns the Y-Coordinate of the given object in the course of the animation
    return this.y;
  }

  @Override
  public String toString() {
    return Double.toString(getXValueCoordinate()) + " " + Double.toString(getYValueCoordinate());
  }
}
