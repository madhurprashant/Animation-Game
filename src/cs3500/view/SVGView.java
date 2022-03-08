package cs3500.view;

import cs3500.controller.IController;
import cs3500.model.hw05.Canvas;
import cs3500.model.hw05.IShape;
import cs3500.model.hw05.IViewAnimation;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is the SVG version of the view. It takes the data from model and reformats it into an SVG
 * file reader.
 */
public class SVGView implements IView {

  IController controller;
  private final Appendable out;
  private int tickspeed;

  /**
   * This is the constructor for the SVGView.
   *
   * @param out       output so that it can write to files.
   * @param tickspeed this is the tickspeed.
   */
  public SVGView(Appendable out, int tickspeed) {
    this.out = out;
    this.tickspeed = tickspeed;
  }

  @Override
  public void render(Map<IShape, List<Integer>> map) {
    try {
      out.append(this.toString());
      tickspeed++;
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }


  private StringBuilder appendableHelp(StringBuilder output, String shapeI, String x, String y,
      String w, String h, String shapeName) {

    try {
      out.append("a");
      tickspeed++;
    } catch (IOException e) {
      output.append(e.getMessage());
    }

    return output.append(shapeI).append(" id=\"").append(shapeName).append("\" x=\"")
        .append(movementList(output, shapeName, 0, x)).append("\" y=\"")
        .append(movementList(output, shapeName, 0, y)).append("\" width=\"")
        .append(movementList(output, shapeName, 0, w)).append("\" height=\"")
        .append(movementList(output, shapeName, 0, h)).append("\" fill=\"rgb(")
        .append(movementList(output, shapeName, 0, "r")).append(",")
        .append(movementList(output, shapeI, 0, "g"))
        .append(",").append(movementList(output, shapeName, 0, "b"))
        .append(")\" visibility=\"visible\"/>\n");

  }

  private String movementList(StringBuilder output, String name, int tickList, String grab) {
    output.append(String
        .valueOf(controller.getAnimation().readShape(name).getMoveList().get(0).getFirstTick()));
    return output.toString();

  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    Canvas canvas = this.controller.getAnimation().getCanvas();
    IViewAnimation animation = this.controller.getAnimation();

    String shapeI;
    String x;
    String y;
    String w;
    String h = "fail";
    String shapeName;

    output
        .append("<svg width=\"")
        .append(canvas.getCanvasDimension().getXValueCoordinate()).append("\" height=\"")
        .append(canvas.getCanvasDimension().getYValueCoordinate()).append("\" version=\"1.1\"\n")
        .append("  xmlns=\"http://www.w3.org/2000/svg\">\n");

    for (Entry<String, IShape> shape : animation.readAnimation().entrySet()) {

      output.append("\t<");

      switch (shape.getValue().getShapeKind()) {
        case RECTANGLE:
          shapeI = "rect";
          x = "x";
          y = "y";
          w = "width";
          h = "height";
          shapeName = shape.getKey();

          appendableHelp(output, shapeI, x, y, w, h, shapeName);

          break;
        case CIRCLE:
          shapeI = "ellipse";
          x = "cx";
          y = "cy";
          w = "rx";
          h = "ry";
          shapeName = shape.getKey();

          appendableHelp(output, shapeI, x, y, w, h, shapeName);
          break;
        default:
          throw new IllegalArgumentException("Illegal shape type.");
      }

    }
    output.append("</svg>");
    return output.toString();
  }

  public IController getController(IController controller) {
    return this.controller;
  }


}
