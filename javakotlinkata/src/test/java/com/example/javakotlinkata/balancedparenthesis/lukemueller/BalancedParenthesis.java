package com.example.javakotlinkata.balancedparenthesis.lukemueller;

import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {

    private static final Map<Character, Character> characterMap = Map.of(
        ')', '(',
        ']', '[',
        '}', '{'
    );

    public static boolean isBalanced(String input) {
        if (input.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            boolean isClosing = characterMap.containsKey(currentCharacter);

            if (!isClosing) {
                stack.push(currentCharacter);
                continue;
            }

            if (characterMap.get(currentCharacter) != stack.peek()) {
                return false;
            }

            stack.pop();
        }

        return stack.empty();
    }
}
