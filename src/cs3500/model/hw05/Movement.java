package cs3500.model.hw05;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents A single movement that a shape can make.
 */
public class Movement {

  List<Integer> tickList;
  List<PositionDouble> positionDoubleList;
  List<Dimension> dimensionList;
  List<Color> colorList;

  PositionDouble startPosition;
  PositionDouble endPosition;

  Dimension startDimension;
  Dimension endDimension;

  Color startColor;
  Color endColor;


  /**
   * This is the constructor which takes in all of the integer values needed for the data and
   * represents it properly.
   *
   * @param starttick start tick.
   * @param endtick   end tick.
   * @param startx    start x.
   * @param endx      end x.
   * @param starty    start y.
   * @param endy      end y.
   * @param startw    start w.
   * @param endw      end w.
   * @param starth    start h.
   * @param endh      end g.
   * @param startr    start r.
   * @param endr      end r.
   * @param startg    start g.
   * @param endg      end g.
   * @param startb    start b.
   * @param endb      end b.
   * @throws IllegalArgumentException if the ticks are negative, or otherwise incorrect.
   */
  public Movement(int starttick, int endtick, int startx, int endx, int starty, int endy,
      int startw, int endw, int starth, int endh, int startr, int endr, int startg, int endg,
      int startb, int endb) throws IllegalArgumentException {

    if (starttick < 0 || endtick < 0) {
      throw new IllegalArgumentException("Ticks cannot be negative.");
    }

    this.tickList = new ArrayList<>();
    this.positionDoubleList = new ArrayList<>();
    this.dimensionList = new ArrayList<>();
    this.colorList = new ArrayList<>();

    if (starttick > endtick) {
      throw new IllegalArgumentException("The start of the motion cannot be later than the end");
    }

    this.tickList.add(starttick);
    this.tickList.add(endtick);

    this.startPosition = new PositionDouble(startx, starty);
    this.endPosition = new PositionDouble(endx, endy);
    this.positionDoubleList.add(startPosition);
    this.positionDoubleList.add(endPosition);

    this.startDimension = new Dimension(startw, starth);
    this.endDimension = new Dimension(endw, endh);
    this.dimensionList.add(startDimension);
    this.dimensionList.add(endDimension);

    this.startColor = new Color(startr, startg, startb);
    this.endColor = new Color(endr, endg, endb);
    this.colorList.add(startColor);
    this.colorList.add(endColor);

    listCorrectness(tickList);
    listCorrectness(positionDoubleList);
    listCorrectness(dimensionList);
    listCorrectness(colorList);

  }


  private void listCorrectness(List<?> givenlist) throws IllegalArgumentException {
    if (givenlist.size() != 2) {
      throw new IllegalArgumentException("Given list inputs violate invariance.");
    }
  }

  protected int getLastTick() {
    return this.tickList.get(1);
  }

  public int getFirstTick() {
    return this.tickList.get(0);
  }

  public int getLastTickk() {
    return this.tickList.get(1);
  }

  public int getFirstXPos() {
    return this.positionDoubleList.get(0).getXValueCoordinate();
  }

  public int getLastXPos() {
    return this.positionDoubleList.get(1).getXValueCoordinate();
  }

  public int getFirstYPos() {
    return this.positionDoubleList.get(0).getYValueCoordinate();
  }

  public int getLastYPos() {
    return this.positionDoubleList.get(1).getYValueCoordinate();
  }

  public int getFirstWPos() {
    return this.dimensionList.get(0).getXValueCoordinate();
  }

  public int getLastWPos() {
    return this.positionDoubleList.get(1).getXValueCoordinate();
  }

  public int getFirstHPos() {
    return this.positionDoubleList.get(0).getYValueCoordinate();
  }

  public int getLastHPos() {
    return this.positionDoubleList.get(1).getYValueCoordinate();
  }

  public int getFirstRPos() {
    return this.colorList.get(0).getRedColor();
  }

  public int getLastRPos() {
    return this.colorList.get(1).getRedColor();
  }

  public int getFirstGPos() {
    return this.colorList.get(0).getGreenColor();
  }

  public int getLastGPos() {
    return this.colorList.get(1).getGreenColor();
  }

  public int getFirstBPos() {
    return this.colorList.get(0).getBlueColor();
  }

  public int getLastBPos() {
    return this.colorList.get(1).getBlueColor();
  }


  @Override
  public String toString() {
    return
        this.tickList.get(0).toString() + " "
            + this.positionDoubleList.get(0).toString() + " "
            + this.dimensionList.get(0).toString() + " "
            + this.colorList.get(0).toString() + " "
            + "   "
            + this.tickList.get(1).toString() + " "
            + this.positionDoubleList.get(1).toString() + " "
            + this.dimensionList.get(1).toString() + " "
            + this.colorList.get(1).toString();
  }

}
