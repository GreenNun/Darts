package eu.bausov.projects.darts;

import eu.bausov.projects.darts.targets.*;
import eu.bausov.projects.darts.util.MotionPanel;
import javax.swing.*;
import java.awt.*;

class GameForm extends JFrame {
    private JRadioButton circuleRadioButton = new JRadioButton();
    private JRadioButton squareRadioButton = new JRadioButton();
    private JRadioButton rectangleRadioButton = new JRadioButton();
    private JTextField xCoordinateField = new JTextField(5);
    private JTextField yCoordinateField = new JTextField(5);
    private JButton throwButton = new JButton("Throw");
    private volatile JLayeredPane basePanel = getLayeredPane();
    private JPanel playerNamePanel = new MotionPanel(this);
    private JPanel targetPanel = new MotionPanel(this);
    private JPanel radioButtonsPanel = new MotionPanel(this);
    private JPanel coordinatesPanel = new MotionPanel(this);
    private JLabel xCoordinateLabel = new JLabel();
    private JLabel yCoordinateLabel = new JLabel();
    private JPanel throwButtonPanel = new MotionPanel(this);
    private JLabel radioButtonsLabel1 = new JLabel();
    private JLabel radioButtonsLabel2 = new JLabel();
    private JLabel radioButtonsLabel3 = new JLabel();
    private JLabel radioButtonsLabel4 = new JLabel();
    private JLabel playerName = new JLabel();
    private JLabel currentScore = new JLabel();
    private JLabel totalScore = new JLabel();
    private JLabel throwCount = new JLabel();
    private Player currentPlayer;
    private int count = 0;

