package cs3500.view;

import cs3500.model.hw05.IShape;
import java.util.List;
import java.util.Map;

/**
 * This is the interface for all three of the views.
 */
public interface IView {

  void render(Map<IShape, List<Integer>> map);

}
