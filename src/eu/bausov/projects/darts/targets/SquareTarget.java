package eu.bausov.projects.darts.targets;

import eu.bausov.projects.darts.Coordinate;

import java.awt.*;

public class SquareTarget extends Target {
    public SquareTarget() {
        setPreferredSize(new Dimension(300, 300));
    }

    // Override paintComponent to perform own painting
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // paint parent's background
        setBackground(Color.BLACK);  // set background color for this JPanel

        // Drawing primitive shapes
        g.setColor(Color.YELLOW);    // set the drawing color;
        g.fillRect(45, 45, 210, 210);
        g.setColor(Color.RED);       // change the drawing color
        g.fillRect(75, 75, 150, 150);
        g.setColor(Color.YELLOW);    // set the drawing color;
        g.fillRect(105, 105, 90, 90);
        g.setColor(Color.RED);       // change the drawing color
        g.fillRect(130, 130, 40, 40);
        // Printing texts
        g.setColor(Color.WHITE);
        g.setFont(new Font("Dialog", Font.BOLD, 14));
        g.drawString("10 - 30 - 50 - 100", 10, 20);
    }

    @Override
    public String toString() {
        return "SquareTarget{}";
    }

    @Override
    public int getScores(Coordinate coordinate) {
        double x = coordinate.getX() - 150;
        double y = coordinate.getY() - 150;

        if (x > -21 && x < 21 && y > -21 && y < 21) return 100;
        if (x > -45 && x < 45 && y > -45 && y < 45) return 50;
        if (x > -75 && x < 75 && y > -75 && y < 75) return 30;
        if (x > -105 && x < 105 && y > -105 && y < 105) return 10;

        return 0;
    }
}