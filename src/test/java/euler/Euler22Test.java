package euler;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Euler22Test {
  private Euler22 euler22 = new Euler22();


   @Test
  public void scoreNameBA() {
     int score = euler22.scoreName("BA");
     System.out.println("score=" + score );
     assertEquals( 3, score );
  }
}
