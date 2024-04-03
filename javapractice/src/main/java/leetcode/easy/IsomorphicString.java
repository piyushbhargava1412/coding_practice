package main.java.leetcode.easy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/description/?envType=daily-question&envId=2024-04-02
public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        final HashMap<Character, Character> st_mapping = new HashMap<>();
        final HashMap<Character, Boolean> mapped = new HashMap<>();
        for(int i = 0;i < s.length();i++) {
            if(st_mapping.get(s.charAt(i)) == null) {
                if(mapped.get(t.charAt(i)) != null) return false;
                st_mapping.put(s.charAt(i), t.charAt(i));
                mapped.put(t.charAt(i), true);
            }
            else {
                if(st_mapping.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
    }
}
