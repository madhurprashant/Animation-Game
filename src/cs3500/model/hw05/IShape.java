package cs3500.model.hw05;


import java.util.List;

/**
 * Represents the Model.IShapeAnimator interface containing and implementing all the functions and
 * methods used for the shape types, that is, a Rectangle, Square, Circle, and an Ellipse to be used
 * in the model for the implementation of the animation, where this class extends Cloneable and a
 * Serializable in order to create a clone new given object and in order to convert the stream of a
 * given Object.
 */
public interface IShape {


  /**
   * Represents the function in order to get the type of the shape that the animation is entailing.
   */
  ShapeKind getShapeKind();

  /**
   * Returns the shape name, which acts as the key for shape.
   */
  String getShapeName();


  /**
   * Returns the entire list of movements that the shape will undertake.
   *
   * @return
   */
  List<Movement> getMoveList();

  //THESE NEED TO BE IMPLEMENTED

  /**
   * Represents the function in order to remove the given move.
   *
   * @param movementPosition Represents the position from which the animation has to removed
   */
  void removeMove(Movement movementPosition);

  /**
   * Represents the function in order to get the movement from the given position.
   *
   * @param i Represents the movement from the int i
   * @return Movement
   */
  Movement getMovement(int i);

  /**
   * Represents the function in order to add the movement to the given animation.
   *
   * @param movement Represents the parameterized movement
   */
  void addMovement(Movement movement);

  /**
   * Represents teh function to get the list of movements through the given course of animation.
   *
   * @return List of movements
   */
  List<Movement> getList();


}

