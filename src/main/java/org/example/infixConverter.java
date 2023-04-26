package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static org.example.InfixToPrefix.infixToPreFix;
import static org.example.InfixToPostfix.infixToPostFix;

public class infixConverter extends JFrame {
    private JPanel panel1;
    private JTextField Input;
    private JTextField textField1;
    private JButton ConvertToPrefix;
    private JButton EXITButton;
    private JButton convertToPostfixButton;
    private JButton HOMEButton;
    private JButton CLEARButton;

    public infixConverter(){
        add(panel1);
        setSize(600,500);
        setTitle("CONVERTER");
        ConvertToPrefix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = Input.getText();
                StringBuilder temp = new StringBuilder(infixToPreFix(input)) ;
                if(temp.toString().equals("true")){
                    JFrame frame = new JFrame("ERROR");
                    if(JOptionPane.showConfirmDialog(frame,"Wrong Input, please use only infix equations example: A + B + C","ERROR",JOptionPane.CANCEL_OPTION)==JOptionPane.CANCEL_OPTION) {
                        panel1.setVisible(true);
                    }
                }
                else {
                    temp.toString();
                    textField1.setText(String.valueOf(temp));
                }
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to EXIT","EXIT",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
                    System.exit(0);
                }
            }
        });
        convertToPostfixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = Input.getText();
                StringBuilder temp = new StringBuilder(infixToPostFix(input));
                if (temp.toString().equals("true")){
                    JFrame frame = new JFrame("ERROR");
                    if(JOptionPane.showConfirmDialog(frame,"Wrong Input, please use only infix equations example: A + B + C","ERROR",JOptionPane.CANCEL_OPTION)==JOptionPane.CANCEL_OPTION){
                        panel1.setVisible(true);
                    }
                }
                else {
                    temp.toString();
                    textField1.setText(String.valueOf(temp));
                }
            }
        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(null);
                Input.setText(null);
            }
        });
        HOMEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home f = new Home();
                f.setVisible(true);
                panel1.setVisible(false);
                dispose();
            }
        });
    }
}
