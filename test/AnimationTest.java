import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cs3500.model.hw05.Animation;
import cs3500.model.hw05.Circle;
import cs3500.model.hw05.IAnimation;
import cs3500.model.hw05.IShape;
import cs3500.model.hw05.Movement;
import cs3500.model.hw05.Rectangle;
import cs3500.view.IView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the testing class for the animation.
 */
public class AnimationTest {

  IAnimation animation;
  IAnimation animation2;
  IView view;
  Movement move1;
  Movement move2;
  Movement move3;
  List<Movement> movementList;
  List<Movement> movementList2;
  IShape shape1;
  IShape shape2;


  @Before
  public void init() {
    move1 = new Movement(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
    move2 = new Movement(2, 3, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
    move3 = new Movement(3, 4, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);

    movementList = new ArrayList<>();
    movementList.add(move1);
    shape1 = new Rectangle("rect", movementList);
    shape2 = new Circle("circ", movementList2);
    animation = new Animation("rect", shape1);
    animation2 = new Animation("rect", shape1);
    animation2.updateShape("circ", shape2);

  }

  @Test
  public void starterTestBlank() {
    animation = new Animation();
    assertEquals("", view.toString());
  }

  @Test
  public void testCreate() {
    assertEquals("shape rect rectangle\n"
        + "1 1.0 1.0 1.0 1.0 1 1 1    2 2.0 2.0 2.0 2.0 2 2 2", animation.toString());
  }

  @Test
  public void testReadShape() {
    assertEquals("shape rect rectangle\n"
            + "1 1.0 1.0 1.0 1.0 1 1 1    2 2.0 2.0 2.0 2.0 2 2 2",
        animation.readShape("rect").toString());
  }

  @Test
  public void testCreateAdd() {
    assertEquals("shape ellipse circ\n"
            + "1, 1.0 1.0 1.0 1.0 1 1 1   2 2.0 2.0 2.0 2.0 2 2 2",
        animation.readAnimation().toString());
  }

  @Test
  public void failedUpdate() {
    try {
      animation2.updateShape("circ", shape2);
      fail();
    } catch (Exception e) {
      assertEquals("", e.getMessage());
    }
  }

  @Test
  public void movementGap() {
    boolean thrown = false;
    try {
      animation.updateMovement("rect", move3);
    } catch (Exception e) {
      thrown = true;
    }
    Assert.assertTrue(thrown);
  }


}
