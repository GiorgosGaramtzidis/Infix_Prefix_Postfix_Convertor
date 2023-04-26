package org.example;

import java.util.Stack;

import static org.example.FloatEvaluate.evaluate;
import static org.example.isNumeric.isNumeric;

public class PostfixEvaluation {
    public static Float convertPostfixEv(String expression) {
        Stack<Float> stack = new Stack<Float>();
        String[] tokens = expression.split("\\s+");
        for(String token : tokens) {
            if(isNumeric(token)) {
                stack.push(Float.parseFloat(token));
            } else {
                float operand2 = stack.pop();
                float operand1 = stack.pop();
                float result = evaluate(token, operand1, operand2);
                stack.push(result);
            }
        }
        Float result = stack.pop();
        return result;
    }
}
