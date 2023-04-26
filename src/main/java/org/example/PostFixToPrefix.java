package org.example;

import java.util.EmptyStackException;
import java.util.Stack;

public class PostFixToPrefix {
    static String postToPre(String post_exp)
    {
        Stack<String> s = new Stack<String>();
        int length = post_exp.length();
        try {
            for (int i = 0; i < length; i++) {
                if (isOperator.isOperator(post_exp.charAt(i))) {
                    String op1 = s.peek();
                    s.pop();
                    String op2 = s.peek();
                    s.pop();
                    String temp
                            = post_exp.charAt(i) + op2 + op1;
                    s.push(temp);
                } else {
                    s.push(post_exp.charAt(i) + "");
                }
            }
        } catch (EmptyStackException e) {
            return "true";
        }
        if(s.isEmpty()){
            return "true";
        }
        else {
            String ans = "";
            for (String i : s)
                ans += i;
            return ans;
        }
    }
}
