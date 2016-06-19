package eu.bausov.projects.darts.targets;

import eu.bausov.projects.darts.Coordinate;

import java.awt.*;

public class RectangleTarget extends Target {
    public RectangleTarget() {
        setPreferredSize(new Dimension(300, 300));
    }

    // Override paintComponent to perform own painting
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // paint parent's background
        setBackground(Color.ORANGE);  // set background color for this JPanel

        // Drawing primitive shapes
        g.setColor(Color.YELLOW);    // set the drawing color;
        g.fillRect(35, 55, 230, 190);
        g.setColor(Color.RED);       // change the drawing color
        g.fillRect(65, 85, 170, 130);
        g.setColor(Color.YELLOW);    // set the drawing color;
        g.fillRect(95, 115, 110, 70);
        g.setColor(Color.RED);       // change the drawing color
        g.fillRect(120, 140, 60, 20);
        // Printing texts
        g.setColor(Color.BLACK);
        g.setFont(new Font("Dialog", Font.BOLD, 14));
        g.drawString("10 - 30 - 50 - 100", 10, 20);
    }

    @Override
    public String toString() {
        return "RectangleTarget{}";
    }

    @Override
    public int getScores(Coordinate coordinate) {
        double x = coordinate.getX() - 150;
        double y = coordinate.getY() - 150;

        if (x > -31 && x < 31 && y > -21 && y < 21) return 100;
        if (x > -55 && x < 55 && y > -35 && y < 35) return 50;
        if (x > -85 && x < 85 && y > -65 && y < 65) return 30;
        if (x > -115 && x < 115 && y > -95 && y < 95) return 10;

        return 0;
    }
}
