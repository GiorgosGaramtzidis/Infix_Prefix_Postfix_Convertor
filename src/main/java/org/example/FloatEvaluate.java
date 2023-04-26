package org.example;

public class FloatEvaluate {
    public static Float evaluate(String operator,Float operand1, Float operand2){
        switch (operator){
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
            {
                if (operand1==0){
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                }
                return operand1 / operand2;
            }
        }
        return Float.valueOf(0);
    }
}
