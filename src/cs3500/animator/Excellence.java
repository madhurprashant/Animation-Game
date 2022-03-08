package cs3500.animator;

import cs3500.animator.util.AnimationReader;
import cs3500.controller.Controller;
import cs3500.controller.IController;
import cs3500.model.hw05.Animation;
import cs3500.model.hw05.Animation.AnimationBuilder;
import cs3500.model.hw05.IAnimation;
import cs3500.model.hw05.IShape;
import cs3500.model.hw05.Movement;
import cs3500.model.hw05.Rectangle;
import cs3500.view.IView;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the runnable main class. It starts the entire program.
 */
public class Excellence {

  /**
   * This is the program that starts and runs the rest.
   *
   * @param args String args which run on inputs.
   */
  public static void main(String[] args) {

    IController controller;
    List<Movement> movelist = new ArrayList<>();
    Movement move1 = new Movement(0, 100, 10, 20, 10, 20, 50, 100, 50, 100, 100, 150, 0, 200, 200,
        0);
    IShape shape1;
    movelist.add(move1);
    shape1 = new Rectangle("Rect", movelist);

    IAnimation model = new Animation();
    model.updateShape(shape1.getShapeName(), shape1);

    IView view = null;
    int tps = 1;
    Readable reader;
    Appendable out = System.out;
    File file;

    if (args.length < 1) {
      return;
    }
    AnimationBuilder builder = new AnimationBuilder();
    model = builder.build();

    try {
      for (int i = 0; i < args.length; i = +2) {
        switch (args[i]) {
          case "-speed":
            tps = Integer.parseInt(args[i + 1]);
            break;
          case "-in":
            file = new File(args[i + 1]);
            reader = new FileReader(file);
            AnimationReader.parseFile(reader, builder);
            break;
          case "-view":
            view = Factory.viewFactory(args[i + 1], tps);
            break;
          case "out":
            out = new FileWriter(args[i + 1]);
            break;
          default:
            throw new IllegalArgumentException("The args input is not recognized.");
        }
      }
      controller = new Controller(view, model);
      controller.goe(tps);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
