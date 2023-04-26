package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class postfixConverter extends JFrame{
    private JPanel postfixPanel;
    private JButton exitButton;
    private JButton homeButton;
    private JButton clearButton;
    private JTextField Input;
    private JTextField Output;
    private JButton convertToPrefixButton;
    private JButton convertToInfixButton;
    private JButton evaluatePostfixButton;

    public postfixConverter(){
        add(postfixPanel);
        setSize(800,400);
        setTitle("CONVERTER");

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to EXIT","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                    System.exit(0);
                }
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home f = new Home();
                f.setVisible(true);
                postfixPanel.setVisible(false);
                dispose();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Input.setText(null);
                Output.setText(null);
            }
        });
        convertToInfixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = Input.getText();
                PostFixToInfix f = new PostFixToInfix();
                String temp = (f.convert(input));
                if(temp.equals("true")){
                    JFrame frame = new JFrame("ERROR");
                    if(JOptionPane.showConfirmDialog(frame,"Wrong Input, please use only postfix equations example: AB+C+","ERROR",JOptionPane.CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) {
                        postfixPanel.setVisible(true);
                    }
                }
                else {
                    Output.setText(temp);
                }
            }
        });
        convertToPrefixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = Input.getText();
                PostFixToPrefix f = new PostFixToPrefix();
                String temp = f.postToPre(input);
                if(temp.equals("true")){
                    JFrame frame = new JFrame("ERROR");
                    if(JOptionPane.showConfirmDialog(frame,"Wrong Input, please use only postfix equations example: AB+C+","ERROR",JOptionPane.CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) {
                        postfixPanel.setVisible(true);
                    }
                }
                else
                {
                    Output.setText(temp);
                }
            }
        });
        evaluatePostfixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input =Input.getText();
                PostfixEvaluation f = new PostfixEvaluation();
                Float temp = (f.convertPostfixEv(input));
                Output.setText(String.valueOf(temp));
            }
        });
    }
}
