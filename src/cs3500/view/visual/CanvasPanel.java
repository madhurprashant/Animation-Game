package cs3500.view.visual;

import cs3500.model.hw05.IShape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;

/**
 * This is the canvas panel for the visual view.
 */
public class CanvasPanel extends JPanel {

  Map<IShape, List<Integer>> shapesCurrData;


  /**
   * This is the constructor for class.
   */
  public CanvasPanel() {
    shapesCurrData = new HashMap<>();
    setLayout(new GridBagLayout());
    GridBagConstraints gc = new GridBagConstraints();

  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    super.revalidate();
    super.repaint();
    Graphics2D graphics2D = (Graphics2D) g;

    for (Map.Entry<IShape, List<Integer>> entry : shapesCurrData.entrySet()) {

      RectangularShape currentshape = null;
      switch (entry.getKey().getShapeKind()) {
        case CIRCLE:
          currentshape = new Ellipse2D.Double(entry.getValue().get(0),
              entry.getValue().get(1), entry.getValue().get(3), entry.getValue().get(4));
          break;
        case RECTANGLE:
          currentshape = new Rectangle2D.Double(entry.getValue().get(0),
              entry.getValue().get(1), entry.getValue().get(3), entry.getValue().get(4));
          break;
        default:
          break;
        //no default
      }
      graphics2D.setColor(new Color(entry.getValue().get(4),
          entry.getValue().get(5), entry.getValue().get(6)));
      graphics2D.fill(currentshape);
      graphics2D.draw(currentshape);
    }

  }

  public Map<IShape, List<Integer>> aquireCurrentLists(Map<IShape, List<Integer>> shapesCurrData) {
    return this.shapesCurrData;
  }


}
