package main.java.leetcode.medium;

// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/description/

public class MinSwapsForAlternatingBinString {
    public static void main(String[] args) {
        String s = "00011110110110000000000110110101011101111011111101010010010000000000000001101101010010001011110000001101111111110000110101101101001011000011111011101101100110011111110001100110001110000000001100010111110100111001001111100001000110101111010011001";
        System.out.println(minSwaps(s));
    }

    private static int minSwaps(String s) {
        // Count no. of 0s and 1s.
        int numZero = 0;
        int numOnes = 0;
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i) == '0') numZero++;
            else numOnes++;
        }

        // If difference is greater than 1, return -1
        if(Math.abs(numOnes - numZero) > 1) return -1;

        // if num ones is more, they should be placed at even positions
        if(numOnes > numZero)
            return countMisplaced('1', s);
        else if(numZero > numOnes)
            return countMisplaced('0', s);

        // if equal 0s and 1s, return the minimum of two
        return Math.min(countMisplaced('1', s), countMisplaced('0', s));
    }

    private static int countMisplaced(char symbol, String s) {
        int misplacedCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i % 2 != 0 && s.charAt(i) == symbol) misplacedCount++;
        }
        return misplacedCount;
    }
}
