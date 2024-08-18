package view;

import control.Hospital;
import enums.BiologicalSex;
import enums.HealthFund;
import model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPatientMenu extends JFrame implements ActionListener {
    Hospital hospital;

    // UI Components
    JTextField IDField = new JTextField(10);
    JTextField FirstNameField = new JTextField(10);
    JTextField LastNameField = new JTextField(10);
    JTextField BirthDateField = new JTextField(10);
    JTextField AddressField = new JTextField(10);
    JTextField PhoneField = new JTextField(10);
    JTextField EmailField = new JTextField(10);
    JComboBox<HealthFund> healthFundComboBox = new JComboBox<>(HealthFund.values());
    JComboBox<BiologicalSex> biologicalSexJComboBox = new JComboBox<>(BiologicalSex.values());

    JButton submitButton = new JButton("Submit");

    //Constructor
    public AddPatientMenu() {
        this.hospital = Hospital.getInstance();
        this.setTitle("Add Patient Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new FlowLayout());

        // Add Components to Frame
        this.add(new JLabel("ID:"));
        this.add(IDField);
        this.add(new JLabel("First Name:"));
        this.add(FirstNameField);
        this.add(new JLabel("Last Name:"));
        this.add(LastNameField);
        this.add(new JLabel("Birth Date (dd/MM/yyyy):"));
        this.add(BirthDateField);
        this.add(new JLabel("Address:"));
        this.add(AddressField);
        this.add(new JLabel("Phone:"));
        this.add(PhoneField);
        this.add(new JLabel("Email:"));
        this.add(EmailField);
        this.add(new JLabel("Health Fund:"));
        this.add(healthFundComboBox);
        this.add(new JLabel("Biological Sex:"));
        this.add(biologicalSexJComboBox);

        this.add(submitButton);

        // Add ActionListeners
        submitButton.addActionListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                // Gather input data
                int id = Integer.parseInt(IDField.getText());
                String firstName = FirstNameField.getText();
                String lastName = LastNameField.getText();
                Date birthDate = dateFormat.parse(BirthDateField.getText());
                String address = AddressField.getText();
                String phone = PhoneField.getText();
                String email = EmailField.getText();
                HealthFund healthFund = (HealthFund) healthFundComboBox.getSelectedItem();
                BiologicalSex biologicalSex = (BiologicalSex) biologicalSexJComboBox.getSelectedItem();

                // Create and add patient to the hospital
                Patient patient = new Patient(id, firstName, lastName, birthDate, address, phone, email, null, healthFund, biologicalSex);
                hospital.addPatient(patient);
                JOptionPane.showMessageDialog(this, "Patient added successfully!");
            } catch (NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(this, "Error adding patient: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new AddPatientMenu().setVisible(true);
    }
}
