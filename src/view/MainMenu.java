package view;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        this.setTitle("Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Welcome to the Main Menu", SwingConstants.CENTER);
        this.add(label, BorderLayout.CENTER);
        this.setVisible(true);
    }


}
