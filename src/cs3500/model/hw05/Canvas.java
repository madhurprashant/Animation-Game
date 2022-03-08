package cs3500.model.hw05;

import java.util.Objects;

/**
 * This represents where the model will be stored.
 */
public class Canvas {

  private final Dimension dimension;
  private final PositionDouble positionDouble;


  public Canvas(Dimension dimension, PositionDouble positionDouble) {
    this.dimension = Objects.requireNonNull(dimension);
    this.positionDouble = Objects.requireNonNull(positionDouble);
  }

  public Dimension getCanvasDimension() {
    return this.dimension;
  }

  public PositionDouble getCanvasPositionDouble() {
    return this.positionDouble;
  }
}
