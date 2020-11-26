package com.company.practice10;

import javax.swing.*;
import java.awt.*;
import static javax.swing.GroupLayout.Alignment.*;

public class MyApp extends JFrame {

    private JTextField textFieldA = new JTextField(15);
    private JTextField textFieldB = new JTextField(15);
    private JLabel label = new JLabel("", SwingConstants.CENTER);
    private JButton buttonP = new JButton("+");
    private JButton buttonM = new JButton("-");
    private JButton buttonS = new JButton("*");
    private JButton buttonD = new JButton("/");
    double scale = Math.pow(10, 4);

    public MyApp() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(buttonP)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textFieldA)
                                .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonM)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonS)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(textFieldB)
                                .addComponent(label)))
                .addComponent(buttonD)
        );

        layout.linkSize(SwingConstants.HORIZONTAL, buttonP, buttonM, buttonS, buttonD);
        layout.linkSize(SwingConstants.VERTICAL, buttonP, buttonM, buttonS, buttonD);

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldA)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(buttonP)
                                .addComponent(buttonM)
                                .addComponent(buttonS)
                                .addComponent(buttonD)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textFieldB)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label)
        );

        textFieldA.setToolTipText("Первое число");
        textFieldA.setFont(new Font("Dialog", Font.PLAIN, 25));
        textFieldB.setToolTipText("Второе число");
        textFieldB.setFont(new Font("Dialog", Font.PLAIN, 25));
        buttonP.setPreferredSize(new Dimension(45, 45));
        label.setFont(new Font("Helvetica-Light", Font.PLAIN, 16));

        setTitle("Калькулятор");
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addListener();
    }

    private void addListener() {

        buttonP.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) + Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonM.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) - Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonS.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) * Float.parseFloat(textFieldB.getText())) * scale)/scale));
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });

        buttonD.addActionListener((ev) -> {
            if (checkField(textFieldA) && checkField(textFieldB))
                if (Float.parseFloat(textFieldB.getText()) != 0)
                    label.setText("Результат: " + String.valueOf(Math.round((Float.parseFloat(textFieldA.getText()) / Float.parseFloat(textFieldB.getText())) * scale)/scale));
                else label.setText("Результат: не определен(Ꝏ)");
            else
                JOptionPane.showMessageDialog(MyApp.this,
                        "Введите числа!");
        });
    }

    private boolean checkField(JTextField textField) {
        return !textField.getText().equals("") && textField.getText().matches("(-|\\+)?\\d+\\.?\\d*");
    }
}
