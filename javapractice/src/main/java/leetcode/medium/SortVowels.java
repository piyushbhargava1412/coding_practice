package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/sort-vowels-in-a-string/
public class SortVowels {
    public static void main(String[] args) {
        final SortVowels processor = new SortVowels();
        System.out.println(processor.sortVowels("lEetcOde"));
    }

    public String sortVowels(String s) {
        final List<Character> vowels = new ArrayList<>();
        final List<Integer> vowelIndex = new ArrayList<>();
        final StringBuilder stringBuilder = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                    c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels.add(c);
                vowelIndex.add(i);
            }
        }

        if (vowels.size() == 0) return s;

        final List<Character> sortedVowels = vowels.stream().sorted().toList();

        for (int i = 0; i < vowelIndex.size(); i++) {
            stringBuilder.setCharAt(vowelIndex.get(i), sortedVowels.get(i));
        }

        return stringBuilder.toString();
    }
}
