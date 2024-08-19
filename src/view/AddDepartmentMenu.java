package view;

import control.Hospital;
import model.Department;
import model.Doctor;
import enums.Specialization;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class AddDepartmentMenu extends JFrame implements ActionListener {
    private JTextField numberField, nameField, managerIdField, locationField;
    private JComboBox<Specialization> specializationComboBox;
    private JButton submitButton, goBackButton;

    public AddDepartmentMenu() {
        this.setTitle("Add Department");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(6, 2, 10, 10));

        // Initialize input fields
        numberField = new JTextField();
        nameField = new JTextField();
        managerIdField = new JTextField();
        locationField = new JTextField();

        // Specialization dropdown
        specializationComboBox = new JComboBox<>(Specialization.values());

        // Buttons
        submitButton = new JButton("Submit");
        goBackButton = new JButton("Back To Main Menu");

        // Add components to the frame
        this.add(new JLabel("Department Number:"));
        this.add(numberField);
        this.add(new JLabel("Department Name:"));
        this.add(nameField);
        this.add(new JLabel("Manager ID:"));
        this.add(managerIdField);
        this.add(new JLabel("Location:"));
        this.add(locationField);
        this.add(new JLabel("Specialization:"));
        this.add(specializationComboBox);
        this.add(submitButton);
        this.add(goBackButton);

        // Add action listeners
        submitButton.addActionListener(this);
        goBackButton.addActionListener(this);

        this.setSize(400, 300);
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
                int number = Integer.parseInt(numberField.getText());
                String name = nameField.getText();
                String location = locationField.getText();
                Specialization specialization = (Specialization) specializationComboBox.getSelectedItem();

                // Get the manager from the Hospital staff list
                int managerId = Integer.parseInt(managerIdField.getText());
                Doctor manager = (Doctor) Hospital.getInstance().getStaffMember(managerId);

                if (manager == null) {
                    throw new IllegalArgumentException("Manager with ID " + managerId + " does not exist or is not a doctor.");
                }

                // Create a new Department
                Department newDepartment = new Department(number, name, manager, location, specialization);

                // Add the new Department
                Hospital.getInstance().addDepartment(newDepartment);
                Hospital.getInstance().saveDepartments();  // Save to file
                JOptionPane.showMessageDialog(this, "Department added successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new AddDepartmentMenu().setVisible(true);
    }
}
