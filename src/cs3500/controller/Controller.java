package cs3500.controller;

import cs3500.model.hw05.IAnimation;
import cs3500.model.hw05.IShape;
import cs3500.model.hw05.Movement;
import cs3500.view.IView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.swing.Timer;

/**
 * This is the controller class. It encompasses everything there is to know about the controller.
 */
public class Controller implements IController {


  private int tickcounter = 0;
  private final IView view;
  private final IAnimation animation;
  private Timer timer;
  private int shapeCounter;
  private final Appendable out = System.out;

  public Controller(IView view, IAnimation animation) throws NullPointerException {
    this.view = Objects.requireNonNull(view);
    this.animation = Objects.requireNonNull(animation);
  }


  @Override
  public void goe(int tickRate) {

    try {
      Map<IShape, List<Integer>> map = update();
      view.render(map);
    } catch (Exception e) {
      e.printStackTrace();
      //System.out.println(e.printStackTrace());
      throw new IllegalStateException("False Animaton.");
    }
  }

  //update from ticks of controller into view update method

  @Override
  public IAnimation getAnimation() {
    return this.animation;
  }

  @Override
  public IView getView() {
    return this.view;
  }

  @Override
  public float intoSeconds(int tick, int rate) {
    return (float) (tick / rate);
  }

  //override goes here


  @Override
  public Map<IShape, List<Integer>> update() { //gets all updated shapepostition
    //should it return list of values? like current x, current y, current....
    //
    List<Integer> currentValues = new ArrayList<>();
    Map<IShape, List<Integer>> allcurrentShapeValues = new HashMap<>();
    for (Map.Entry<String, IShape> entry : animation.readAnimation().entrySet()) {
      IShape currentShape;
      currentShape = animation.readShape(entry.getKey());
      for (int i = 0; i < currentShape.getMoveList().size(); i++) {
        if (tickcounter >= currentShape.getMoveList().get(0).getFirstTick()
            && tickcounter <= currentShape.getMoveList().get(currentShape.getMoveList().size() - 1)
            .getLastTickk()) {
          Movement currentmovement = currentShape.getMovement(i);

          //add x to list
          currentValues.add(Tween.tweener(
              tickcounter, currentmovement.getFirstTick(), currentmovement.getLastTickk()
              , currentmovement.getFirstXPos(), currentmovement.getLastXPos()));
          //add y to list
          currentValues.add(Tween.tweener(
              tickcounter, currentmovement.getFirstTick(), currentmovement.getLastTickk()
              , currentmovement.getFirstYPos(), currentmovement.getLastYPos()));
          //add w to list
          currentValues.add(Tween.tweener(
              tickcounter, currentmovement.getFirstTick(), currentmovement.getLastTickk()
              , currentmovement.getFirstWPos(), currentmovement.getLastWPos()));
          //add h to list
          currentValues.add(Tween.tweener(
              tickcounter, currentmovement.getFirstTick(), currentmovement.getLastTickk()
              , currentmovement.getFirstHPos(), currentmovement.getLastHPos()));
          //add r to list
          currentValues.add(Tween.tweener(
              tickcounter, currentmovement.getFirstTick(), currentmovement.getLastTickk()
              , currentmovement.getFirstRPos(), currentmovement.getLastRPos()));
          //add g
          currentValues.add(Tween.tweener(
              tickcounter, currentmovement.getFirstTick(), currentmovement.getLastTickk()
              , currentmovement.getFirstGPos(), currentmovement.getLastGPos()));

          //add b
          currentValues.add(Tween.tweener(
              tickcounter, currentmovement.getFirstTick(), currentmovement.getLastTickk()
              , currentmovement.getFirstBPos(), currentmovement.getLastBPos()));
        }
      }
      allcurrentShapeValues.put(currentShape, currentValues);
      tickcounter++;
    }
    return allcurrentShapeValues;
  }

  @Override
  public int getTick() {
    return this.tickcounter;
  }


}
