package cs3500.model.hw05;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents the abstract shape animation class that implements the different variables in the case
 * both the the shapes having common parameters and the functions from implementing the
 * IShapeAnimation class that are similar for both of the shapes.
 */
public abstract class AShape implements IShape {

  private final String shapeName;
  private ShapeKind shapeKind = null;
  private final List<Movement> moveList;


  /**
   * This is the constructor for a single shape. The shape contains the list of movements. The list
   * of movements cannot overlap tickwise, or have gaps.
   *
   * @param shapeName This is the name, and key to the shape.
   * @param moveList  This is the list of movements.
   * @throws IllegalArgumentException if there is an error in getShapeKind().
   */
  public AShape(String shapeName, List<Movement> moveList) throws IllegalArgumentException {
    if (shapeName == null) {
      throw new IllegalArgumentException("Name cannot be null. This is the primary identifier.");
    }
    this.shapeName = shapeName;
    this.shapeKind = getShapeKind();
    this.moveList = new ArrayList<>(moveList);
  }

  public abstract ShapeKind getShapeKind();

  public String getShapeName() {
    String temp = this.shapeName;
    return temp;
  }

  public List<Movement> getMoveList() {
    List<Movement> temp = new ArrayList<>(this.moveList);
    return temp;
  }

  /**
   * This is a method that removes a single movement.
   *
   * @param movePos The movement to be removed.
   */
  public void removeMove(Movement movePos) {
    if (moveList.contains(movePos)) {
      this.moveList.remove(movePos);
    } else {
      throw new IllegalArgumentException("Movement not found.");
    }
  }

  /**
   * This returns a movement specified.
   *
   * @param i Represents the movement from the int i
   * @return returns the movement.
   * @throws IllegalArgumentException If the index is out of bounds.
   */
  public Movement getMovement(int i) throws IllegalArgumentException {
    try {
      this.moveList.get(i);
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("The index is out of bounds.");
    }
    List<Movement> temp = new ArrayList<Movement>(this.moveList);
    return temp.get(i);
  }

  /**
   * This method adds a single movement.
   *
   * @param movement Represents the parameterized movement
   * @throws IllegalArgumentException if the ticks are not in order.
   */
  public void addMovement(Movement movement) throws IllegalArgumentException {
    Movement finalmove = this.moveList.get(this.moveList.size() - 1);

    if (movement.tickList.get(0) < finalmove.tickList.get(1)) {
      throw new IllegalArgumentException(
          "The ticks must be placed in order. This tick cannot be placed here.");
    }

    if (!movement.tickList.get(0).equals(finalmove.tickList.get(1))) {
      Movement emptymove = new Movement(finalmove.tickList.get(1), movement.tickList.get(0),
          finalmove.positionDoubleList.get(0).getXValueCoordinate(),
          finalmove.positionDoubleList.get(1).getXValueCoordinate(),
          finalmove.positionDoubleList.get(0).getYValueCoordinate(),
          finalmove.positionDoubleList.get(1).getYValueCoordinate(),
          finalmove.dimensionList.get(0).getXValueCoordinate(),
          finalmove.dimensionList.get(1).getXValueCoordinate(),
          finalmove.dimensionList.get(0).getYValueCoordinate(),
          finalmove.dimensionList.get(1).getYValueCoordinate(),
          finalmove.colorList.get(0).getRedColor(), finalmove.colorList.get(1).getRedColor(),
          finalmove.colorList.get(0).getGreenColor(), finalmove.colorList.get(1).getGreenColor(),
          finalmove.colorList.get(0).getBlueColor(), finalmove.colorList.get(1).getBlueColor());
      this.moveList.add(emptymove);
    } else {
      this.moveList.add(movement);
    }
  }

  public List<Movement> getList() {
    List<Movement> tempMove = new ArrayList<>(this.moveList);
    return tempMove;
  }


  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("shape ");
    stringBuilder.append(shapeName).append(" ");
    switch (shapeKind) {
      case CIRCLE:
        stringBuilder.append("ellipse");
        break;
      case RECTANGLE:
        stringBuilder.append("rectangle");
        break;
      default:
        stringBuilder.append("ERROR NO SHAPE FOUND ERROR");
    }
    stringBuilder.append("\n");
    for (Movement movement : moveList) {
      stringBuilder.append(movement.toString());
    }
    return stringBuilder.toString();
  }

  //constructor
  //gets and sets


}
