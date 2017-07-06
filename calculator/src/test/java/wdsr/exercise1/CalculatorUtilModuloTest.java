package wdsr.exercise1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import wdsr.exercise1.logic.Calculator;

public class CalculatorUtilModuloTest {
  private Calculator calculator;
  private CalculatorUtil calcUtil;

  @Before
  public void init() {
    calculator = Mockito.mock(Calculator.class);
    calcUtil = new CalculatorUtil(calculator);
  }

  @Test
  public void test12moduloBy5() {
    doReturn(2).when(calculator).modulo(12, 5);

    // when
    String result = calcUtil.getModuloText(12, 5);

    // then
    assertEquals("12 % 5 = 2", result);
    verify(calculator).modulo(anyInt(), anyInt()); // check if our calculator mock was really
                                                   // invoked.
  }


  @Test(expected = IllegalArgumentException.class)
  public void testModuloByZero() {
    // given
    doThrow(new IllegalArgumentException()).when(calculator).modulo(anyInt(), eq(0));

    // when
    calcUtil.getModuloText(12, 0);

    // then
    // empty - exception expected
  }
}
