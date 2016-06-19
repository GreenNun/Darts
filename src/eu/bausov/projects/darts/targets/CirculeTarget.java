package eu.bausov.projects.darts.targets;

import eu.bausov.projects.darts.Coordinate;

import java.awt.*;

public class CirculeTarget extends Target {
    public CirculeTarget() {
        setPreferredSize(new Dimension(300, 300));
    }

    // Override paintComponent to perform own painting
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // paint parent's background
        setBackground(Color.GREEN);  // set background color for this JPanel

        // Drawing primitive shapes
        g.setColor(Color.YELLOW);    // set the drawing color;
        g.fillOval(45, 45, 210, 210);
        g.setColor(Color.RED);       // change the drawing color
        g.fillOval(75, 75, 150, 150);
        g.setColor(Color.YELLOW);    // set the drawing color;
        g.fillOval(105, 105, 90, 90);
        g.setColor(Color.RED);       // change the drawing color
        g.fillOval(130, 130, 40, 40);
        // Printing texts
        g.setColor(Color.BLACK);
        g.setFont(new Font("Dialog", Font.BOLD, 14));
        g.drawString("10 - 30 - 50 - 100", 10, 20);
    }

    @Override
    public String toString() {
        return "CirculeTarget{}";
    }

    @Override
    public int getScores(Coordinate coordinate) {
        double x = coordinate.getX() - 150;
        double y = coordinate.getY() - 150;

        if (Math.sqrt(x * x + y * y) < 20) return 100;
        if (Math.sqrt(x * x + y * y) < 45) return 50;
        if (Math.sqrt(x * x + y * y) < 75) return 30;
        if (Math.sqrt(x * x + y * y) < 105) return 10;

        return 0;
    }
}
