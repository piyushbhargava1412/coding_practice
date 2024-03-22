package main.java.leetcode.medium;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {

  public int divide(int dividend, int divisor) {
    long result = 0;
    long twoPower31Minus1 = 2147483647;
    long negTwoPower31 = -2147483648;
    long numerator = Math.abs((long) dividend);
    long denominator = Math.abs((long) divisor);
    final boolean sameSign =
      dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0;
    if (divisor == 1) {
      return dividend;
    } else if (divisor == -1) {
      if (dividend > 0) return -dividend;
      if (dividend == negTwoPower31) return (int) twoPower31Minus1;
      return -dividend;
    } else if (numerator == denominator) {
      return sameSign ? 1 : -1;
    } else {
      while (numerator >= denominator) {
        numerator = numerator - denominator;
        result++;
      }
    }
    if (sameSign) return (int) (
      result > twoPower31Minus1 ? twoPower31Minus1 : result
    ); else {
      result = -result;
      return (int) (result < negTwoPower31 ? negTwoPower31 : result);
    }
  }
}
