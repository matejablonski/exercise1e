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

public class CalculatorUtilDivisionTest {
  private Calculator calculator;
  private CalculatorUtil calcUtil;

  @Before
  public void init() {
    calculator = Mockito.mock(Calculator.class);
    calcUtil = new CalculatorUtil(calculator);
  }

  @Test
  public void test16dividedBy4() {
    doReturn(4.0).when(calculator).divide(anyInt(), anyInt());

    // when
    String result = calcUtil.getDivisionText(16, 4);

    // then
    assertEquals("16 / 4 = 4.0", result);
    verify(calculator).divide(anyInt(), anyInt()); // check if our calculator mock was really
                                                   // invoked.
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDivisionByZero() {
    // given
    doThrow(new IllegalArgumentException()).when(calculator).divide(anyInt(), eq(0));

    // when
    calcUtil.getDivisionText(3, 0);

    // then
    // empty - exception expected
  }
}
