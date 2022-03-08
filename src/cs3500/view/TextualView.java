package cs3500.view;

import cs3500.controller.IController;
import cs3500.model.hw05.IShape;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This textual view essentially runs a simple toString on the data.
 */
public class TextualView implements IView {

  IController controller;
  private final Appendable out;

  public TextualView(Appendable out) {
    this.out = out;
  }


  @Override
  public String toString() {
    return this.controller.getAnimation().toString();
  }

  @Override
  public void render(Map<IShape, List<Integer>> map) throws IllegalArgumentException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(String.valueOf(this.controller.getAnimation().getCanvas()));
    stringBuilder.append(this.toString());
    try {
      out.append(stringBuilder);
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot append to output.");
    }
  }

  public IController getController(IController controller) {
    return this.controller;
  }
}
