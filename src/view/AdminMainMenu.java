package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends JFrame implements ActionListener {
    // Components
    private JButton signupButton = new JButton("Sign Up Staff");

    private ImageIcon adminIcon = new ImageIcon("adminIcon.png");

    // Constructor
    public AdminMainMenu() {
        this.setTitle("Admin Menu");
        this.setIconImage(adminIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new BorderLayout());

        // Create a panel for the button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.WHITE);

        // Configure the sign-up button
        signupButton.addActionListener(this);
        panel.add(signupButton);

        this.add(panel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            // Open the SignupForm
            new SignUpForm();
        }
    }

}
