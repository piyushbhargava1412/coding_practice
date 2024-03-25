package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParanthesis {

    public static void main(String[] args) {
        final GenerateParanthesis processor = new GenerateParanthesis();
        System.out.println(processor.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        final List<String> strings = new ArrayList<>();
        recursiveGenerate("(",n,1, 0, strings);
        return strings;
    }

    void recursiveGenerate(String draft, int n, int openCount, int closeCount, List<String> results) {
        if(draft.length() == 2 * n) {
            results.add(draft);
            return;
        }

        if(openCount < n) recursiveGenerate(draft + "(", n, openCount + 1, closeCount, results);
        if(closeCount < openCount) recursiveGenerate(draft + ")", n, openCount, closeCount + 1, results);
    }
}
