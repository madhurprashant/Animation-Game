package cs3500.controller;

import cs3500.model.hw05.IShape;
import cs3500.model.hw05.IViewAnimation;
import cs3500.view.IView;
import java.util.List;
import java.util.Map;

/**
 * Interface for the controller.
 */
public interface IController {

  /**
   * This method starts and makes the animation playable.
   *
   * @param tickRate the given tickrate for the animation.
   */
  void goe(int tickRate);

  /**
   * Gets the model given to controller. The visual VIEW one only!
   *
   * @return The animation.
   */
  IViewAnimation getAnimation();

  /**
   * Gets the view which is controller param.
   *
   * @return Returns the View.
   */
  IView getView();

  /**
   * This converts the ticks and rate into time of seconds.
   *
   * @param tick given ticks.
   * @param rate given rate.
   * @return time now in seconds. This assumes the rate is given in tps.
   */
  float intoSeconds(int tick, int rate);


  Map<IShape, List<Integer>> update();

  int getTick();
}
