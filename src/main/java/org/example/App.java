package org.example;

import static org.example.InfixToPrefix.infixToPreFix;
import static org.example.InfixToPostfix.infixToPostFix;
import static org.example.PostfixEvaluation.convertPostfixEv;
import static org.example.PrefixEvaluation.convertPrefixEv;
import static org.example.PrefixToInfix.convert;
import static org.example.PrefixToPostfix.preToPost;

public class App
{
    public static void main( String[] args )
    {
        Home f = new Home();
        f.setVisible(true);


        String exp = "A+B*(C^D-E)";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + infixToPreFix(exp));
        String exp3 = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix Expression: " + exp3);
        System.out.println("Postfix Expression: "  + infixToPostFix(exp3));
        String exp1 = "ABC/-AK/L-*";
        System.out.println("Postfix Expression: " + exp1);
        System.out.println("Infix Expression: " + new PostFixToInfix().convert(exp1));
        String exp2 = "ABC/-AK/L-*";
        System.out.println("Postfix Expression: " + exp2);
        System.out.println("Prefix Expression: " + new PostFixToPrefix().postToPre(exp2));
        String exp4 = "*-A/BC-/AKL";
        System.out.println("Infix : " + convert(exp4));
        String exp5 = "*-A/BC-/AKL";
        System.out.println("Postfix : " + preToPost(exp5));
        String exp6 = "10.2 10.2 +";
        System.out.println("Postfix Expression: " + exp6);
        System.out.println("Evaluation: " + convertPostfixEv(exp6));
        String exp7 = "+ 10.2 10.2";
        System.out.println("Prefix Expression: " + exp7);
        System.out.println("Evaluation: " + convertPrefixEv(exp7));
    }
}
