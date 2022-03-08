package cs3500.model.hw05;


/**
 * Represents this class Color that focuses on getting the colors of the shapes and the animation,
 * that is, red, blue, and green.
 */
public class Color {

  // Represents the first color, that is, red in the form of a double
  private int redColor;
  // Represents the second color, that is, blue in the form of a double
  private int blueColor;
  // Represents the third color, that is, green in the form of a double
  private int greenColor;

  /**
   * Represents initializing the colors and their double values.
   *
   * @param redColor   The R value of RGB.
   * @param blueColor  The B value of RGB.
   * @param greenColor the G value of RGB.
   */
  public Color(int redColor, int blueColor, int greenColor) throws IllegalArgumentException {
    // Represents the condition in which an illegalArgumentException will be thrown
    // if the double values of the colors go out of bounds
    if (redColor > 255.0 || redColor < 0 || blueColor > 255.0 || blueColor < 0
        || greenColor > 255.0 || greenColor < 0) {
      throw new IllegalArgumentException("The values of the colors are invalid since they are"
          + "out of bounds!");
    }
    this.redColor = redColor;
    this.blueColor = blueColor;
    this.greenColor = greenColor;
  }

  /**
   * Represents the function which focuses on assigning the color to the given in color.
   *
   * @param givenColor Represents the given in color
   */
  public void getGivenInColor(Color givenColor) {
    this.redColor = givenColor.redColor;
    this.blueColor = givenColor.blueColor;
    this.greenColor = givenColor.greenColor;
  }

  /**
   * Represents the function in order to get the red color.
   *
   * @return Double    Returns the red color
   */
  public int getRedColor() {
    return this.redColor;
  }

  /**
   * Represents the function in order to get the blue color.
   *
   * @return Double    Returns the blue color
   */
  public int getBlueColor() {
    return this.blueColor;
  }

  /**
   * Represents the function in order to get the green color.
   *
   * @return Double    Returns the green color
   */
  public int getGreenColor() {
    return this.greenColor;
  }

  @Override
  public String toString() {
    return Integer.toString(getRedColor()) + " " + Integer.toString(getGreenColor()) + " " + Integer
        .toString(getBlueColor());
  }
}
