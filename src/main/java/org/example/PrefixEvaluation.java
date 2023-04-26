package org.example;

import java.util.Stack;

import static org.example.FloatEvaluate.evaluate;
import static org.example.isNumeric.isNumeric;

public class PrefixEvaluation {
    public static Float convertPrefixEv(String expression) {
        Stack<Float> stack = new Stack<Float>();
        String[] tokens = expression.split("\\s+");
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isNumeric(token)) {
                stack.push(Float.parseFloat(token));
            } else {
                float operand1 = stack.pop();
                float operand2 = stack.pop();
                float result = evaluate(token, operand1, operand2);
                stack.push(result);
            }
        }
        Float result = stack.pop();
        return result;
    }
}
