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
    JButton addIdButton = new JButton("Add ID");
    JButton addFirstNameButton = new JButton("Add First Name");
    JButton addLastNameButton = new JButton("Add Last Name");
    JButton addBirthDateButton = new JButton("Add Birth Date");
    JButton addAddressButton = new JButton("Add Address");
    JButton addPhoneButton = new JButton("Add Phone");
    JButton addEmailButton = new JButton("Add Email");
    JButton addGenderButton = new JButton("Add Gender");
    JButton addHealthFundButton = new JButton("Add Health Fund");
    JButton addBiologicalSexButton = new JButton("Add Biological Sex");
    JButton submitButton = new JButton("Submit");
    JButton backButton = new JButton("Back");

    JTextField IDField = new JTextField(10);
    JTextField FirstNameField = new JTextField(10);
    JTextField LastNameField = new JTextField(10);
    JTextField BirthDateField = new JTextField(10);
    JTextField AddressField = new JTextField(10);
    JTextField PhoneField = new JTextField(10);
    JTextField EmailField = new JTextField(10);
    JTextField GenderField = new JTextField(10);

    JComboBox<HealthFund> healthFundComboBox = new JComboBox<>(HealthFund.values());
    JComboBox<BiologicalSex> biologicalSexComboBox = new JComboBox<>(BiologicalSex.values());

    // Instance variables to store input data
    String ID, FirstName, LastName, Address, Phone, Email, Gender;
    Date BirthDate;
    HealthFund healthFund;
    BiologicalSex biologicalSex;

    // Constructor
    public AddPatientMenu() {
        this.hospital = Hospital.getInstance();
        this.setTitle("Add Patient Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(new FlowLayout());

        // Add ActionListeners
        addIdButton.addActionListener(this);
        addFirstNameButton.addActionListener(this);
        addLastNameButton.addActionListener(this);
        addBirthDateButton.addActionListener(this);
        addAddressButton.addActionListener(this);
        addPhoneButton.addActionListener(this);
        addEmailButton.addActionListener(this);
        addGenderButton.addActionListener(this);
        addHealthFundButton.addActionListener(this);
        addBiologicalSexButton.addActionListener(this);
        submitButton.addActionListener(this);
        backButton.addActionListener(this);

        // Add Components to Frame
        this.add(addIdButton);
        this.add(IDField);
        IDField.setVisible(false);

        this.add(addFirstNameButton);
        this.add(FirstNameField);
        FirstNameField.setVisible(false);

        this.add(addLastNameButton);
        this.add(LastNameField);
        LastNameField.setVisible(false);

        this.add(addBirthDateButton);
        this.add(BirthDateField);
        BirthDateField.setVisible(false);

        this.add(addAddressButton);
        this.add(AddressField);
        AddressField.setVisible(false);

        this.add(addPhoneButton);
        this.add(PhoneField);
        PhoneField.setVisible(false);

        this.add(addEmailButton);
        this.add(EmailField);
        EmailField.setVisible(false);

        this.add(addGenderButton);
        this.add(GenderField);
        GenderField.setVisible(false);

        this.add(addHealthFundButton);
        this.add(healthFundComboBox);
        healthFundComboBox.setVisible(false);

        this.add(addBiologicalSexButton);
        this.add(biologicalSexComboBox);
        biologicalSexComboBox.setVisible(false);

        this.add(submitButton);
        this.add(backButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (e.getSource() == addIdButton) {
            IDField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, IDField, "Enter ID", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                ID = IDField.getText();
                IDField.setVisible(false);
            }
        }
        if (e.getSource() == addFirstNameButton) {
            FirstNameField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, FirstNameField, "Enter First Name", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                FirstName = FirstNameField.getText();
                FirstNameField.setVisible(false);
            }
        }
        if (e.getSource() == addLastNameButton) {
            LastNameField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, LastNameField, "Enter Last Name", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                LastName = LastNameField.getText();
                LastNameField.setVisible(false);
            }
        }
        if (e.getSource() == addBirthDateButton) {
            BirthDateField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, BirthDateField, "Enter Birth Date (dd/MM/yyyy)", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                try {
                    BirthDate = dateFormat.parse(BirthDateField.getText());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid Date Format");
                }
                BirthDateField.setVisible(false);
            }
        }
        if (e.getSource() == addAddressButton) {
            AddressField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, AddressField, "Enter Address", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Address = AddressField.getText();
                AddressField.setVisible(false);
            }
        }
        if (e.getSource() == addPhoneButton) {
            PhoneField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, PhoneField, "Enter Phone", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Phone = PhoneField.getText();
                PhoneField.setVisible(false);
            }
        }
        if (e.getSource() == addEmailButton) {
            EmailField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, EmailField, "Enter Email", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Email = EmailField.getText();
                EmailField.setVisible(false);
            }
        }
        if (e.getSource() == addGenderButton) {
            GenderField.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, GenderField, "Enter Gender", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Gender = GenderField.getText();
                GenderField.setVisible(false);
            }
        }
        if (e.getSource() == addHealthFundButton) {
            healthFundComboBox.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, healthFundComboBox, "Select Health Fund", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                healthFund = (HealthFund) healthFundComboBox.getSelectedItem();
                healthFundComboBox.setVisible(false);
            }
        }
        if (e.getSource() == addBiologicalSexButton) {
            biologicalSexComboBox.setVisible(true);
            int result = JOptionPane.showConfirmDialog(this, biologicalSexComboBox, "Select Biological Sex", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                biologicalSex = (BiologicalSex) biologicalSexComboBox.getSelectedItem();
                biologicalSexComboBox.setVisible(false);
            }
        }

        if (e.getSource() == submitButton) {
            try {
                int id = Integer.parseInt(ID);
                // Check if the patient already exists
                if (hospital.getPatients().containsKey(id)) {
                    JOptionPane.showMessageDialog(this, "Patient with ID " + ID + " already exists!");
                } else {
                    Patient patient = new Patient(id, FirstName, LastName, BirthDate, Address, Phone, Email, Gender, healthFund, biologicalSex);
                    hospital.addPatient(patient);
                    JOptionPane.showMessageDialog(this, "Patient added successfully!");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding patient: " + ex.getMessage());
            }
        }
        if(e.getSource() == backButton){
            AdminMainMenu menu = new AdminMainMenu();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new AddPatientMenu().setVisible(true);
    }
}
