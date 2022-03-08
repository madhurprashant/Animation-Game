import static org.junit.Assert.assertEquals;

import cs3500.model.hw05.Animation;
import cs3500.model.hw05.IAnimation;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the tester class for the textual view.
 */
public class TextualViewTest {

  IAnimation animation;


  @Before
  public void init() {
    animation = new Animation();
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

}
