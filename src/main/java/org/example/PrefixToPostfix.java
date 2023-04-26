package org.example;

import java.util.EmptyStackException;
import java.util.Stack;

public class PrefixToPostfix {

    static String preToPost(String pre_exp)
    {

        Stack<String> s = new Stack<String>();
        int length = pre_exp.length();
        try{
            for (int i = length - 1; i >= 0; i--) {
                if (isOperator.isOperator(pre_exp.charAt(i))) {
                    String op1 = s.peek();
                    s.pop();
                    String op2 = s.peek();
                    s.pop();
                    String temp = op1 + op2 + pre_exp.charAt(i);
                    s.push(temp);
                } else {
                    s.push(pre_exp.charAt(i) + "");
                }
            }
        } catch (EmptyStackException e) {
            return "true";
        }
        if(s.isEmpty()){
            return "true";
        }
        else
        return s.peek();
    }
}
