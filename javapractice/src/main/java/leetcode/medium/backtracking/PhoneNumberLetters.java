package main.java.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetters {
    public static Map<Character, String> letters;

    public static void main(String[] args) {
        final List<String> combinations = letterCombinations("234");
        System.out.println(combinations.size());
        System.out.println(combinations);
    }

    public static List<String> letterCombinations(String digits) {
        final List<String> results = new ArrayList<>();
        if(digits.length() == 0) return results;

        letters = new HashMap<>();
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
        generate(results, digits, 0, "");
        return results;
    }

    static void generate(List <String> results, String digits, int index, String draft) {
        if(index == digits.length()) {
            results.add(draft);
            return;
        }

        char digit = digits.charAt(index);
        String digitLetters = letters.get(digit);
        for(int i = 0; i < digitLetters.length();i++) {
            generate(results, digits, index + 1, draft + digitLetters.charAt(i));
        }
    }
}
