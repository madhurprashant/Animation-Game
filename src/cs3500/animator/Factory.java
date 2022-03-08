package cs3500.animator;

import cs3500.view.IView;
import cs3500.view.SVGView;
import cs3500.view.TextualView;
import cs3500.view.visual.InteractiveView;
import cs3500.view.visual.VisualView;

/**
 * Factory class made so the view will be easy to see.
 */
public class Factory {

  public Factory() {
    //this is important for calling method.
  }

  /**
   * This is the factory class, which delegates view responses.
   *
   * @param s   the string args input.
   * @param tps the ticks per second.
   * @return an empty view.
   */
  public static IView viewFactory(String s, int tps) {
    Appendable out = System.out;
    switch (s) {
      case "visual":
        return new VisualView();
      case "text":
        return new TextualView(out);
      case "svg":
        return new SVGView(out, tps);
      case "interactive":
        return new InteractiveView();
      default:
        throw new IllegalStateException("Unknown View Type.");
    }
  }
}
