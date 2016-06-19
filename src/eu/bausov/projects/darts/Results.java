package eu.bausov.projects.darts;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Results extends JFrame {
    private JTextArea textArea1;
    private JButton OKButton;
    private JButton saveToFileButton;
    private JPanel basePanel;

    Results(Player player) {
        super("Darts Game");
        setContentPane(basePanel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);
        setSize(300, 450);
        setVisible(true);
        pack();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("===============================================\n");
        stringBuilder.append("|\tPlayer name: \t" + player.getName() + "\n");
        stringBuilder.append("===============================================\n");
        stringBuilder.append("Coordinates: \n");
        for (int i = 0; i < player.getCoordinates().length; i++) {
            stringBuilder.append("| " + i + " | " + player.getCoordinates()[i].getX() + " | " + player.getCoordinates()[i].getY() + " | " + player.getScores()[0] + " |\n");
        }
        int totalScores = 0;
        for (int i = 0; i < player.getScores().length; i++) {
            totalScores += player.getScores()[i];
        }
        stringBuilder.append("===============================================\n");
        stringBuilder.append("|\tTOTAL: \t\t" + totalScores + "\n");
        stringBuilder.append("===============================================");

        textArea1.setText(stringBuilder.toString());

        OKButton.addActionListener(e -> {
            dispose();
        });

        saveToFileButton.addActionListener(e -> {
            writeToFile(stringBuilder.toString(), player.getName());
        });
    }

    @Override
    public void dispose() {
        Game.startForm.setVisible(true);
        super.dispose();
    }

    private void writeToFile(String text, String playerName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(playerName + ".txt"));
            writer.write(text);
            JOptionPane.showMessageDialog(null, "Saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error. File not saved.");
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
            }
        }
    }
}
