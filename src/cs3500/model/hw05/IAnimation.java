package cs3500.model.hw05;


/**
 * This is the general interface for the Animation, which represents a model.
 */
public interface IAnimation extends IViewAnimation {


  /**
   * New entry for the map of the same key. The map does not override shapes if the same key is
   * given, instead it throws IllegalArgsException.
   *
   * @param shapeName the name of the shape. This acts as the key for the map.
   */
  void create(String shapeName, IShape shape) throws IllegalArgumentException;


  /**
   * Adds a movement to a shape in the animation HashMap.
   *
   * @param shapeName shape key
   * @param move      move to be added to the corresponding shape's list
   */
  void updateMovement(String shapeName, Movement move) throws IllegalArgumentException;

  /**
   * Adds a shape to the animation.
   *
   * @param shapeName This is the shape key.
   * @param shape     This is the shape with all of it's data.
   */
  void updateShape(String shapeName, IShape shape) throws IllegalArgumentException;

  /**
   * Removes a shape from the animation map.
   *
   * @param shapeName the shape key for HashMap.
   */
  void removeShape(String shapeName) throws IllegalArgumentException;

  /**
   * This deletes a specific movement in the shape.
   *
   * @param shape    This is the shape key.
   * @param movement This is the movement to be removed.
   */
  void removeMovement(String shape, Movement movement) throws IllegalArgumentException;


}
