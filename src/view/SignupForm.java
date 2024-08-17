package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Doctor;
import model.Nurse;
import enums.Specialization;
import java.util.HashSet;
import java.util.Date;

public class SignupForm extends JFrame implements ActionListener {
    // Components
    private JTextField firstNameField = new JTextField(15);
    private JTextField lastNameField = new JTextField(15);
    private JTextField birthDateField = new JTextField(15); // Format: dd/mm/yyyy
    private JTextField addressField = new JTextField(15);
    private JTextField phoneNumberField = new JTextField(15);
    private JTextField emailField = new JTextField(15);
    private JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female"});
    private JTextField workStartDateField = new JTextField(15); // Format: dd/mm/yyyy
    private JTextField salaryField = new JTextField(15);
    private JTextField licenseNumberField = new JTextField(15);
    private JComboBox<Specialization> specializationComboBox = new JComboBox<>(Specialization.values());
    private JTextField usernameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton submitButton = new JButton("Submit");
    private JRadioButton doctorButton = new JRadioButton("Doctor");
    private JRadioButton nurseButton = new JRadioButton("Nurse");
    private ButtonGroup roleGroup = new ButtonGroup();

    // Constructor
    public SignupForm() {
        this.setTitle("Signup Form");
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        roleGroup.add(doctorButton);
        roleGroup.add(nurseButton);

        int row = 0;
        addComponent(new JLabel("Role:"), 0, row, gbc);
        addComponent(doctorButton, 1, row, gbc);
        addComponent(nurseButton, 2, row, gbc);

        row++;
        addComponent(new JLabel("First Name:"), 0, row, gbc);
        addComponent(firstNameField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Last Name:"), 0, row, gbc);
        addComponent(lastNameField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Birth Date (dd/mm/yyyy):"), 0, row, gbc);
        addComponent(birthDateField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Address:"), 0, row, gbc);
        addComponent(addressField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Phone Number:"), 0, row, gbc);
        addComponent(phoneNumberField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Email:"), 0, row, gbc);
        addComponent(emailField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Gender:"), 0, row, gbc);
        addComponent(genderComboBox, 1, row, gbc);

        row++;
        addComponent(new JLabel("Work Start Date (dd/mm/yyyy):"), 0, row, gbc);
        addComponent(workStartDateField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Salary:"), 0, row, gbc);
        addComponent(salaryField, 1, row, gbc);

        row++;
        addComponent(new JLabel("License Number:"), 0, row, gbc);
        addComponent(licenseNumberField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Specialization:"), 0, row, gbc);
        addComponent(specializationComboBox, 1, row, gbc);

        row++;
        addComponent(new JLabel("Username:"), 0, row, gbc);
        addComponent(usernameField, 1, row, gbc);

        row++;
        addComponent(new JLabel("Password:"), 0, row, gbc);
        addComponent(passwordField, 1, row, gbc);

        row++;
        addComponent(submitButton, 1, row, gbc);
        submitButton.addActionListener(this);

        this.setVisible(true);
    }

    private void addComponent(Component component, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        this.add(component, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Validate input
        String role = doctorButton.isSelected() ? "Doctor" : "Nurse";
        if (role.equals("Doctor")) {
            try {
                int licenseNumber = Integer.parseInt(licenseNumberField.getText());
                Specialization specialization = (Specialization) specializationComboBox.getSelectedItem();
                Doctor doctor = new Doctor(
                        0, // Assuming ID will be set by the system
                        firstNameField.getText(),
                        lastNameField.getText(),
                        parseDate(birthDateField.getText()),
                        addressField.getText(),
                        phoneNumberField.getText(),
                        emailField.getText(),
                        (String) genderComboBox.getSelectedItem(),
                        parseDate(workStartDateField.getText()),
                        Double.parseDouble(salaryField.getText()),
                        licenseNumber,
                        true, // Assuming finished internship by default
                        specialization,
                        usernameField.getText(),
                        new String(passwordField.getPassword())
                );
                // Add doctor to the hospital's staff members (implement the method to add doctor)
                // hospital.addStaffMember(doctor); // Example usage
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding doctor: " + ex.getMessage());
            }
        } else if (role.equals("Nurse")) {
            try {
                int licenseNumber = Integer.parseInt(licenseNumberField.getText());
                Nurse nurse = new Nurse(
                        0, // Assuming ID will be set by the system
                        firstNameField.getText(),
                        lastNameField.getText(),
                        parseDate(birthDateField.getText()),
                        addressField.getText(),
                        phoneNumberField.getText(),
                        emailField.getText(),
                        (String) genderComboBox.getSelectedItem(),
                        parseDate(workStartDateField.getText()),
                        Double.parseDouble(salaryField.getText()),
                        licenseNumber,
                        usernameField.getText(),
                        new String(passwordField.getPassword())
                );
                // Add nurse to the hospital's staff members (implement the method to add nurse)
                // hospital.addStaffMember(nurse); // Example usage
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding nurse: " + ex.getMessage());
            }
        }
    }

    private Date parseDate(String dateString) {
        try {
            // Implement date parsing logic here
            return new Date(); // Placeholder
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format: " + dateString);
            return null;
        }
    }

}
