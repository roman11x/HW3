package view;

import javax.swing.*;
import java.awt.*;

import control.Hospital;
import model.*;

public class LoginScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private Hospital hospital;

    public LoginScreen() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);

        add(inputPanel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);

        hospital = Hospital.getInstance(); // Assuming this initializes the hospital

        loginButton.addActionListener(e -> handleLoginButtonClick());

        setVisible(true);
    }

    private void handleLoginButtonClick() {
        Integer username = Integer.valueOf(usernameField.getText());
        String password = new String(passwordField.getPassword());

        StaffMember user = hospital.authenticate(username, password);

        if (user != null) {
            if (user instanceof Admin) {
                AdminMainMenu adminMenu = new AdminMainMenu();
                adminMenu.setVisible(true);
            } else if (user instanceof Doctor) {
                DoctorMainMenu doctorMenu = new DoctorMainMenu();
                doctorMenu.setVisible(true);
            } else if (user instanceof Nurse) {
                NurseMainMenu nurseMenu = new NurseMainMenu();
                nurseMenu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Unknown user type.");
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen());
    }
}
