package view;

import control.Hospital;

import javax.swing.*;

public class AdminMainMenu extends JFrame {
    private JButton addDoctorButton;
    private JButton addNurseButton;
    private JButton addDepartmentButton;
    private JButton addDiseaseButton;

    public AdminMainMenu() {
        setTitle("Admin Menu");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Hospital hospital = Hospital.getInstance();

        //Initialize Gui components
        addDoctorButton = new JButton("Add Doctor");
        addNurseButton = new JButton("Add Nurse");
        addDepartmentButton = new JButton("Add Department");
        addDiseaseButton = new JButton("Add Disease");
    }
}
