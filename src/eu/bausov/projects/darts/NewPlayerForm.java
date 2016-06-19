package eu.bausov.projects.darts;

import javax.swing.*;

public class NewPlayerForm extends JFrame {
    private JTextField textField1;
    private JButton addPlayerButton;
    private JPanel panel;

    @Override
    public void dispose() {
        Game.startForm.setVisible(true);
        super.dispose();
    }

    NewPlayerForm() {
        super("New Player");
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        addPlayerButton.addActionListener(e -> {
            String playerName = textField1.getText();
            // check for name repeat in the players list
            if (!Game.startForm.getListModel().contains(playerName)){
                Game.startForm.getListModel().addElement(playerName);
                // add new player to list
                StartForm.players.add(new Player(playerName));
                // highlight added item using index below
                int index = Game.startForm.getListModel().size() - 1;
                Game.startForm.getList1().setSelectedIndex(index);
                Game.startForm.getList1().ensureIndexIsVisible(index);
                Game.startForm.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Player with name " + playerName + " is already exists");
            }

        });
    }
}
