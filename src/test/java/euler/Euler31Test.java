package euler;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Euler31Test {

  private Euler31 euler;

  @Before
  public void init(){
    euler = new Euler31();
  }

  @Test
  public void test1Pence() throws Exception {
    assertThat( 1 , is( euler.numberOfSolutions( 1 )));
  }

  @Test
  public void test2Pence() throws Exception {
    assertThat( 2 , is( euler.numberOfSolutions( 2 )));
  }

}
