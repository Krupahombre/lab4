package pl.javastudia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MyFrame extends JFrame {
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton buttonY;
    private JButton buttonN;
    private JButton buttonR;
    private JButton buttonK;
    private JButton buttonO;
    private JSlider slider;
    private Random random;
    private DrawingPanel panel;

    MyFrame() {
        label1 = new JLabel();
        label1.setBounds(100,100,600,100);
        label1.setText("Do u want to draw?");
        label1.setFont(new Font("MV Boil", Font.PLAIN, 69));
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);

        label2 = new JLabel();
        label2.setBounds(50,420,250,20);
        label2.setText("Choose shape:");
        label2.setFont(new Font("MV Boil", Font.PLAIN, 18));
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.LEFT);

        label3 = new JLabel();
        label3.setBounds(35,520,250,40);
        label3.setText("You can also type: k - square, o - circle");
        label3.setFont(new Font("MV Boil", Font.PLAIN, 14));
        label3.setVerticalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.LEFT);

        label4 = new JLabel();
        label4.setBounds(350,420,250,20);
        label4.setText("Choose size:");
        label4.setFont(new Font("MV Boil", Font.PLAIN, 18));
        label4.setVerticalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.LEFT);

        panel = new DrawingPanel();

        buttonY = new JButton("Yes");
        buttonY.setFocusable(false);
        buttonY.addActionListener(e -> answerYes());
        buttonY.setBounds(200,400,100,50);

        buttonN = new JButton("No");
        buttonN.setFocusable(false);
        buttonN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                final boolean isCursorInRightBound = e.getX() > 3;

                if (isCursorInRightBound)
                changeLocationButtonN();
            }
        });
        buttonN.addActionListener(e -> resetButtonN());
        buttonN.setBounds(500,400,100,50);

        buttonR = new JButton("Reset");
        buttonR.setFocusable(false);
        buttonR.addActionListener(e -> panel.drawingCanvas.removeShape());
        buttonR.setBounds(620,460,100,50);

        buttonK = new JButton("Square");
        buttonK.setFocusable(false);
        buttonK.addActionListener(e -> {
            System.out.println("You chosen square");
            panel.changeShape(1);
        });
        buttonK.setBounds(50,460,100,50);

        buttonO = new JButton("Circle");
        buttonO.setFocusable(false);
        buttonO.addActionListener(e -> {
            System.out.println("You chosen circle");
            panel.changeShape(2);
        });
        buttonO.setBounds(160,460,100,50);

        slider = new JSlider(0,100,50);
        slider.setBounds(350,450,200,100);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> panel.changeSize(slider.getValue()));

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Lab4!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(label1);
        this.add(buttonY);
        this.add(buttonN);

        this.setVisible(true);
    }

    private void answerYes() {
        this.getContentPane().removeAll();
        this.add(panel);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(buttonR);
        this.add(buttonK);
        this.add(buttonO);
        this.add(slider);
        this.validate();
        this.repaint();
    }

    private void changeLocationButtonN() {
        random = new Random();
        buttonN.setBounds(random.nextInt(251)+400, random.nextInt(201)+300, 100,50);
    }

    private void resetButtonN() {
        buttonN.setBounds(500,400,100,50);
    }
}