    GameForm(Player player) {
        super("Darts Game");

        currentPlayer = player;

        init();

        setPreferredSize(new Dimension(300, 470));
        setUndecorated(true);
        //setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        circuleRadioButton.addActionListener(e -> {
            targetPanel.remove(0);
            targetPanel.add(new CirculeTarget(), 0);
            pack();
            repaint();
        });

        squareRadioButton.addActionListener(e -> {
            targetPanel.remove(0);
            targetPanel.add(new SquareTarget(), 0);
            pack();
            repaint();
        });

        rectangleRadioButton.addActionListener(e -> {
            targetPanel.remove(0);
            targetPanel.add(new RectangleTarget(), 0);
            pack();
            repaint();
        });

        throwButton.addActionListener(e -> {
            if (count < 5) {
                try {
                    int x = Integer.parseInt(xCoordinateField.getText());
                    int y = Integer.parseInt(yCoordinateField.getText());

                    System.out.println(x);
                    System.out.println(y);

                    Coordinate coordinate = new Coordinate(x, y);
                    targetPanel.add(new BlueDart(coordinate, 10));

                    // add coordinate to player's array
                    currentPlayer.getCoordinates()[count] = coordinate;
                    // add scores to player's array
                    int currentScoreInt = ((Target) targetPanel.getComponent(0)).getScores(coordinate);
                    currentPlayer.getScores()[count] = currentScoreInt;

                    // update scores
                    int totalScoreInt = currentPlayer.total();
                    currentScore.setText("Scores: " + currentScoreInt);
                    totalScore.setText("Total: " + totalScoreInt);
                    throwCount.setText("  # " + (count + 1) + " of 5");

                    ///////////////////// THREADS //////////////////////
                    if (currentScoreInt != 0) {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {

                                BlueDart[] blueDarts = {
                                        new BlueDart(coordinate, 8),
                                        new BlueDart(coordinate, 9),
                                        new BlueDart(coordinate, 10),
                                        new BlueDart(coordinate, 11),
                                        new BlueDart(coordinate, 12)
                                };

                                while (true) {
                                    for (int i = 0; i < blueDarts.length; i++) {
                                        BlueDart blueDart = blueDarts[i];
                                        blueDart.setBounds(0, 65, 300, 300);
                                        synchronized (basePanel) {
                                            basePanel.add(blueDart, JLayeredPane.DRAG_LAYER, 100);
                                        }
                                        pack();
                                        repaint();
                                        try {
                                            Thread.sleep(200);
                                        } catch (InterruptedException e1) {
                                            e1.printStackTrace();
                                        }
                                        synchronized (basePanel) {
                                            basePanel.remove(basePanel.getIndexOf(blueDarts[i]));
                                        }
                                        pack();
                                        repaint();
                                    }
                                    for (int i = blueDarts.length - 1; i > -1; i--) {
                                        BlueDart blueDart = blueDarts[i];
                                        blueDart.setBounds(0, 65, 300, 300);
                                        synchronized (basePanel) {
                                            basePanel.add(blueDart, JLayeredPane.DRAG_LAYER, 100);
                                            pack();
                                            repaint();
                                        }

                                        try {
                                            Thread.sleep(200);
                                        } catch (InterruptedException e1) {
                                            e1.printStackTrace();
                                        }
                                        synchronized (basePanel) {
                                            basePanel.remove(basePanel.getIndexOf(blueDarts[i]));
                                            pack();
                                            repaint();
                                        }
                                    }
                                }

                            }
                        });
                        thread.setDaemon(true);
                        thread.start();
                    } else {
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {

                                GrayDart[] blueDarts = {
                                        new GrayDart(coordinate, 8),
                                        new GrayDart(coordinate, 9),
                                        new GrayDart(coordinate, 10),
                                        new GrayDart(coordinate, 11),
                                        new GrayDart(coordinate, 12)
                                };

                                while (true) {
                                    for (int i = 0; i < blueDarts.length; i++) {
                                        GrayDart blueDart = blueDarts[i];
                                        blueDart.setBounds(0, 65, 300, 300);
                                        synchronized (basePanel) {
                                            basePanel.add(blueDart, JLayeredPane.DRAG_LAYER, 100);
                                        }
                                        pack();
                                        repaint();
                                        try {
                                            Thread.sleep(200);
                                        } catch (InterruptedException e1) {
                                            e1.printStackTrace();
                                        }
                                        synchronized (basePanel) {
                                            basePanel.remove(basePanel.getIndexOf(blueDarts[i]));
                                        }
                                        pack();
                                        repaint();
                                    }
                                    for (int i = blueDarts.length - 1; i > -1; i--) {
                                        GrayDart blueDart = blueDarts[i];
                                        blueDart.setBounds(0, 65, 300, 300);
                                        synchronized (basePanel) {
                                            basePanel.add(blueDart, JLayeredPane.DRAG_LAYER, 100);
                                            pack();
                                            repaint();
                                        }

                                        try {
                                            Thread.sleep(200);
                                        } catch (InterruptedException e1) {
                                            e1.printStackTrace();
                                        }
                                        synchronized (basePanel) {
                                            basePanel.remove(basePanel.getIndexOf(blueDarts[i]));
                                            pack();
                                            repaint();
                                        }
                                    }
                                }

                            }
                        });
                        thread.setDaemon(true);
                        thread.start();
                    }
                    count++; //////////////////////////////////////////////////////////////////
                } catch (Exception ex) {
                    System.out.println("err");
                }
            }
            // after 5 throws
            if (count == 5) {
                dispose();
            }

        });
    }

    @Override
    public void dispose() {
        JOptionPane.showMessageDialog(null, "5 throws are made.");
        new Results(currentPlayer).setVisible(true);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e1) {
//            e1.printStackTrace();
//        }
        super.dispose();
        Thread.currentThread().interrupt();
    }

    private void init() {
        playerName.setFont(new Font("Dialog", Font.BOLD, 20));
        playerNamePanel.add(playerName);
        playerNamePanel.add(currentScore);
        playerNamePanel.add(throwCount);
        playerNamePanel.add(totalScore);
        playerName.setText(" " + currentPlayer.getName().toUpperCase());
        currentScore.setText("Scores: 0");
        totalScore.setText("Total: 0");
        totalScore.setFont(new Font("Dialog", Font.BOLD, 16));
        throwCount.setText("  # 0 of 5");
        throwCount.setFont(new Font("Dialog", Font.BOLD, 16));
        //playerNamePanel.setLayout(new BoxLayout(playerNamePanel, BoxLayout.Y_AXIS));
        playerNamePanel.setLayout(new GridLayout(2, 2));
        ((GridLayout) playerNamePanel.getLayout()).setVgap(0); // set gap 0

        targetPanel.add(new CirculeTarget()); // set default target
        circuleRadioButton.setSelected(true); // radio button default selection

        radioButtonsPanel.add(radioButtonsLabel1);
        radioButtonsLabel1.setText("Target:");

        radioButtonsPanel.add(circuleRadioButton);
        radioButtonsPanel.add(radioButtonsLabel2);
        radioButtonsLabel2.setText("Circule");

        radioButtonsPanel.add(squareRadioButton);
        radioButtonsPanel.add(radioButtonsLabel3);
        radioButtonsLabel3.setText("Square");

        radioButtonsPanel.add(rectangleRadioButton);
        radioButtonsPanel.add(radioButtonsLabel4);
        radioButtonsLabel4.setText("Rectangle");

        xCoordinateLabel.setText("X:");
        xCoordinateLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        coordinatesPanel.add(xCoordinateLabel);
        coordinatesPanel.add(xCoordinateField);
        yCoordinateLabel.setText("Y:");
        yCoordinateLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        coordinatesPanel.add(yCoordinateLabel);
        coordinatesPanel.add(yCoordinateField);

        throwButtonPanel.add(throwButton);

        playerNamePanel.setBounds(0, 0, 300, 60);
        targetPanel.setBounds(0, 60, 300, 305);
        radioButtonsPanel.setBounds(0, 365, 300, 30);
        coordinatesPanel.setBounds(0, 395, 300, 30);
        throwButtonPanel.setBounds(0, 425, 300, 35);

        basePanel.add(playerNamePanel, JLayeredPane.POPUP_LAYER, 0);
        basePanel.add(targetPanel, JLayeredPane.POPUP_LAYER, 4);
        basePanel.add(radioButtonsPanel, JLayeredPane.POPUP_LAYER, 1);
        basePanel.add(coordinatesPanel, JLayeredPane.POPUP_LAYER, 2);
        basePanel.add(throwButtonPanel, JLayeredPane.POPUP_LAYER, 3);
        //basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));

        ButtonGroup group = new ButtonGroup();
        group.add(circuleRadioButton);
        group.add(squareRadioButton);
        group.add(rectangleRadioButton);
    }
}
