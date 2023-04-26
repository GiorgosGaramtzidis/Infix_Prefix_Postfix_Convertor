package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.PrefixToInfix.convert;
import static org.example.PrefixToPostfix.preToPost;

public class prefixConverter extends JFrame {
    private JPanel prefixPanel;
    private JButton homeButton;
    private JButton clearButton;
    private JButton exitButton;
    private JTextField Input;
    private JTextField Output;
    private JButton convertToInfixButton;
    private JButton convertToPostfixButton;
    private JButton evaluatePrefixButton;

    public prefixConverter() {
        add(prefixPanel);
        setSize(800,400);
        setTitle("CONVERTER");

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home f = new Home();
                f.setVisible(true);
                prefixPanel.setVisible(false);
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
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to EXIT","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                    System.exit(0);
                }
            }
        });
        convertToInfixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = Input.getText();
                String temp = convert(input);
                if(temp.equals("true")){
                    JFrame frame = new JFrame("ERROR");
                    if(JOptionPane.showConfirmDialog(frame,"Wrong Input, please use only prefix equations example: ++ABC","ERROR",JOptionPane.CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) {
                        prefixPanel.setVisible(true);
                    }
                }
                else {
                    Output.setText(temp);
                }
            }
        });
        convertToPostfixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = Input.getText();
                String temp = preToPost(input);
                if(temp.equals("true")){
                    JFrame frame = new JFrame("ERROR");
                    if(JOptionPane.showConfirmDialog(frame,"Wrong Input, please use only prefix equations example: ++ABC","ERROR",JOptionPane.CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) {
                        prefixPanel.setVisible(true);
                    }
                }
                else {
                    Output.setText(temp);
                }
            }
        });

        evaluatePrefixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = Input.getText();
                PrefixEvaluation f = new PrefixEvaluation();
                Float temp = (f.convertPrefixEv(input));
                Output.setText(String.valueOf(temp));
            }
        });
    }
}
