package main.java.leetcode.medium;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

//https://leetcode.com/problems/custom-sort-string/
public class CustomSortString {

    public String customSortString(String order, String s) {
        final HashMap<Character, Integer> inputHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final Integer count = Optional.ofNullable(inputHashMap.get(s.charAt(i))).orElse(0);
            inputHashMap.put(s.charAt(i), count + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int oi = 0; oi < order.length(); oi++) {
            final char key = order.charAt(oi);
            final Integer count = inputHashMap.get(key);
            if (Objects.nonNull(count)) {
                for (int j = 0; j < count; j++)
                    sb.append(key);
                inputHashMap.put(key, 0);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (inputHashMap.get(s.charAt(i)) > 0)
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
