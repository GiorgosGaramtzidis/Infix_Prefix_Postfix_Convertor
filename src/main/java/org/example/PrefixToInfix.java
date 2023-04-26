package org.example;

import java.util.EmptyStackException;
import java.util.Stack;

public class PrefixToInfix {

    public static String convert(String str)
    {
        Stack<String> stack = new Stack<>();
        int l = str.length();
        try {
            for (int i = l - 1; i >= 0; i--) {
                char c = str.charAt(i);
                if (isOperator.isOperator(c)) {
                    String op1 = stack.pop();
                    String op2 = stack.pop();
                    String temp = "(" + op1 + c + op2 + ")";
                    stack.push(temp);
                } else {
                    stack.push(c + "");
                }
            }
        } catch (EmptyStackException e) {
            return "true";
        }
        if(stack.isEmpty()){
            return "true";
        }
        else {
            return stack.pop();
        }
    }
}
