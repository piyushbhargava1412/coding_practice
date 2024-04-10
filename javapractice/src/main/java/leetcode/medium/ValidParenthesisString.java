package main.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/valid-parenthesis-string/?envType=daily-question&envId=2024-04-07
public class ValidParenthesisString {

    public static void main(String[] args) {
//        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
    public static boolean checkValidString(String s) {
        final Stack<Integer> brackets = new Stack<>();
        final Stack<Integer> stars = new Stack<>();

        for(int i = 0;i < s.length();i++) {
            if(s.charAt(i) == '*') stars.push(i);
            else if(s.charAt(i) == '(') brackets.push(i);
            else {
                if(!brackets.empty()) brackets.pop();
                else if(!stars.empty()) stars.pop();
                else return false;
            }
        }

        if(brackets.size() > stars.size()) return false;

        while(!brackets.empty() && !stars.empty()) {
            if(brackets.peek() < stars.peek()) {
                brackets.pop();
                stars.pop();
            } else {
                break;
            }
        }

        return brackets.empty();
    }
}
