package euler;

import org.junit.Test;
import scala.collection.immutable.Range;
import scala.math.BigInt;

import java.util.List;

import static org.junit.Assert.*;

public class Euler21Test {
  private Euler21 euler21 = new Euler21();


   @Test
  public void d1() {
    List devisorer = MathLib.properDevisors(1);
    assertTrue( devisorer.size() == 1 );
    assertTrue( devisorer.contains( 1 ) );
  }
  @Test
  public void d2() {
    List devisorer = MathLib.properDevisors(2);
    assertTrue( devisorer.size() == 2 );
    assertTrue( devisorer.contains( 1 ) );
    assertTrue( devisorer.contains( 2 ) );
  }

  @Test
  public void d6() {
    List devisorer = MathLib.properDevisors(20);

    assertTrue( devisorer.contains(1));
    assertTrue( devisorer.contains(2));
    assertTrue( devisorer.contains(5));
    assertTrue( devisorer.contains(10));
  }

}
