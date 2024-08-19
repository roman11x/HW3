package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainMenu extends JFrame implements ActionListener {
    // Components
    private JButton signupButton = new JButton("Sign Up Staff");
    private JButton addMedicalPorblemButton = new JButton("Add a Medical Problem");
    private JButton addPatientButton = new JButton("Add a Patient");
    private JButton addVisitButton = new JButton("Add a Visit");
    private JButton addDepartmentButton = new JButton("Add a Department");
    private JButton addMedicationButton = new JButton("Add a Medication");
    private JButton addDoctorToDepartmentButton = new JButton("Add a Doctor to Department");
    private JButton addNurseToDepartmentButton = new JButton("Add a Nurse to Department");
    private JButton addTreatmentButton = new JButton("Add a Treatment");
    private JButton removeStaffButton = new JButton("Remove Staff");
    private JButton removeMedicalButton = new JButton("Remove Medical Problem");
    private JButton removeVisitButton = new JButton("Remove Visit");
    private JButton removeDepartmentButton = new JButton("Remove Department");
    private JButton removeMedicationButton = new JButton("Remove Medication");
    private JButton removeTreatmentButton = new JButton("Remove Treatment");
    private JButton removePatientButton = new JButton("Remove Patient");
    private JButton viewDataButton = new JButton("View Data");
    private ImageIcon adminIcon = new ImageIcon("adminIcon.png");
    private ImageIcon medicalProblemIcon = new ImageIcon("diseaseIcon.png");
    private ImageIcon dataIcon = new ImageIcon("dataLogo.png");
    private ImageIcon staffIcon = new ImageIcon("staffIcon.png");
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

        // Configure the buttons
        signupButton.addActionListener(this);
        addMedicalPorblemButton.addActionListener(this);
        addPatientButton.addActionListener(this);
        addVisitButton.addActionListener(this);
        addDepartmentButton.addActionListener(this);
        addMedicationButton.addActionListener(this);
        addDoctorToDepartmentButton.addActionListener(this);
        addNurseToDepartmentButton.addActionListener(this);
        addTreatmentButton.addActionListener(this);
        removeStaffButton.addActionListener(this);
        removeMedicalButton.addActionListener(this);
        removeVisitButton.addActionListener(this);
        removeDepartmentButton.addActionListener(this);
        removeMedicationButton.addActionListener(this);
        removeTreatmentButton.addActionListener(this);


        addMedicalPorblemButton.setIcon(medicalProblemIcon);
        addMedicalPorblemButton.setHorizontalTextPosition(JButton.CENTER);
        addMedicalPorblemButton.setVerticalTextPosition(JButton.BOTTOM);
        panel.add(signupButton);
        signupButton.setIcon(staffIcon);
        panel.add(addMedicalPorblemButton);;
        panel.add(addPatientButton);
        panel.add(addVisitButton);
        panel.add(addDepartmentButton);
        panel.add(addMedicationButton);
        panel.add(addDoctorToDepartmentButton);
        panel.add(addNurseToDepartmentButton);
        panel.add(addTreatmentButton);
        panel.add(removeStaffButton);
        removeStaffButton.setIcon(staffIcon);
        panel.add(removeMedicalButton);
        panel.add(removeVisitButton);
        panel.add(removeDepartmentButton);
        panel.add(removeMedicationButton);
        panel.add(removeTreatmentButton);
        panel.add(removePatientButton);
        viewDataButton.setIcon(dataIcon);
        panel.add(viewDataButton);


        this.add(panel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            // Open the SignupForm
            new SignUpForm();
        }
        if(e.getSource() == addPatientButton){
            new  AddPatientMenu();
        }
    }
    public static void main(String[] args) {
        new AdminMainMenu();
    }

}
