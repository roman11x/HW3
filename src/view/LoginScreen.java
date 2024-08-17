package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {
    // Components
    ImageIcon userIcon = new ImageIcon("userIcon2.png");
    ImageIcon icon = new ImageIcon("img_1.png");
    ImageIcon passwordIcon = new ImageIcon("passIcon2.png");
    ImageIcon loginIcon = new ImageIcon("loginKey.png");
    ImageIcon titleIcon = new ImageIcon("anchorIcon.png");
    JLabel title = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel passwordLabel = new JLabel();
    JTextField usernameField = new JTextField(15); // Wider field
    JPasswordField passwordField = new JPasswordField(15); // Wider field
    JButton loginButton = new JButton();

    // Constructor
    LoginScreen() {
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new BorderLayout());
        this.setIconImage(icon.getImage());

        title.setText("Welcome To The Hanamal Hospital!");
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Serif", Font.BOLD, 20));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        title.setIcon(titleIcon);
        topPanel.add(title);
        topPanel.setBackground(Color.WHITE);
        this.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding for each component
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Center label
        usernameLabel.setText("Username:");
        usernameLabel.setIcon(userIcon);
        centerPanel.add(usernameLabel, gbc);

        // Username Field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Center field
        usernameField.setPreferredSize(new Dimension(200, 30)); // Wider field
        centerPanel.add(usernameField, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER; // Center label
        passwordLabel.setText("Password:");
        passwordLabel.setIcon(passwordIcon);
        centerPanel.add(passwordLabel, gbc);

        // Password Field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER; // Center field
        passwordField.setPreferredSize(new Dimension(200, 30)); // Wider field
        centerPanel.add(passwordField, gbc);

        this.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center the button
        loginButton.setIcon(loginIcon);
        loginButton.addActionListener(this);
        bottomPanel.add(loginButton);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String password = new String(passwordField.getPassword());
            if(usernameField.getText().equals("ADMIN")&&password.equals("ADMIN")) {
                MainMenu mainMenu = new MainMenu();
                this.dispose();
            }
        }

    }
}
