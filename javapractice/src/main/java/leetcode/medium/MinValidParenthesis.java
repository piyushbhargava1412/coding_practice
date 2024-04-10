package main.java.leetcode.medium;

import java.util.Stack;

public class MinValidParenthesis {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {

        // maintain a stack to track indexes of open brackets
        // whenever we find a closing bracket, pop from stack
        // if stack is empty, delete the closing bracket from the string
        final Stack<Integer> openIndexes = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i) != '(' && s.charAt(i) != ')') sb.append(s.charAt(i));
            else if(s.charAt(i) == ')') {
                if(!openIndexes.isEmpty()) {
                    final Integer pop = openIndexes.pop();
                    sb.append(s.charAt(i));
                    sb.setCharAt(pop, '(');
                } else sb.append('-');
            } else {
              openIndexes.push(i);
              sb.append('-');
            }
        }

        final StringBuilder result = new StringBuilder();
        for(int i = 0;i < s.length();i++) {
            final char c = sb.charAt(i);
            if(c != '-') result.append(c);
        }
        return result.toString();
    }
}
