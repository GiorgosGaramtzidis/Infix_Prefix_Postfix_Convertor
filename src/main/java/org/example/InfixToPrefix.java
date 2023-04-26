package org.example;
import java.util.EmptyStackException;
import java.util.Stack;

import static org.example.Precedence.precedence;

public class InfixToPrefix {
    static StringBuilder infixToPreFix(String expression) {

        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(expression);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char[] charsExp = new String(input).toCharArray();
        try {
            for (int i = 0; i < charsExp.length; i++) {
                //reversing parenthesis
                if (charsExp[i] == '(') {
                    charsExp[i] = ')';
                    i++;
                } else if (charsExp[i] == ')') {
                    charsExp[i] = '(';
                    i++;
                }
            }
            for (int i = 0; i < charsExp.length; i++) {
                char c = charsExp[i];
                //check if char is operator or operand
                if (precedence(c) > 0) {
                    while (stack.isEmpty() == false && precedence(stack.peek()) >= precedence(c)) {
                        result.append(stack.pop());
                    }
                    stack.push(c);
                } else if (c == ')') {
                    char x = stack.pop();
                    while (x != '(') {
                        result.append(x);
                        x = stack.pop();
                    }
                } else if (c == '(') {
                    stack.push(c);
                } else {
                    result.append(c);
                }
            }
        }catch (EmptyStackException e){
            return new StringBuilder("true");
        }

        for (int i = 0; i <= stack.size(); i++) {
            if(stack.isEmpty()){
                return new StringBuilder("true");
            }
            result.append(stack.pop());
        }
        return result.reverse();
    }
}
