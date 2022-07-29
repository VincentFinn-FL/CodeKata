package com.example.javakotlinkata.balancedparenthesis.luke;

import java.util.Stack;

public class BalancedParenthesis {

    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (i == 0) {
                stack.push(currentCharacter);
                continue;
            }

            if (currentCharacter == '(' || currentCharacter == '{' || currentCharacter == '[') {
                stack.push(currentCharacter);
                continue;
            }

            if (currentCharacter == ')' && stack.peek() != '(') {
                return false;
            }

            if (currentCharacter == '}' && stack.peek() != '{') {
                return false;
            }

            if (currentCharacter == ']' && stack.peek() != '[') {
                return false;
            }

            stack.pop();
        }

        return stack.empty();
    }

}
