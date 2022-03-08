package cs3500.model.hw05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This acts as the Animation Abstract class withing the model for the project. This contains a list
 * of shapes.
 */
public abstract class AbstractAnimation implements IAnimation {

  private final Map<String, IShape> animation;
  private final Dimension canvasDimensions;
  private final PositionDouble canvasPositions;
  private final Canvas canvas;

  /**
   * Empty Constructor, if needed.
   */
  public AbstractAnimation() {
    this.canvasDimensions = new Dimension(5000, 5000);
    this.canvasPositions = new PositionDouble(0, 0);
    this.canvas = new Canvas(canvasDimensions, canvasPositions);
    this.animation = new HashMap<>();
  }

  /**
   * This is the constructor for changing canvas dims.
   *
   * @param canvasWidth  the width.
   * @param canvasHeight height.
   * @param canvasXPos   x position of canvas.
   * @param canvasYPos   y position of canvas.
   * @param shapeName    the name of shape.
   * @param shape        the shape.
   * @throws IllegalArgumentException if inputs are null of if there is issue.
   */
  public AbstractAnimation(int canvasWidth, int canvasHeight, int canvasXPos, int canvasYPos,
      String shapeName, IShape shape)
      throws IllegalArgumentException {
    this.canvasPositions = new PositionDouble(canvasXPos, canvasYPos);
    this.canvasDimensions = new Dimension(canvasWidth, canvasHeight);
    this.canvas = new Canvas(canvasDimensions, canvasPositions);
    this.animation = new HashMap<>();
    if (shapeName == null || shape == null) {
      throw new IllegalArgumentException("Inputs cannot be null.");
    }
    this.create(shapeName, shape);
  }

  /**
   * This creates an animation.
   *
   * @param shapeName Name, which is key.
   * @param shape     Shape.
   * @throws IllegalArgumentException if create finds any errors.
   */
  public AbstractAnimation(String shapeName, IShape shape) throws IllegalArgumentException {
    this.canvasDimensions = new Dimension(5000, 5000);
    this.canvasPositions = new PositionDouble(0, 0);
    this.canvas = new Canvas(canvasDimensions, canvasPositions);

    this.animation = new HashMap<>();
    this.create(shapeName, shape);
  }

  //create

  /**
   * This method puts a shape into the animation map.
   *
   * @param shapeName the name of the shape. This acts as the key for the map.
   * @param shape     This is the shape to be inputted.
   * @throws IllegalArgumentException if inputs are null, if the key already exists, or if the
   *                                  shapename string does not adhere to the name of shape.
   */
  public void create(String shapeName, IShape shape) throws IllegalArgumentException {
    if (shapeName == null || shape == null) {
      throw new IllegalArgumentException("Inputs cannot be null.");
    }
    if (this.animation.containsKey(shapeName)) {
      throw new IllegalArgumentException("The key " + shapeName + " already exists. Try again.");
    } else if (!shapeName.equals(shape.getShapeName())) {
      throw new IllegalArgumentException("The given shapename must be "
          + "equivalent to the internal name of shape.");
    }
    this.animation.put(shapeName, shape);
  }

  // can also make a create function that takes the shape and gets the name from the shape, using
  //that as input for animation key???

  //readAnimation

  /**
   * This returns the animation map of the shape.
   *
   * @return This returns the animation map of the shape.
   */
  public Map<String, IShape> readAnimation() {
    Map<String, IShape> temp = new HashMap<>(this.animation);
    return temp;
  }

  //readShape

  /**
   * This function returns the shape.
   *
   * @param shapeName key value for a shape.
   * @return The shape indicated by the shapename (the key).
   * @throws IllegalArgumentException if the input is null, or if the shape isn't found.
   */
  public IShape readShape(String shapeName) throws IllegalArgumentException {
    if (shapeName == null) {
      throw new IllegalArgumentException("Input cannot be null.");
    }
    if (this.animation.containsKey(shapeName)) {
      return this.animation.get(shapeName);
    } else {
      throw new IllegalArgumentException("404 - Shape not found.");
    }
  }

  //readMovementList
  public List<Movement> readMovementList(String shapeName) throws IllegalArgumentException {
    return readShape(shapeName).getList();
  }

  //readMovement
  public Movement readMovement(String shapeName, int movementPosition)
      throws IllegalArgumentException {
    return readShape(shapeName).getMovement(0);
  }

  //update add movement to shape

  /**
   * This adds a movement to the shape.
   *
   * @param shapeName shape key
   * @param movement  The movment to be added.
   * @throws IllegalArgumentException if readShape or addMovement have issues.
   */
  public void updateMovement(String shapeName, Movement movement) throws IllegalArgumentException {
    //add movement needs to check for tick overlap
    //linked list? because it needs to start on zero
    readShape(shapeName).addMovement(movement);
  }

  //update add shape to animation

  /**
   * This method adds shape to the animation.
   *
   * @param shapeName This is the shape key.
   * @param shape     This is the shape with all of it's data.
   * @throws IllegalArgumentException if the inputs are null or if the animation already has shape.
   */
  public void updateShape(String shapeName, IShape shape) throws IllegalArgumentException {
    if (shapeName == null || shape == null) {
      throw new IllegalArgumentException("Inputs cannot be null.");
    }
    if (this.animation.containsKey(shapeName)) {
      throw new IllegalArgumentException(
          "The animation already contains this shape - try a different name.");
    } else {
      if (shapeName.equals(shape.getShapeName())) {
        this.animation.putIfAbsent(shapeName, shape);
      } else {
        throw new IllegalArgumentException("Shape name must equal internal shape name.");
      }
    }
  }

  //remove shape

  /**
   * This removes a shape from the hashmap.
   *
   * @param shapeName the shape key for HashMap.
   * @throws IllegalArgumentException if the shape is not found.
   */
  public void removeShape(String shapeName) throws IllegalArgumentException {
    if (this.animation.containsKey(shapeName)) {
      this.animation.remove(shapeName);
    } else {
      throw new IllegalArgumentException("404 - shape not found.");
    }

  }

  //remove movement
  public void removeMovement(String shapeName, Movement movementPosition)
      throws IllegalArgumentException {
    readShape(shapeName).removeMove(movementPosition);
  }

  @Override
  public String toString() {
    StringBuilder build = new StringBuilder();
    for (Map.Entry<String, IShape> entry : animation.entrySet()) {
      build.append(entry.getValue().toString());
    }
    return build.toString();
  }

  @Override
  public Canvas getCanvas() {
    return this.canvas;
  }


}
