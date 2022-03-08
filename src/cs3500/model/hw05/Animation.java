package cs3500.model.hw05;


import java.util.ArrayList;


/**
 * This is the class which will run the animation. It will act as the central model. All of the code
 * is abstracted into The abstract animation, which it extends.
 */
public class Animation extends AbstractAnimation {


  /**
   * Creates a constructor with a single starting shape, and it's corresponding key.
   *
   * @param shapeName the key
   * @param shape     the shape
   */
  public Animation(String shapeName, IShape shape) {
    super(shapeName, shape);
  }

  /**
   * This is the empty constructor.
   */
  public Animation() {
    super();
  }


  /**
   * This is the builder for the animation. This builder breaks everything down and does it's
   * thing.
   */
  public static final class AnimationBuilder implements
      cs3500.animator.util.AnimationBuilder<IAnimation> {

    IAnimation animation;
    Canvas canvas;

    /**
     * This is the builder constructor for the animation. This creates it all.
     */
    public AnimationBuilder() {
      animation = new Animation();
      Dimension canvasDimension = new Dimension(5000, 5000);
      PositionDouble canvasPos = new PositionDouble(0, 0);
      canvas = new Canvas(canvasDimension, canvasPos);
    }

    @Override
    public IAnimation build() {
      return new Animation();
    }

    @Override
    //x and y are to always be 0,0
    public cs3500.animator.util.AnimationBuilder<IAnimation> setBounds(int x, int y, int width,
        int height) {
      PositionDouble pd = new PositionDouble(x, y);
      Dimension canvasDimension = new Dimension(width, height);
      canvas = new Canvas(canvasDimension, pd);
      return this;
    }

    @Override
    public cs3500.animator.util.AnimationBuilder<IAnimation> declareShape(String name,
        String type) throws IllegalArgumentException {
      switch (type) {
        case "rect":
          animation.updateShape(name, new Rectangle(name, new ArrayList<>()));
          break;
        case "ellipse":
          animation.updateShape(name, new Circle(name, new ArrayList<>()));
          break;
        default:
          throw new IllegalArgumentException("Shape not recognized.");
      }

      return this;
    }

    @Override
    public cs3500.animator.util.AnimationBuilder<IAnimation> addMotion(String name, int t1, int x1,
        int y1,
        int w1, int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2,
        int g2, int b2) throws IllegalArgumentException {
      try {
        animation.readShape(name);
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException(e.getMessage());
      }

      Movement move = new Movement(t1, t2, x1, x2, y1, y2, w1, w2, h1, h2, r1, r2, g1, g2, b1, b2);
      animation.updateMovement(name, move);

      return this;

    }
  }
}
