package pl.javastudia;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DrawingShapeCanvas extends JComponent {

    private static final int SIDELENGTH = 50;
    protected ArrayList<Shape> squares;
    protected ArrayList<Color> squaresColor;

    public DrawingShapeCanvas() {
        squares = new ArrayList<>();
        squaresColor = new ArrayList<>();
    }

    public void addSquare(Point2D p, Color color) {
        double x = p.getX();
        double y = p.getY();

        squares.add(new Rectangle2D.Double(x - SIDELENGTH/2, y - SIDELENGTH/2, SIDELENGTH, SIDELENGTH));
        squaresColor.add(color);
    }

    public void addCircle(Point2D p, Color color) {
        double x = p.getX();
        double y = p.getY();

        squares.add(new Ellipse2D.Double(x - SIDELENGTH/2, y - SIDELENGTH/2, SIDELENGTH, SIDELENGTH));
        squaresColor.add(color);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i=0; i < squares.size(); i++) {
            g2.setColor(squaresColor.get(i));
            g2.fill(squares.get(i));
        }
    }

    public void removeShape() {
        squares.clear();
        squaresColor.clear();
        repaint();
    }
}
