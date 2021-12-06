package pl.javastudia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyFrame extends JFrame implements MouseListener {
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 600;
    private JLabel label1;
    private JLabel label2;
    private JButton buttonY;
    private JButton buttonN;
    private Random random;

    MyFrame() {
        label1 = new JLabel();
        label1.setBounds(100,100,600,100);
        label1.setText("Are you a student?");
        label1.setFont(new Font("MV Boil", Font.PLAIN, 69));
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);

        label2 = new JLabel();
        label2.setBounds(0,0,800,500);
        label2.setText("I knew it!");
        label2.setFont(new Font("MV Boil", Font.PLAIN, 150));
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);

        buttonY = new JButton("Yes");
        buttonY.setFocusable(false);
        buttonY.addActionListener(e -> answerYes());
        buttonY.setBounds(200,400,100,50);

        buttonN = new JButton("No");
        buttonN.setFocusable(false);
        buttonN.addMouseListener(this);
        buttonN.addActionListener(e -> resetFrame());
        buttonN.setBounds(500,400,100,50);

        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Simple Test!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(label1);
        this.add(buttonY);
        this.add(buttonN);

        this.setVisible(true);
    }

    private void answerYes() {
        this.getContentPane().removeAll();
        this.repaint();
        this.add(label2);
    }

    private void changeLocation() {
        random = new Random();
        buttonN.setBounds(random.nextInt(251)+400, random.nextInt(201)+300, 100,50);
    }

    private void resetFrame() {
        buttonN.setBounds(500,400,100,50);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
          final boolean isCursorInRightBound = e.getX() > 3;

          if (isCursorInRightBound)
           changeLocation();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
