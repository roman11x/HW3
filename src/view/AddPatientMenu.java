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

    // Instance variables to store input data
    String ID;
    String FirstName;
    String LastName;
    Date BirthDate;
    String Address;
    String Phone;
    String Email;
    String Gender;
    HealthFund healthFund;
    BiologicalSex biologicalSex;

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

    JComboBox<HealthFund> healthFundComboBox = new JComboBox<>(HealthFund.values());
    JComboBox<BiologicalSex> biologicalSexJComboBox = new JComboBox<>(BiologicalSex.values());
    JTextField IDField = new JTextField(10);
    JTextField FirstNameField = new JTextField(10);
    JTextField LastNameField = new JTextField(10);
    JTextField BirthDateField = new JTextField(10);
    JTextField AddressField = new JTextField(10);
    JTextField PhoneField = new JTextField(10);
    JTextField EmailField = new JTextField(10);
    JTextField GenderField = new JTextField(10);
    JTextField HealthFundField = new JTextField(10);

    //Constructor
    public AddPatientMenu() {
        this.hospital = Hospital.getInstance();
        this.setTitle("Add Patient Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,420);
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

        // Add Components to Frame
        this.add(addIdButton);
        this.add(addFirstNameButton);
        this.add(addLastNameButton);
        this.add(addBirthDateButton);
        this.add(addAddressButton);
        this.add(addPhoneButton);
        this.add(addEmailButton);
        this.add(addGenderButton);
        this.add(addHealthFundButton);
        this.add(addBiologicalSexButton);
        this.add(submitButton);

        this.add(IDField);
        IDField.setVisible(false);
        this.add(FirstNameField);
        FirstNameField.setVisible(false);
        this.add(LastNameField);
        LastNameField.setVisible(false);
        this.add(BirthDateField);
        BirthDateField.setVisible(false);
        this.add(AddressField);
        AddressField.setVisible(false);
        this.add(PhoneField);
        PhoneField.setVisible(false);
        this.add(EmailField);
        EmailField.setVisible(false);
        this.add(GenderField);
        GenderField.setVisible(false);
        this.add(HealthFundField);
        HealthFundField.setVisible(false);

        // Set JComboBox visibility to false initially
        healthFundComboBox.setVisible(false);
        this.add(healthFundComboBox);
        biologicalSexJComboBox.setVisible(false);
        this.add(biologicalSexJComboBox);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (e.getSource() == addIdButton) {
            IDField.setVisible(true);
            ID = IDField.getText();
            JOptionPane.showMessageDialog(this, "ID: " + ID);
            IDField.setVisible(false);
        }
        if (e.getSource() == addFirstNameButton) {
            FirstNameField.setVisible(true);
            FirstName = FirstNameField.getText();
            JOptionPane.showMessageDialog(this, "First Name: " + FirstName);
            FirstNameField.setVisible(false);
        }
        if (e.getSource() == addLastNameButton) {
            LastNameField.setVisible(true);
            LastName = LastNameField.getText();
            JOptionPane.showMessageDialog(this, "Last Name: " + LastName);
            LastNameField.setVisible(false);
        }
        if (e.getSource() == addBirthDateButton) {
            BirthDateField.setVisible(true);
            String birthDateString = BirthDateField.getText();
            try {
                BirthDate = dateFormat.parse(birthDateString);
                JOptionPane.showMessageDialog(this, "Birth Date: " + BirthDate);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Date Format");
            }
            BirthDateField.setVisible(false);
        }
        if (e.getSource() == addAddressButton) {
            AddressField.setVisible(true);
            Address = AddressField.getText();
            JOptionPane.showMessageDialog(this, "Address: " + Address);
            AddressField.setVisible(false);
        }
        if (e.getSource() == addPhoneButton) {
            PhoneField.setVisible(true);
            Phone = PhoneField.getText();
            JOptionPane.showMessageDialog(this, "Phone: " + Phone);
            PhoneField.setVisible(false);
        }
        if (e.getSource() == addEmailButton) {
            EmailField.setVisible(true);
            Email = EmailField.getText();
            JOptionPane.showMessageDialog(this, "Email: " + Email);
            EmailField.setVisible(false);
        }
        if (e.getSource() == addGenderButton) {
            GenderField.setVisible(true);
            Gender = GenderField.getText();
            JOptionPane.showMessageDialog(this, "Gender: " + Gender);
            GenderField.setVisible(false);
        }
        if (e.getSource() == addHealthFundButton) {
            healthFundComboBox.setVisible(true);
            healthFund = (HealthFund) healthFundComboBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "Selected Health Fund: " + healthFund);
            healthFundComboBox.setVisible(false);
        }
        if(e.getSource() == addBiologicalSexButton){
            biologicalSexJComboBox.setVisible(true);
            biologicalSex = (BiologicalSex) biologicalSexJComboBox.getSelectedItem();
            JOptionPane.showMessageDialog(this,"Selected Biological Sex: " + biologicalSex);
            biologicalSexJComboBox.setVisible(false);
        }
        if(e.getSource() == submitButton) {
            try {
                int id = Integer.parseInt(ID);
                Patient patient = new Patient(id, FirstName, LastName, BirthDate, Address, Phone, Email, Gender, healthFund, biologicalSex);
                hospital.addPatient(patient);
                JOptionPane.showMessageDialog(this, "Patient added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error adding patient: " + ex.getMessage());
            }
        }
    }
     public static void main(String[] args) {
        new AddPatientMenu().setVisible(true);
     }
}
