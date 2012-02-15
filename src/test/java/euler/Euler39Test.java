package euler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler39Test {

  @Test
  public void testFindNumberSolutions() throws Exception {
    Euler39 euler = new Euler39();
    assertEquals(3, euler.findNumberSolutions(120));
  }


}
