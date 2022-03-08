package cs3500.view.visual;

import cs3500.model.hw05.IShape;
import cs3500.view.IView;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the interactive view class. It runs commands given by user input.
 */
public class InteractiveView extends JFrame implements IView {


  private final JButton startButton;
  private final JButton pauseButton;
  private final JButton restartButton;
  private final JButton toggleLoopingButton;


  /**
   * This is the construtor for class.
   */
  public InteractiveView() {
    super();
    VisualView visview = new VisualView();

    this.setLayout(new BorderLayout());

    this.startButton = new JButton("start");
    this.pauseButton = new JButton("pause");
    this.restartButton = new JButton("restart");
    this.toggleLoopingButton = new JButton("Loop?");

    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.SOUTH);

    this.add(startButton);
    this.add(pauseButton);
    this.add(restartButton);
    this.add(toggleLoopingButton);

    setVisible(true);


  }


  @Override
  public void render(Map<IShape, List<Integer>> map) {
    this.repaint();

  }

  public boolean looping() {
    return toggleLoopingButton.isSelected();
  }

  /**
   * This sets the listeners.
   * @param actionListener the input.
   */
  public void setButtonListener(ActionListener actionListener) {
    restartButton.addActionListener(actionListener);
    startButton.addActionListener(actionListener);
    pauseButton.addActionListener(actionListener);
    toggleLoopingButton.addActionListener(actionListener);
  }
}
