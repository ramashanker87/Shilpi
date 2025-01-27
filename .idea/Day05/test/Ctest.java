package com.shilpi.app;

import org.junit.Test;

public class Ctest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();
    double result=calculator.add(2,6);
    assert result==8;
  }
  @Test
  public void testSubtract() {
    Calculator calculator = new Calculator();
    double result = calculator.subtract(7,5);
    assert result==2;
  }
  @Test
  public void testMultiply() {
    Calculator calculator = new Calculator();
    double result= calculator.multiply(7,9);
    assert result==63;
  }

}
