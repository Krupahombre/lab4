package pl.javastudia;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try{
                new MyFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
