package euler;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNummeralsTest {

  @Test
  public void testRom2Des() throws Exception {
    int des = RomanNummerals.romertall2tall("CMLXIX");
    assertThat( des, is(969));
    des = RomanNummerals.romertall2tall("MMXXVIII");
    assertThat( des, is(2028));
  }

  @Test
  public void konvertering(){
    String romertall = RomanNummerals.convert( 2399 );
    assertThat( romertall, is ("MMCCCXCIX"));
    romertall = RomanNummerals.convert( 49 );
    assertThat( romertall, is ("XLIX"));
  }
}
