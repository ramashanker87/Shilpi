package com.rama.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathOperation {
  public static void main(String[] args) {
    MathOperation mathOperation = new MathOperation();
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    float result = mathOperation.handleException(5, 2, list);
    System.out.println(result);

    System.out.println("Final Execution");
  }

  public float handleException(int firstNumber, int secondNumber, List<Integer> list) {
    float result = 0;
    try {
      result = firstNumber / secondNumber;
      int data = list.get(5);
    } catch (ArithmeticException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
    return result;
  }

}
