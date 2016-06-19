package eu.bausov.projects.darts;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StartForm extends JFrame implements Serializable {
    private JPanel panel1;
    private JList<String> list1;
    private JButton addButton;
    private JButton deleteButton;
    private JButton startGameButton;
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    static List<Player> players = new ArrayList<>();

    DefaultListModel<String> getListModel() {
        return listModel;
    }

    JList<String> getList1() {
        return list1;
    }

    StartForm() {
        super("Darts Game");
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);

        list1.setModel(listModel);

        // anonymous class to lambda
        addButton.addActionListener(e -> {
            new NewPlayerForm();
            setVisible(false);
        });

        deleteButton.addActionListener(e -> {
            String selectedString = list1.getSelectedValue();
            int selectedIndex = list1.getSelectedIndex();
            listModel.removeElement(selectedString);
            players.remove(selectedIndex);
        });

        startGameButton.addActionListener(e -> {
            if (list1.getSelectedValue() != null) {
                new GameForm(players.get(list1.getSelectedIndex()));
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Please, select the Player.");
            }
        });
    }
}
