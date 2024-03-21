package main.java.leetcode.medium;

import main.java.leetcode.Commons;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public final List<Integer> powerOf10;
    public final List<Integer> allowedPositiveNumDigits;

    public ReverseInteger() {
        this.powerOf10 = List.of(1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000);
        this.allowedPositiveNumDigits = List.of(2, 1, 4, 7, 4, 8, 3, 6, 4, 7);
    }

    public static void main(String[] args) {
        final ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-2147483412));
    }

    public int reverse(int x) {
        if (x == Commons.INT_MIN || x == Commons.INT_MAX) return 0;

        int input = Math.abs(x);
        List<Integer> digitsReversed = new ArrayList<>();
        while (input > 0) {
            digitsReversed.add(input % 10);
            input = input / 10;
        }

        // verify of digits are in permissible limits
        if (digitsReversed.size() == 10) {
            for (int i = 0; i < 10; i++) {
                if (digitsReversed.get(i) < allowedPositiveNumDigits.get(i)) break;
                if (digitsReversed.get(i) > allowedPositiveNumDigits.get(i)) return 0;
            }
        }

        int result = 0;
        for (int i = digitsReversed.size() - 1, j = 0; i >= 0; i--, j++) {
            result = result + digitsReversed.get(j) * powerOf10.get(i);
        }
        return (x < 0) ? -result : result;
    }
}
