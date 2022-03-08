package cs3500.controller;

/**
 * This class conducts the tweening for every current variable, on the tick that it is on.
 */
public class Tween {

  /**
   * This is the function that conducts the tweening. It implements the equation given to us in the
   * homework
   *
   * @param currenttime the current tick being used
   * @param starttime   start time of motion
   * @param endtime     end time of motion
   * @param start       start position of variable being tweened
   * @param end         end position of that variable
   * @return the current position of variable
   */
  public static int tweener(int currenttime, int starttime, int endtime, int start, int end) {
    int totaltimechange = starttime - endtime;
    return (start * ((endtime - currenttime) / (totaltimechange))
        + end * ((currenttime - starttime) / (totaltimechange)));
  }

}
