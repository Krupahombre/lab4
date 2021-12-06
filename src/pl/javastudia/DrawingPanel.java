package pl.javastudia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
    protected final DrawingShapeCanvas drawingCanvas;
    private int shapeChosen;

    DrawingPanel() {
        this.setBounds(40,10,700,400);
        this.drawingCanvas = new DrawingShapeCanvas();
        this.drawingCanvas.setPreferredSize(new Dimension(700,400));
        //this.drawingCanvas.setMinimumSize(new Dimension(700,400));
        this.drawingCanvas.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        this.setFocusable(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        drawingCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println(e.getPoint());
                    if(shapeChosen == 1) {
                        drawingCanvas.addSquare(e.getPoint(), Color.RED);
                    }
                    else if(shapeChosen == 2) {
                        drawingCanvas.addCircle(e.getPoint(), Color.GREEN);
                    }
                }
                repaint();
            }
        });

        this.add(drawingCanvas, BorderLayout.CENTER);
    }

    public void changeShape(int num) {
        if(num == 1) shapeChosen = 1;
        else if(num == 2) shapeChosen = 2;
    }
}
