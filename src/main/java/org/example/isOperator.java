package org.example;

public class isOperator {
    static boolean isOperator(char x)
    {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }
}
