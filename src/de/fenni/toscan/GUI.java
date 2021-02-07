package de.fenni.toscan;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener{

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    private JLabel label = new JLabel();
    private JLabel label2 = new JLabel();
    private JLabel label3 = new JLabel();

    private JTextField textField = new JTextField(20);

    private JButton button = new JButton("Enter");

    public GUI(){
        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,2  ));
        panel.add(textField);
        panel.add(button);

        panel.add(label);
        panel.add(label2);
        panel.add(label3);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setTitle("PC Building Simulator Overclocking Calculator");

        frame.pack();
        frame.setVisible(true);
    }

    public void Calculation(String reachableTarget){

        ArrayList<Double> values = new ArrayList<Double>();
        label.setText("");
        label2.setText("");

        boolean found = false;

        for (double i =33.00; i <= 42.00; i++) {
            values.add(i);
        }

        int targetMHz = Integer.parseInt(reachableTarget);

        for (int i = 130; i > 80; i--) {

            double end = (double) targetMHz / i ;

            for (Double value :
                    values) {

                if (end*i == targetMHz && value == end){
                    label2.setText("Value:" + end);
                    label.setText("Basis mHz:" + i);
                    label3.setText("Match found");
                    found= true;
                    break;
                }

            }

            if (found){
                break;
            }
        }

        if (!found){
            label3.setText("No match found");
        }






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = textField.getText();
        Calculation(input);
    }
}
