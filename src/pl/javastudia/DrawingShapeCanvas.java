package pl.javastudia;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DrawingShapeCanvas extends JComponent {

    private int sideLength = 50;
    private ArrayList<Shape> shapes;
    private ArrayList<Color> shapesColor;

    public DrawingShapeCanvas() {
        shapes = new ArrayList<>();
        shapesColor = new ArrayList<>();
    }

    public void setSideLength(int SIDELENGTH) {
        this.sideLength = SIDELENGTH;
    }

    public void addSquare(Point2D p, Color color) {
        shapes.add(new Rectangle2D.Double(p.getX() - sideLength /2, p.getY() - sideLength /2, sideLength, sideLength));
        shapesColor.add(color);
    }

    public void addCircle(Point2D p, Color color) {
        shapes.add(new Ellipse2D.Double(p.getX() - sideLength /2, p.getY() - sideLength /2, sideLength, sideLength));
        shapesColor.add(color);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i = 0; i < shapes.size(); i++) {
            g2.setColor(shapesColor.get(i));
            g2.fill(shapes.get(i));
        }
    }

    public void removeShape() {
        shapes.clear();
        shapesColor.clear();
        repaint();
    }
}
