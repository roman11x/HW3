package view;

import control.Hospital;
import model.*;
import enums.Specialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignUpForm extends JFrame implements ActionListener {
    private JTextField idField, firstNameField, lastNameField, addressField, phoneNumberField, emailField, genderField,
            salaryField, licenseNumberField, usernameField, passwordField, workStartDateField;
    private JComboBox<String> staffTypeComboBox;
    private JComboBox<Specialization> specializationComboBox;
    private JButton submitButton, goBackButton;

    // End date for validation
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final Date END_DATE;

    static {
        try {
            END_DATE = DATE_FORMAT.parse("30/04/2024");
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing END_DATE", e);
        }
    }

    public SignUpForm() {
        this.setTitle("Sign Up Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(16, 2, 10, 10));

        // Initialize input fields
        idField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        addressField = new JTextField();
        phoneNumberField = new JTextField();
        emailField = new JTextField();
        genderField = new JTextField();
        salaryField = new JTextField();
        licenseNumberField = new JTextField();
        usernameField = new JTextField();
        passwordField = new JTextField();
        workStartDateField = new JTextField();

        // Staff type dropdown
        staffTypeComboBox = new JComboBox<>(new String[]{"Doctor", "Nurse", "IntensiveCareDoctor", "IntensiveCareNurse"});

        // Specialization dropdown for doctors
        specializationComboBox = new JComboBox<>(Specialization.values());
        specializationComboBox.setVisible(false);  // Hidden by default

        // Buttons
        submitButton = new JButton("Submit");
        goBackButton = new JButton("Back To Main Menu");

        // Add components to the frame
        this.add(new JLabel("Staff Type:"));
        this.add(staffTypeComboBox);
        this.add(new JLabel("ID:"));
        this.add(idField);
        this.add(new JLabel("First Name:"));
        this.add(firstNameField);
        this.add(new JLabel("Last Name:"));
        this.add(lastNameField);
        this.add(new JLabel("Address:"));
        this.add(addressField);
        this.add(new JLabel("Phone Number:"));
        this.add(phoneNumberField);
        this.add(new JLabel("Email:"));
        this.add(emailField);
        this.add(new JLabel("Gender:"));
        this.add(genderField);
        this.add(new JLabel("Salary:"));
        this.add(salaryField);
        this.add(new JLabel("License Number:"));
        this.add(licenseNumberField);
        this.add(new JLabel("Username:"));
        this.add(usernameField);
        this.add(new JLabel("Password:"));
        this.add(passwordField);
        this.add(new JLabel("Work Start Date (dd/MM/yyyy):"));
        this.add(workStartDateField);
        this.add(new JLabel("Specialization:"));
        this.add(specializationComboBox);
        this.add(submitButton);
        this.add(goBackButton);

        // Add action listeners
        submitButton.addActionListener(this);
        goBackButton.addActionListener(this);
        staffTypeComboBox.addActionListener(this);

        this.setSize(500, 650);
        this.setVisible(true);

        // Load existing staff members
        Hospital.getInstance().loadStaffMembers();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBackButton) {
            AdminMainMenu mainMenu = new AdminMainMenu();
            this.dispose();
        } else if (e.getSource() == submitButton) {
            try {
                // Extract data from fields
                int id = Integer.parseInt(idField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String phoneNumber = phoneNumberField.getText();
                String email = emailField.getText();
                String gender = genderField.getText();
                double salary = Double.parseDouble(salaryField.getText());
                int licenseNumber = Integer.parseInt(licenseNumberField.getText());
                String username = usernameField.getText();
                String password = passwordField.getText();
                Date workStartDate = DATE_FORMAT.parse(workStartDateField.getText());

                // Validate work start date
                if (workStartDate.after(END_DATE)) {
                    throw new IllegalArgumentException("Work start date must be on or before 30/04/2024.");
                }

                // Create the appropriate StaffMember instance
                StaffMember newStaffMember = null;
                String selectedType = (String) staffTypeComboBox.getSelectedItem();
                Specialization specialization = (Specialization) specializationComboBox.getSelectedItem();

                switch (selectedType) {
                    case "Doctor":
                        newStaffMember = new Doctor(id, firstName, lastName, workStartDate, address, phoneNumber, email,
                                gender, workStartDate, salary, licenseNumber, true, specialization, username, password);
                        break;
                    case "IntensiveCareDoctor":
                        newStaffMember = new IntensiveCareDoctor(id, firstName, lastName, workStartDate, address, phoneNumber, email,
                                gender, workStartDate, salary, licenseNumber, true, username, password);
                        break;
                    case "Nurse":
                        newStaffMember = new Nurse(id, firstName, lastName, workStartDate, address, phoneNumber, email,
                                gender, workStartDate, salary, licenseNumber, username, password);
                        break;
                    case "IntensiveCareNurse":
                        newStaffMember = new IntensiveCareNurse(id, firstName, lastName, workStartDate, address, phoneNumber, email,
                                gender, workStartDate, salary, licenseNumber, username, password);
                        break;
                }

                // Save the new StaffMember
                if (newStaffMember != null) {
                    Hospital.getInstance().addStaffMember(newStaffMember);
                    Hospital.getInstance().saveStaffMembers();  // Save to file
                    JOptionPane.showMessageDialog(this, "Staff Member added successfully!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == staffTypeComboBox) {
            String selectedType = (String) staffTypeComboBox.getSelectedItem();
            specializationComboBox.setVisible(selectedType.equals("Doctor"));
        }
    }

    public static void main(String[] args) {
        new SignUpForm().setVisible(true);
    }
}
