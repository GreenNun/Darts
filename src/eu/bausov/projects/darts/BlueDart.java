package eu.bausov.projects.darts;

import javax.swing.*;
import java.awt.*;

class BlueDart extends JPanel {
    private Coordinate coordinate;
    private int radius;

    BlueDart(Coordinate coordinate, int radius) {
        this.coordinate = coordinate;
        this.radius = radius;

        setOpaque(false); // Set to true to see it
        setBackground(Color.PINK);
        setVisible(true); // my add
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillOval(coordinate.getX() - radius / 2, coordinate.getY() - radius / 2, radius, radius);
    }
}
