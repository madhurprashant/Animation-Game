package cs3500.model.hw05;

/**
 * Represents the class PositionDouble that implements the object stream and therefore gives the
 * position or the X and the Y coordinate of the given object to be animated.
 */
public class PositionDouble extends AbstractCoordinates {

  /**
   * much like the dimension class, this stores two integer values meant for a coordinate.
   *
   * @param x represents an x-pos.
   * @param y represents a y-pos.
   */
  public PositionDouble(int x, int y) {
    super(x, y);
  }

}
