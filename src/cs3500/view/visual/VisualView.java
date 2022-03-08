package cs3500.view.visual;

import cs3500.model.hw05.IShape;
import cs3500.view.IView;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;



/**
 * This visual view makes sure to graph the GUI using swing.
 */
public class VisualView extends JFrame implements IView {

  private final CanvasPanel panel;

  /**
   * This is the visual view constructor.
   */
  public VisualView() {
    super("Visual View");
    this.panel = new CanvasPanel();
    this.panel.setPreferredSize(new Dimension(500, 500));
    this.panel.setVisible(true);
    this.add(panel, BorderLayout.CENTER);

    this.setSize(750, 750);
    setDefaultCloseOperation(EXIT_ON_CLOSE); // ^^ looks okay? wilco check
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(new JScrollPane(this.panel));

    setVisible(true);

  }


  @Override
  public void render(Map<IShape, List<Integer>> currentShapeValues) {
    panel.aquireCurrentLists(currentShapeValues);
    panel.repaint();
  }


}
