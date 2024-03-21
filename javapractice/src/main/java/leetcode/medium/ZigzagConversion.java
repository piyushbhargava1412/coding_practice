package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion processor = new ZigzagConversion();
        System.out.println(processor.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (s.length() <= numRows) return s;
        final List<Integer> zigzagRowSequence = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            zigzagRowSequence.add(i);
        for (int i = numRows - 2; i >= 1; i--)
            zigzagRowSequence.add(i);
        final HashMap<Integer, List<Character>> image = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final Integer row = zigzagRowSequence.get(i % zigzagRowSequence.size());
            List<Character> characters = image.get(row);
            if (characters == null)
                characters = new ArrayList<>();
            characters.add(s.charAt(i));
            image.put(row, characters);
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            final List<Character> characters = image.get(i);
            characters.forEach(stringBuilder::append);
        }
        return stringBuilder.toString();
    }
}
