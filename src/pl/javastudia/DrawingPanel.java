package pl.javastudia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class DrawingPanel extends JPanel {
    protected final DrawingShapeCanvas drawingCanvas;
    private int shapeChosen;

    DrawingPanel() {
        this.setBounds(40,10,700,400);
        this.drawingCanvas = new DrawingShapeCanvas();
        this.drawingCanvas.setPreferredSize(new Dimension(700,400));
        this.drawingCanvas.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        //drawingCanvas.setFocusable(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        drawingCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Random randColor = new Random();
                drawingCanvas.requestFocusInWindow();
                if(e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("[x="+e.getX()+",y="+e.getY()+"]");
                    if(shapeChosen == 1) {
                        drawingCanvas.addSquare(e.getPoint(), new Color(randColor.nextInt(250),randColor.nextInt(250),randColor.nextInt(250)));
                    }
                    else if(shapeChosen == 2) {
                        drawingCanvas.addCircle(e.getPoint(), new Color(randColor.nextInt(250),randColor.nextInt(250),randColor.nextInt(250)));
                    }
                }
                repaint();
            }
        });
        drawingCanvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_O:
                        System.out.println("You chosen circle");
                        changeShape(2);
                        break;

                    case KeyEvent.VK_K:
                        System.out.println("You chosen square");
                        changeShape(1);
                        break;

                    default :
                        System.out.println("This key isn't assigned to do anything, try another one");
                        break;

                }
            }
        });
        this.add(drawingCanvas, BorderLayout.CENTER);

    }

    public void changeShape(int num) {
        if(num == 1) shapeChosen = 1;
        else if(num == 2) shapeChosen = 2;
    }

    public void changeSize(int size) {
        drawingCanvas.setSideLength(size);
    }
}
