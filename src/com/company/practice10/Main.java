package com.company.practice10;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyApp app = new MyApp();
            app.setVisible(true);
        });
    }
}
